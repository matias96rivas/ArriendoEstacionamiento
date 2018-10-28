/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.TipoUsu;
import Duoc.Portafolio.Clases.Usuario;
import Duoc.Portafolio.Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Matias
 */
public class DaoUsuario {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public DaoUsuario() {
        cone = new Conexion().obtenerConexion();
    }        
    
    public List<Usuario> listarUsuario(){
        List<Usuario> lista = null;
        
        String sql = "{call sp_listar_usuario}";
        
        if (this.cone != null) {
            try {
                CallableStatement cs = cone.prepareCall(sql);
                
                ResultSet rs = cs.executeQuery();
                lista = new ArrayList<Usuario>();
                
                while (rs.next()) {                    
                    Usuario u = new Usuario();
                    
                    u.setId_usuario(rs.getInt(1));
                    u.setNombre(rs.getString(2));
                    u.setEstado(rs.getInt(3));
                    
                    u.setTipoUsu(rs.getInt(4));
                    
                    lista.add(u);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Problemas al listar usuarios: "+ex.getMessage());
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    cone.close();
                } catch (Exception e) {
                    setMensaje(e.getMessage());
                }
            }
        }else{
            setMensaje("Error en la conexion. ");
        }
        return lista;
    }
    
    public void agregarUsuario(Usuario usuario){
        String sql = "{call sp_agregar_usuario(?,?,?,?)}";
        
        Connection cone = new Conexion().obtenerConexion();
        if (this.cone != null) {
            try {
                CallableStatement cs = cone.prepareCall(sql);
                
                cs.setString(1, usuario.getNombre());
                cs.setString(2, usuario.getPassword());
                cs.setInt(3, usuario.getEstado());
                cs.setInt(4, usuario.getTipoUsu());
                
                int exe = cs.executeUpdate();
                if (exe == 0) {
                    throw new SQLException();
                }
                setMensaje("Usuario agregado correctamente");
                this.cone.close();                
            } catch (SQLException ex) {
                setMensaje("Problemas al agregar un usuario"+ex.getMessage());
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    cone.close();
                } catch (Exception e) {
                    setMensaje(e.getMessage());
                }
            }
        }else{
            setMensaje("Error en la conexion");
        }
    }
    
    public void modificarUsuario(Usuario usuario){
        //Guardo el procedimiento dentro de la varible sql
        String sql = "{call sp_modificar_usuario(?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //
                cs.setInt(1, usuario.getId_usuario());
                //comprobamos que sea exitoso
                int exe = cs.executeUpdate();
                if (exe == 0) {
                    throw new SQLException();
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al modificar los datos de usuario.");
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    cone.close();
                } catch (Exception e) {
                    setMensaje(e.getMessage());
                }
            }
        }else{
            setMensaje("Error en la conexion.");
        }
    }
    
    public int maxId() {
        int ultimoValor = 0;
        if (this.cone != null) {
            try {
                PreparedStatement ps = cone.prepareStatement("SELECT MAX(u.id_usuario) FROM usuario u");
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    ultimoValor = rs.getInt("id_usuario");
                }
                
                ps.close();
                rs.close();
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al rescatar el ultimo. " + ex.getMessage());
                Logger.getLogger(DaoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    cone.close();
                } catch (Exception e) {
                    setMensaje(e.getMessage());
                }
            }
        }else{
            setMensaje("Error en la conexion.");
        }
        return ultimoValor;

    }
}

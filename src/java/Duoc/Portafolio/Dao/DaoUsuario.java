/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.TipoUsu;
import Duoc.Portafolio.Clases.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
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
    
    public List<Usuario> listarUsuario(){
        //creo una lista de usuarios vacia
        List<Usuario> usuarios = null;
        //Guardo el procedimiento dentro de la varible sql
        String sql = "{call sp_listar_usuario(?)}";
        //Compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //Genero el cursor
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto el procedimiento
                cs.executeQuery();
                //Compruebo que el resultado afecto y fue exitoso
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                usuarios = new ArrayList<>();
                //recorro los datos y los seteo
                while (rs.next()) {                    
                    //creo un nuevo usuario
                    Usuario u = new Usuario();
                    
                    u.setId_usuario(rs.getInt(1));
                    u.setNombre(rs.getString(2));
                    u.setPassword(rs.getString(3));
                    //creo un tipo de usuario para setear el id
                    TipoUsu tu = new TipoUsu();
                    tu.setId_tipo_usuario(rs.getInt(4));
                    u.setTipoUsu(tu);
                    //Guardo los datos en la lista
                    usuarios.add(u);
                }
                //cierro la conexion
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar los datos de usuario. "+ex.getMessage());
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
        //retorno la lista
        return usuarios;
    }
    
    public void agregarUsuario(Usuario usuario){
        //Guardo el procedimiento en al variable sql
        String sql = "call sp_agregar_usuario(?,?,?,?)";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //seteo las varibles con los nuevos datos
                cs.setString(1, usuario.getNombre());
                cs.setString(2, usuario.getPassword());
                cs.setInt(3, usuario.getEstado());
                cs.setInt(4, usuario.getTipoUsu().getId_tipo_usuario());
                //compruebo que se haya realizado con exito
                int exe = cs.executeUpdate();
                if (exe == 0) {
                    throw new SQLException();
                }
                setMensaje("Los datos de usuario fueron registrados correctamente.");
                //cierro la conexion
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al registrar los datos de usuario. "+ex.getMessage());
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
}

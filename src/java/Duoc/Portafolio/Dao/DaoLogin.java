/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.TipoUsu;
import Duoc.Portafolio.Clases.Usuario;
import Duoc.Portafolio.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Matias
 */
public class DaoLogin {
    
    Connection cone;

    public DaoLogin() {
        cone = new Conexion().obtenerConexion();
    }
    
    public Usuario existeUsuario(String us, String pass){
        
        try {
            String sql = "SELECT * FROM USUARIO WHERE nombre_usuario = ? AND contrasena = ?";
            
            PreparedStatement stmt = cone.prepareStatement(sql);
            stmt.setString(1, us);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            Usuario u = null;
            if (rs.next()) {
                u = new Usuario();
                u.setId_usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEstado(rs.getInt(4));
                u.setTipoUsu(rs.getInt(5));
            }
            cone.close();
            return u;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public TipoUsu getTipo(int id){
        try {
            String sql = "SELECT * FROM tipo_usuario WHERE id_tipo_usuario = ?";
            
            PreparedStatement ps = cone.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            TipoUsu tu = null;
            if (rs.next()) {
                tu = new TipoUsu();
                tu.setId_tipo_usuario(id);
                tu.setDescripcion(rs.getString(2));
            }
            cone.close();
            return tu;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
}

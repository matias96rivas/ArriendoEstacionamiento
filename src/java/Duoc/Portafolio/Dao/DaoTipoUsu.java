/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.TipoUsu;
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
public class DaoTipoUsu {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<TipoUsu> listarTipoUser(){
        //creo una nueva lista vacia
        List<TipoUsu> tipoUsers = null;
        //guardo el procedimiento en la varible sql
        String sql = "{call sp_listar_tipo_user(?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparamos la llamda del procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //generar un objeto Cursor
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecutamos el procedimiento
                cs.executeQuery();
                //comprobamos que sea exitoso
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convertir la lista en un Array
                tipoUsers = new ArrayList<>();
                //recoremos los datos
                while (rs.next()) {                    
                    //generar un nuevo tipo usuario
                    TipoUsu tu = new TipoUsu();
                    
                    tu.setId_tipo_usuario(rs.getInt(1));
                    tu.setDescripcion(rs.getString(2));
                    //guardamos los datos en la lista
                    tipoUsers.add(tu);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar los tipos de usuarios. "+ex.getMessage());
                Logger.getLogger(DaoTipoUsu.class.getName()).log(Level.SEVERE, null, ex);
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
        //retorno la lista con los datos
        return tipoUsers;
    }
}

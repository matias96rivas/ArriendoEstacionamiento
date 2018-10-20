/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.Marca;
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
public class DaoMarca {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<Marca> listarMarca(){
        //Creo una lista de marcas vacia
        List<Marca> marcas = null;
        //guardo el procedimiento en la varibale sql
        String sql = "{call sp_listar_marca(?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //registro el parametro en el cursor
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto el procedimiento
                cs.executeQuery();
                //compruebo si la llamda fue exitosa
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                marcas = new ArrayList<>();
                
                while (rs.next()) {                    
                    //Creo un objeto tipo marca
                    Marca m = new Marca();
                    //seteo las variables
                    m.setId_marca(rs.getInt(1));
                    m.setDescripcion(rs.getString(2));
                    
                    //guardo el objeto m en la lista
                    marcas.add(m);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar las marcas de los automoviles. "+ex.getMessage());
                Logger.getLogger(DaoMarca.class.getName()).log(Level.SEVERE, null, ex);
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
        return marcas;
    }
}

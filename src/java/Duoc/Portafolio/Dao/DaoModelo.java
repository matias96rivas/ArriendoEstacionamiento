/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.Marca;
import Duoc.Portafolio.Clases.Modelo;
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
public class DaoModelo {
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<Modelo> listarModelo(){
        //creo una lista de modelo vacia
        List<Modelo> modelos = null;
        //guardo el procedimiento en la variable sql
        String sql = "{call sp_listar_modelo}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //registro el parametro
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto el procedimiento
                cs.executeQuery();
                //compruebo con resultset
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                modelos = new ArrayList<>();
                
                while (rs.next()) {                    
                    //Creo un nuevo objeto modelo
                    Modelo m = new Modelo();
                    
                    m.setId_modelo(rs.getInt(1));
                    m.setNombre(rs.getString(2));
                    
                    //Creo una marca para asignarsele el id
                    Marca marca = new Marca();
                    marca.setId_marca(rs.getInt(3));
                    m.setId_marca(marca);
                    
                    //guardo los datos en la lista
                    modelos.add(m);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar los modelos. "+ex.getMessage());
                Logger.getLogger(DaoModelo.class.getName()).log(Level.SEVERE, null, ex);
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
        return modelos;
    }
}

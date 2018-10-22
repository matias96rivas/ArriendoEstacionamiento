/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.Comuna;
import Duoc.Portafolio.Conexion.Conexion;
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
public class DaoComuna {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public DaoComuna() {
        cone = new Conexion().obtenerConexion();
    }  
    
    
    public List<Comuna> listarComuna(){
        //SE crea la lista de comunas vacia
        List<Comuna> comunas = null;
        //guardo el procedmiento dentro de la variable sql
        String sql = "{call sp_listar_comuna(?)}";
        //si la conexion no es nula, se ejecuta el metodo
        if (this.cone != null) {
            try {
                //preparo la conexion
                CallableStatement cs = cone.prepareCall(sql);
                //Le paso un cursor para listar
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto la llamada al procedimiento
                cs.executeQuery();
                //Compruebo resultados
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                comunas = new ArrayList<>();
                
                while (rs.next()) {                    
                    //Creo un objeto comuna
                    Comuna comu = new Comuna();
                    //seteo la info
                    comu.setId_comuna(rs.getInt(1));
                    comu.setNombre_comuna(rs.getString(2));
                    
                    comunas.add(comu);                    
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Problemas al listar. "+ex.getMessage());
                Logger.getLogger(DaoComuna.class.getName()).log(Level.SEVERE, null, ex);
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
        return comunas;
    }
}

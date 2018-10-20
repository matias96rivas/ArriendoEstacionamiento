/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.NivelUbicacion;
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
public class DaoNivelUbicacion {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<NivelUbicacion> listarNivelUbicacion(){
        //creo la lista de niveles vacia
        List<NivelUbicacion> niveles = null;
        //guardo en sql el procedimiento
        String sql = "{call sp_listar_niveles(?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada del procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //Le paso los datos por cursor
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto el procedimiento
                cs.executeQuery();
                //compruebo si fue exitoso
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                niveles = new ArrayList<>();
                
                while (rs.next()) {                    
                    //creo un nivel
                    NivelUbicacion nu = new NivelUbicacion();
                    nu.setId_nivel_ubicacion(rs.getInt(1));
                    nu.setNivel_ubicacion(rs.getInt(2));
                    
                    //agrego los datos a la lista
                    niveles.add(nu);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar los niveles de ubicación. "+ex.getMessage());
                Logger.getLogger(DaoNivelUbicacion.class.getName()).log(Level.SEVERE, null, ex);
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
        //retorno la lista 
        return niveles;
    }
}

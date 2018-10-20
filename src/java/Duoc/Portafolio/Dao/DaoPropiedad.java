/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.NivelUbicacion;
import Duoc.Portafolio.Clases.Propiedad;
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
public class DaoPropiedad {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<Propiedad> listarPropiedad(){
        //creo una lista vacia de propiedad
        List<Propiedad> propiedades = null;
        //guardo el procedimiento dentro de la variable sql
        String sql = "{call sp_listar_propiedad(?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamda del procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //le paso el cursor para listar
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto el procedimiento
                cs.executeQuery();
                //compruebo el exito
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                propiedades = new ArrayList<>();
                
                while (rs.next()) {                    
                    //Creo una variable de tipo Propiedad
                    Propiedad p = new Propiedad();
                    
                    p.setId_propiedad(rs.getInt(1));
                    p.setDescripcion(rs.getString(2));
                    
                    //creo un nivel
                    NivelUbicacion nu = new NivelUbicacion();
                    nu.setId_nivel_ubicacion(rs.getInt(3));
                    p.setId_nivelU(nu);
                    
                    //guardo los datos en la lista
                    propiedades.add(p);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar las propiedades. "+ex.getMessage());
                Logger.getLogger(DaoPropiedad.class.getName()).log(Level.SEVERE, null, ex);
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
        return propiedades;
    }
}

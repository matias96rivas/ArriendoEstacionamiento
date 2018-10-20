/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.Comuna;
import Duoc.Portafolio.Clases.Disponibilidad;
import Duoc.Portafolio.Clases.DuenoEstacionamiento;
import Duoc.Portafolio.Clases.Estacionamiento;
import Duoc.Portafolio.Clases.Habilitacion;
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
public class DaoEstacionamiento {

    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Estacionamiento> listarEstacionamiento() {
        //Creo una lista vacia de estacionamientos
        List<Estacionamiento> estacionamientos = null;
        //guardo el procedimiento en la variable sql
        String sql = "{call sp_listar_estacionamiento(?)}";
        //si la conexion no es nula, se ejecuta el metodo
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //le paso un cursor para listar
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto el procedimiento
                cs.executeQuery();
                //verifico que haya sido exitoso
                ResultSet rs = (ResultSet) cs.getObject(1);
                //la lista la convierto en un Array
                estacionamientos = new ArrayList<>();

                while (rs.next()) {
                    //Creo un nuevo estacionamiento
                    Estacionamiento est = new Estacionamiento();
                    
                    est.setId_estacionamiento(rs.getInt(1));
                    
                    //propiedad
                    Propiedad p = new Propiedad();
                    p.setId_propiedad(rs.getInt(2));
                    est.setPropiedad(p);
                    
                    //comuna
                    Comuna c = new Comuna();
                    c.setId_comuna(rs.getInt(3));
                    est.setComuna(c);
                    
                    //dueño
                    DuenoEstacionamiento de = new DuenoEstacionamiento();
                    de.setRut_dueno(rs.getString(4));
                    est.setDueno(de);
                    
                    //disponibilidad
                    Disponibilidad d = new Disponibilidad();
                    d.setId_disponibilidad(rs.getInt(5));
                    est.setDisponibilidad(d);
                    
                    //habilitacion
                    Habilitacion h = new Habilitacion();
                    h.setId_habilitacion(rs.getInt(6));
                    est.setHabilitacion(h);
                    
                    estacionamientos.add(est);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Problemas al listar los estacionamientos. " + ex.getMessage());
                Logger.getLogger(DaoEstacionamiento.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    cone.close();
                } catch (Exception e) {
                    setMensaje(e.getMessage());
                }
            }
        } else {
            setMensaje("Error en la conexion.");
        }
        return estacionamientos;
    }
    
    public void agregarEstacionamiento(Estacionamiento estacionamiento){
        //guardo el procedimiento en la variable sql
        String sql = "{call sp_agregar_estacionamiento(?,?,?,?,?,?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                
                cs.setInt(1, estacionamiento.getId_estacionamiento());
                cs.setInt(2, estacionamiento.getPropiedad().getId_propiedad());
                cs.setInt(3, estacionamiento.getComuna().getId_comuna());
                cs.setString(4, estacionamiento.getDueno().getRut_dueno());
                cs.setInt(5, estacionamiento.getDisponibilidad().getId_disponibilidad());
                cs.setInt(6, estacionamiento.getHabilitacion().getId_habilitacion());
                
                int exe = cs.executeUpdate();
                
                if (exe == 0) {
                    throw new SQLException();
                }                
                setMensaje("Registro realizado con exito.");
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al registrar un estacionamiento. "+ex.getMessage());
                Logger.getLogger(DaoEstacionamiento.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void modificarEstacionamiento(Estacionamiento estacionamiento){
        //guardo el procedimiento en la variable sql 
        String sql = "{call sp_modificar_estacionamiento(?)}";
        //valido que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada
                CallableStatement cs = cone.prepareCall(sql);
                cs.setInt(1, estacionamiento.getId_estacionamiento());
                 
                int exe = cs.executeUpdate();
                
                if (exe == 0) {
                    throw new SQLException();
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al modificar el estacionamiento. "+ex.getMessage());
                Logger.getLogger(DaoEstacionamiento.class.getName()).log(Level.SEVERE, null, ex);
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


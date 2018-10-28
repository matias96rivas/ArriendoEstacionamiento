/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.Marca;
import Duoc.Portafolio.Clases.Vehiculo;
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
public class DaoVehiculo {

    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Vehiculo> listarVehiculo() {
        //creo una lista de vehiculos vacia
        List<Vehiculo> vehiculos = null;
        //guardo el procedimiento en la variable sql
        String sql = "{call sp_listar_vehiculo(?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamda del procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //registro el cursor
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto el procedimiento
                cs.executeQuery();
                //compruebo que se haya realizado con exito
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                vehiculos = new ArrayList<>();
                //recorro los datos
                while (rs.next()) {
                    //creo un nuevo vehiculo
                    Vehiculo v = new Vehiculo();

                    v.setPatente(rs.getString(1));
                    v.setAnio(rs.getInt(2));
                    v.setId_marca(rs.getInt(3));
                    //guardo los datos en la lista
                    vehiculos.add(v);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar los datos del vehiculo. " + ex.getMessage());
                Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
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
        //retorno la lista
        return vehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        //guardo el procedimineto dentro de la varible sql
        String sql = "{call sp_agregar_vehiculo(?,?,?,?)}";
        //compruebo que la coexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //seteo los datos
                cs.setString(1, vehiculo.getPatente());
                cs.setInt(2, vehiculo.getAnio());
                cs.setInt(3, vehiculo.getId_marca());
                //compruebo que haya sido exitoso
                int exe = cs.executeUpdate();
                if (exe == 0) {
                    throw new SQLException();
                }
                //si todo es correcto, muestro el mensaje
                setMensaje("Los datos del vehiculo han sido registrados correctamente.");
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al registrar los datos del vehiculo. " + ex.getMessage());
                Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
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
    }

    public void modificarVehiculo(Vehiculo vehiculo) {
        //guardo el procedimiento en la variable sql
        String sql = "{call sp_modificar_vehiculo(?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada del procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                cs.setString(1, vehiculo.getPatente());
                //compruebo si fue exitoso
                int exe = cs.executeUpdate();
                if (exe == 0) {
                    throw new SQLException();
                }
                //si todo es correcto, muestro mensaje
                setMensaje("Los datos del vehiculo de modificaron con exito.");
                //cierro la conexion
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al modificar los datos del vehiculo. " + ex.getMessage());
                Logger
                        .getLogger(DaoVehiculo.class
                                .getName()).log(Level.SEVERE, null, ex);
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
    }
}

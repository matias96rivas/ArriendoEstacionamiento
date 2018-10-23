/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.Tarjeta;
import Duoc.Portafolio.Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Matias
 */
public class DaoTarjeta {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public DaoTarjeta() {
        cone = new Conexion().obtenerConexion();
    }
    
       
    public List<Tarjeta> listarTarjeta(){
        //Creo una nueva lista vacia
        List<Tarjeta> tarjetas = null;
        //Guardo el procedimiento en la variable
        String sql = "{call sp_listar_tarjeta(?)}";
       //Compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //Genero el cursor
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto la llamada
                cs.executeQuery();
                //compruebo errores
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                tarjetas = new ArrayList<>();
                //Recorro los datos
                while (rs.next()) {                    
                    //creo una nueva tarjeta
                    Tarjeta t = new Tarjeta();
                    t.setId_tarjeta(rs.getInt(1));
                    t.setNum_tarjeta(rs.getInt(2));
                    //le doy formato a la fecha
                    Timestamp tsFecha = rs.getTimestamp(3);
                    t.setFecha_expiracion(tsFecha);
                    
                    //Agrego los datos a la tabla
                    tarjetas.add(t);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar los datos de tarjeta. "+ex.getMessage());
                Logger.getLogger(DaoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
        return tarjetas;
    }
    
    public void agregarTarjeta(Tarjeta tarjeta){
        //guardo el procedimiento en sql
        String sql = "{call sp_agregar_tarjeta(?,?)}";
        //Compruebo que la conexion no se nula
        
        Connection cone = new Conexion().obtenerConexion();
        if (this.cone != null) {
            try {
                //preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //cargo los datos
                cs.setInt(1, tarjeta.getNum_tarjeta());
                cs.setDate(2, (Date) tarjeta.getFecha_expiracion());
                //compruebo que fue exitoso
                int exe = cs.executeUpdate();
                if (exe == 0) {
                    throw new SQLException();                    
                }
                setMensaje("Los datos de la tarjeta fueron almacenados correctamente.");
                //cierro la conexion
                this.cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al registrar los datos de la tarjeta. "+ex.getMessage());
                Logger.getLogger(DaoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
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


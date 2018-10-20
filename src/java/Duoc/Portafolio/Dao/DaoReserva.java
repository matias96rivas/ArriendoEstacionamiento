/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.Comision;
import Duoc.Portafolio.Clases.Estacionamiento;
import Duoc.Portafolio.Clases.Pago;
import Duoc.Portafolio.Clases.Reserva;
import Duoc.Portafolio.Clases.Vehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Matias
 */
public class DaoReserva {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<Reserva> listarReserva(){
        //creo una lista vacia
        List<Reserva> reservas = null;
        //guardo el procedimiento en sql
        String sql = "{call sp_listar_reserva(?)}";
        //compruebo que la conexion no sea mula
        if (this.cone != null) {
            try {
                //preparo el procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //paso la info al cursor
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto el procedimiento
                cs.executeQuery();
                //compruebo si fue exitoso
                ResultSet rs = (ResultSet) cs.getObject(1);
                //convierto la lista en un Array
                reservas = new ArrayList<>();
                
                while (rs.next()) {                    
                    //Creo un objt reserva
                    Reserva r = new Reserva();
                    
                    r.setId_reserva(rs.getInt(1));
                    //seteo la fecha
                    Timestamp tsFecha = rs.getTimestamp(2);
                    r.setFecha_reserva(tsFecha);
                    //seteo las horas
                    Timestamp tsHoraI = rs.getTimestamp(3);
                    r.setHora_ingreso(tsHoraI);
                    Timestamp tsHoraS = rs.getTimestamp(4);
                    r.setHora_salida(tsHoraS);
                    r.setValor_tarifa(rs.getInt(5));
                    r.setHoras_totales(rs.getInt(6));
                    r.setValor_bruto(rs.getInt(7));
                    r.setValor_neto(rs.getInt(8));
                    
                    //Estacionamiento
                    Estacionamiento e = new Estacionamiento();
                    e.setId_estacionamiento(rs.getInt(9));
                    r.setId_estacionamiento(e);
                    
                    //Comision
                    Comision c = new Comision();
                    c.setId_comision(rs.getInt(10));
                    r.setId_comsion(c);
                    
                    //Pago
                    Pago p = new Pago();
                    p.setId_pago(rs.getInt(11));
                    r.setId_pago(p);
                    
                    //Vehiculo
                    Vehiculo v = new Vehiculo();
                    v.setPatente(rs.getString(12));
                    r.setPatente_vehiculo(v);
                    
                    //guardo los datos en la lista
                    reservas.add(r);                    
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar las reservas. "+ex.getMessage());
                Logger.getLogger(DaoReserva.class.getName()).log(Level.SEVERE, null, ex);
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
        return reservas;
    }
    
    public void agregarReserva(Reserva reserva){
        //Guardo el procedimiento en la varible sql
        String sql = "{call sp_agregar_reserva(?,?,?,?,?,?,?,?,?,?,?)}";
        //compruebo que la conexion no sea nula
        if (this.cone != null) {
            try {
                //Preparo la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                
                cs.setDate(1, (Date) reserva.getFecha_reserva());
                cs.setDate(2, (Date) reserva.getHora_ingreso());
                cs.setDate(3, (Date) reserva.getHora_salida());
                cs.setInt(4, reserva.getValor_tarifa());
                cs.setInt(5, reserva.getHoras_totales());
                cs.setInt(6, reserva.getValor_bruto());
                cs.setInt(7, reserva.getValor_neto());
                cs.setInt(8, reserva.getId_estacionamiento().getId_estacionamiento());
                cs.setInt(9, reserva.getId_comsion().getId_comision());
                cs.setInt(10, reserva.getId_pago().getId_pago());
                cs.setString(11, reserva.getPatente_vehiculo().getPatente());
                
                //compruebo que fue exitoso
                int exe = cs.executeUpdate();
                if (exe == 0) {
                    throw new SQLException();
                }
                setMensaje("Reserva realizada con exito.");
                //cierro la conexion
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al ralizar la reserva. "+ex.getMessage());
                Logger.getLogger(DaoReserva.class.getName()).log(Level.SEVERE, null, ex);
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

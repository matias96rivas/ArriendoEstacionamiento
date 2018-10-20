/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.ClienteArrendador;
import Duoc.Portafolio.Clases.Tarjeta;
import Duoc.Portafolio.Clases.Usuario;
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
public class DaoClienteArrendador {
    
    Connection cone;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<ClienteArrendador> listarClienteArrendador(){
        //Creo una lista vacia
        List<ClienteArrendador> clientes = null;
        //Guardo el procedimiento en la variable sql
        String sql = "{call sp_listar_cliente_arrendador(?)}";
        //Si la conexion no es nula se ejecuta el metodo
        if (this.cone != null) {
            try {
                //se prepara la llamada al procedimiento
                CallableStatement cs = cone.prepareCall(sql);
                //le paso un cursor a la sentencia
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //ejecuto la consulta guardada en sql
                cs.executeQuery();
                //
                ResultSet rs = (ResultSet) cs.getObject(1);
                //Convierto la lista en un Array
                clientes = new ArrayList<>();
                
                while (rs.next()) {                    
                    
                    //se crea un nuevo cliente
                    ClienteArrendador ca = new ClienteArrendador();
                    //paso los datos desde la DB
                    ca.setRut_arrendador(rs.getString(1));
                    
                    //Se crea un usuario
                    Usuario u = new Usuario();
                    u.setId_usuario(rs.getInt(2));
                    ca.setId_usuario(u);
                    
                    ca.setNombre(rs.getString(3));
                    ca.setApellido(rs.getString(4));
                    
                    //le doy formato a la fecha
                    Timestamp tsFechaN = rs.getTimestamp(5);
                    ca.setFecha_nacimiento(tsFechaN);
                    
                    ca.setCorreo_electronico(rs.getString(6));
                    
                    //Se crean una tarjeta pra pasar su id
                    Tarjeta t = new Tarjeta();
                    t.setId_tarjeta(rs.getInt(7));
                    ca.setId_tarjeta(t);
                    
                    clientes.add(ca);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al listar. "+ex.getMessage());
                Logger.getLogger(DaoClienteArrendador.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    cone.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }else{
            setMensaje("Error en la conexion");
        }
        return clientes;
    }
    
    public void agregarClienteArrendador(ClienteArrendador cliente){
        //Llamo al procedimiento 
        String sql = "{call sp_agregar_cliente_arrendador(?,?,?,?,?,?,?)}";
        //Si la conexion en distinta de null ejecuto el metodo
        if (this.cone != null) {
            try {
                //preparo la llamada
                CallableStatement cs = cone.prepareCall(sql);
                
                cs.setString(1, cliente.getRut_arrendador());
                cs.setInt(2, cliente.getId_usuario().getId_usuario());
                cs.setString(3, cliente.getNombre());
                cs.setString(4, cliente.getApellido());
                cs.setDate(5, (Date) cliente.getFecha_nacimiento());
                cs.setString(6, cliente.getCorreo_electronico());
                cs.setInt(7, cliente.getId_tarjeta().getId_tarjeta());
                //variable para verificar si se completo el registro
                int exe = cs.executeUpdate();
                //si no se completo el registro, la varible quedará en 0
                if (exe == 0) {
                    throw new SQLException();
                }
                setMensaje("Registro realizado con exito.");
                cone.close();
                
            } catch (SQLException ex) {
                setMensaje("Problema al agregar cliente Arrendador. "+ex.getMessage());
                Logger.getLogger(DaoClienteArrendador.class.getName()).log(Level.SEVERE, null, ex);
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
    }
    
    public void modificarCliente(ClienteArrendador cliente){
        //guardo el procedimiento en la variable sql
        String sql = "{call sp_modificar_cliente_arrend(?)}";
        //si la conexion no es nula, se ejevuta el metodo
        if (this.cone != null) {
            try {
                //preparo la llamada
                CallableStatement cs = cone.prepareCall(sql);
                cs.setString(1, cliente.getRut_arrendador());
                
                int exe = cs.executeUpdate();
                if (exe == 0) {
                    throw new SQLException();
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al modificar. "+ex.getMessage());
                Logger.getLogger(DaoClienteArrendador.class.getName()).log(Level.SEVERE, null, ex);
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

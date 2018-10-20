/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Dao;

import Duoc.Portafolio.Clases.DuenoEstacionamiento;
import Duoc.Portafolio.Clases.Tarjeta;
import Duoc.Portafolio.Clases.Usuario;
import Duoc.Portafolio.Conexion.Conexion;
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
public class DaoDuenoEstacionamiento {
    
    Connection cone;
    private String mensaje;

    public DaoDuenoEstacionamiento() {
        cone = new Conexion().obtenerConexion();
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<DuenoEstacionamiento> ListarDuenoEstacionamiento(){
        //Se genera la lista de dueños
        List<DuenoEstacionamiento> duenos = null;
        
        //Se llama al procedimiento
        String sql = "{call sp_listar_dueno_estac(?)}";
        if (this.cone != null) {
            try {
                //Prepara la llamada del procedmiento
                CallableStatement cs = cone.prepareCall(sql);
                
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                //se ejecuta el prcedimiento
                cs.executeQuery();
                ResultSet rs = (ResultSet) cs.getObject(1);
                
                //La lista dueños se pasa a un ArrayList vacio
                duenos = new ArrayList<>();
                
                //Mientras el resultado de la query pase al siguiente, se llenaran los datos desde DB
                while (rs.next()) {                    
                    //Se crea un usuario dueño
                    DuenoEstacionamiento de = new DuenoEstacionamiento();
                    
                    //Se cargan los datos
                    de.setRut_dueno(rs.getString(1));
                    de.setApellido(rs.getString(2));
                    de.setCorreo_electronico(rs.getString(3));
                    de.setDireccion(rs.getString(4));
                    
                    //Le doy un formato a la fehca de nacimiento
                    Timestamp tsFechaN = rs.getTimestamp(5);
                    de.setFecha_nacimiento(tsFechaN);
                    
                    de.setNombre(rs.getString(6));
                    
                    //Se crea una nueva tarjeta para retornar los datos a id_tarjeta
                    Tarjeta t = new Tarjeta();
                    t.setId_tarjeta(rs.getInt(7));
                    //Le paso el id_tarjeta 
                    de.setId_tarjeta(t);
                    
                    //Se crea un usuario para retornar su valor a
                    Usuario u = new Usuario();
                    u.setId_usuario(rs.getInt(8));
                    //le paso el id_usuario
                    de.setId_usuario(u);
                    
                    duenos.add(de);
                }
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Problema al listar. "+ex.getMessage());
                Logger.getLogger(DaoDuenoEstacionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    cone.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }            
        }else{
            setMensaje("Error en la conexion.");
        }
        return duenos;
    }    
    
    public void agregarDuenoEstacionamiento(DuenoEstacionamiento dueno){
        //Llamo al procedimiento y lo guardo en la variable sql
        String sql = "{call sp_agregar_dueno(?,?,?,?,?,?,?,?)}";
        
        //Si la conexion es distinta de nulo se ejecuta el try
        if (this.cone != null) {
            try {
                //preparo el procedimiento en la llamada
                CallableStatement cs = cone.prepareCall(sql);
                
                //recorro los datos para gurdarlos
                cs.setString(1, dueno.getRut_dueno());
                cs.setString(2, dueno.getNombre());
                cs.setString(3, dueno.getApellido());
                cs.setDate(4, (Date) dueno.getFecha_nacimiento());
                cs.setString(5, dueno.getCorreo_electronico());
                cs.setString(6, dueno.getDireccion());
                cs.setInt(7, dueno.getId_tarjeta().getId_tarjeta());
                cs.setInt(8, dueno.getId_usuario().getId_usuario());
                
                //creo la variable exe para saber si hay excepciones
                int exe = cs.executeUpdate();
                //Si la ejecucion retorna 0, es porque no se agrego por lo cual, genero una excepcion
                if (exe == 0) {
                    throw new SQLException();
                }
                //seteo el mensaje para mosntrar en pantalla
                setMensaje("Registro realizado con exito");
                //Cierro la conexion
                cone.close();
                
            } catch (SQLException ex) {
                setMensaje("Problema al agregar dueño de estacionamiento. "+ex.getMessage());
                Logger.getLogger(DaoDuenoEstacionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    cone.close();
                } catch (Exception e) {
                    setMensaje(e.getMessage());
                }
            }
        }else{
            setMensaje("Error en la conexión.");
        }      
    }
    
    public void modificarDueno(DuenoEstacionamiento dueno){
        //Guardo el procedimiento en la varible sql
        String sql = "{call sp_modificar_dueno_est(?)}";
        //si la conexion no es nula se ejcuta el metodo
        if (this.cone != null) {
            //Genero try para capturar las excepciones
            try {
                //Preparo la llamada del procecimiento
                CallableStatement cs = cone.prepareCall(sql);
                cs.setString(1, dueno.getRut_dueno());
                
                //compruebo que se haya ejecutado correctamente
                int exe = cs.executeUpdate();
                //Si la respuesta no afecta filas, capturo excepcion
                if (exe == 0) {
                    throw new SQLException();
                }
                //cierro la conexion
                cone.close();
            } catch (SQLException ex) {
                setMensaje("Error al modificar. "+ex.getMessage());
                Logger.getLogger(DaoDuenoEstacionamiento.class.getName()).log(Level.SEVERE, null, ex);
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
}

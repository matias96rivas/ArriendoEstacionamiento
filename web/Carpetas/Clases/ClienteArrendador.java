package Carpetas.Clases;

  
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dheler!
 */
public class ClienteArrendador {
    private String rut_arrendador;
    private Usuario id_usuario;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String correo_electronico;
    private Tarjeta id_tarjeta;
    
    
    
    public ClienteArrendador(){
        
    }
    
    public ClienteArrendador(String rut_arrendador,Usuario id_usuario,String nombre, String apellido, Date fecha_nacimiento, String correo_electronico, Tarjeta id_tarjeta){
    this.rut_arrendador = rut_arrendador;
    this.id_usuario = id_usuario;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha_nacimiento = fecha_nacimiento;
    this.correo_electronico = correo_electronico;
    this.id_tarjeta = id_tarjeta;
    }

    public String getRut_arrendador() {
        return rut_arrendador;
    }

    public void setRut_arrendador(String rut_arrendador) {
        this.rut_arrendador = rut_arrendador;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public Tarjeta getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(Tarjeta id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }
    
    
    
}

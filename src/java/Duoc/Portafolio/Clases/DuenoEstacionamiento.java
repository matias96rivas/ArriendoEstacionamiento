package Duoc.Portafolio.Clases;

   
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
public class DuenoEstacionamiento {
    private String rut_dueno;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String correo_electronico;
    private String direccion;
    private Tarjeta id_tarjeta;
    private Usuario id_usuario;

    
    public DuenoEstacionamiento(String rut_dueno, String nombre, String apellido, Date fecha_nacimiento, String correo_electronico,String Direccion, Tarjeta id_tarjeta, Usuario id_usuario){
    this.rut_dueno= rut_dueno;
    this.nombre=nombre;
    this.apellido=apellido;
    this.fecha_nacimiento=fecha_nacimiento;
    this.correo_electronico= correo_electronico;
    this.direccion=Direccion;
    this.id_tarjeta=id_tarjeta;
    this.id_usuario=id_usuario;
    }
    
    public DuenoEstacionamiento(){
        
    }
    
    public String getRut_dueno() {
        return rut_dueno;
    }

    public void setRut_dueno(String rut_dueno) {
        this.rut_dueno = rut_dueno;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Tarjeta getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(Tarjeta id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}

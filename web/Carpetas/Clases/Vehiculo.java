package Carpetas.Clases;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dheler!
 */
public class Vehiculo {
    private String patente;
    private int anio;
    private Marca id_marca;
    private String rut_usuario;

    public Vehiculo(String patente, int anio, Marca id_marca, String rut_usuario){
    this.patente=patente;
    this.anio=anio;
    this.id_marca=id_marca;
    this.rut_usuario=rut_usuario;   
    }
    public Vehiculo(){
        
    }
    
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Marca getId_marca() {
        return id_marca;
    }

    public void setId_marca(Marca id_marca) {
        this.id_marca = id_marca;
    }

    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }
    
    
    
}

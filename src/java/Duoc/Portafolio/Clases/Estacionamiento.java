/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Clases;

/**
 *
 * @author Dheler!
 */
public class Estacionamiento {
    
    private int id_estacionamiento;
    private Propiedad propiedad;
    private Comuna comuna;
    private DuenoEstacionamiento dueno;
    private Disponibilidad disponibilidad;
    private Habilitacion habilitacion;

    public Estacionamiento() {
    }

    public Estacionamiento(int id_estacionamiento, Propiedad propiedad, Comuna comuna, DuenoEstacionamiento dueno, Disponibilidad disponibilidad, Habilitacion habilitacion) {
        this.id_estacionamiento = id_estacionamiento;
        this.propiedad = propiedad;
        this.comuna = comuna;
        this.dueno = dueno;
        this.disponibilidad = disponibilidad;
        this.habilitacion = habilitacion;
    }

    public int getId_estacionamiento() {
        return id_estacionamiento;
    }

    public void setId_estacionamiento(int id_estacionamiento) {
        this.id_estacionamiento = id_estacionamiento;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public DuenoEstacionamiento getDueno() {
        return dueno;
    }

    public void setDueno(DuenoEstacionamiento dueno) {
        this.dueno = dueno;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Habilitacion getHabilitacion() {
        return habilitacion;
    }

    public void setHabilitacion(Habilitacion habilitacion) {
        this.habilitacion = habilitacion;
    }
    
    
}

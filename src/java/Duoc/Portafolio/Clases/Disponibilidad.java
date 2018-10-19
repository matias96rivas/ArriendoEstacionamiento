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
public class Disponibilidad {
private Estacionamiento id_esEstacionamiento;
private int id_disponibilidad;
private int disponibilidad;

    public Disponibilidad() {
    }



    public Disponibilidad(Estacionamiento id_esEstacionamiento, int id_disponibilidad, int disponibilidad) {
        this.id_esEstacionamiento = id_esEstacionamiento;
        this.id_disponibilidad = id_disponibilidad;
        this.disponibilidad = disponibilidad;
    }



    public Estacionamiento getId_esEstacionamiento() {
        return id_esEstacionamiento;
    }

    public void setId_esEstacionamiento(Estacionamiento id_esEstacionamiento) {
        this.id_esEstacionamiento = id_esEstacionamiento;
    }

    public int getId_disponibilidad() {
        return id_disponibilidad;
    }

    public void setId_disponibilidad(int id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


}

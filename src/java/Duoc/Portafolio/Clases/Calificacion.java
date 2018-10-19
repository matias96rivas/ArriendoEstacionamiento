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
public class Calificacion {
private int id_calificacion;
private int calificacion;

public Calificacion(){
    
}

    public Calificacion(int id_calificacion, int calificacion) {
        this.id_calificacion = id_calificacion;
        this.calificacion = calificacion;
    }

    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


}

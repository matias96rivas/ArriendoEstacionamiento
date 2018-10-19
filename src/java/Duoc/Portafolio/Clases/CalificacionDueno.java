/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Clases;

import java.util.Date;

/**
 *
 * @author Dheler!
 */
public class CalificacionDueno {
private int id_calificacion_dueno;
private Date fecha;
private int promedio;
private DuenoEstacionamiento rut_dueno;
private Calificacion id_calificacion;

    public CalificacionDueno() {
    }


    public CalificacionDueno(int id_calificacion_dueno, Date fecha, int promedio, DuenoEstacionamiento rut_dueno, Calificacion id_calificacion) {
        this.id_calificacion_dueno = id_calificacion_dueno;
        this.fecha = fecha;
        this.promedio = promedio;
        this.rut_dueno = rut_dueno;
        this.id_calificacion = id_calificacion;
    }


    public int getId_calificacion_dueno() {
        return id_calificacion_dueno;
    }

    public void setId_calificacion_dueno(int id_calificacion_dueno) {
        this.id_calificacion_dueno = id_calificacion_dueno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public DuenoEstacionamiento getRut_dueno() {
        return rut_dueno;
    }

    public void setRut_dueno(DuenoEstacionamiento rut_dueno) {
        this.rut_dueno = rut_dueno;
    }

    public Calificacion getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Calificacion id_calificacion) {
        this.id_calificacion = id_calificacion;
    }


}

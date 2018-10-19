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
public class CalificacionCliente {
private int id_calificacion_cliente;
private Date fecha;
private int promedio;
private ClienteArrendador rut_cliente;
private Calificacion id_calificacion;

    public CalificacionCliente() {
    }


    public CalificacionCliente(int id_calificacion_cliente, Date fecha, int promedio, ClienteArrendador rut_cliente, Calificacion id_calificacion) {
        this.id_calificacion_cliente = id_calificacion_cliente;
        this.fecha = fecha;
        this.promedio = promedio;
        this.rut_cliente = rut_cliente;
        this.id_calificacion = id_calificacion;
    }


    public int getId_calificacion_cliente() {
        return id_calificacion_cliente;
    }

    public void setId_calificacion_cliente(int id_calificacion_cliente) {
        this.id_calificacion_cliente = id_calificacion_cliente;
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

    public ClienteArrendador getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(ClienteArrendador rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public Calificacion getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Calificacion id_calificacion) {
        this.id_calificacion = id_calificacion;
    }



}

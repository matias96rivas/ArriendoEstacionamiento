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
public class PeriodoPago {
 private int id_periodo;
 private String descripcion;
 
 public PeriodoPago(int id_periodo, String descripcion){
 this.id_periodo=id_periodo;
 this.descripcion=descripcion;
 }
 
 public PeriodoPago(){
     
 }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
 
}

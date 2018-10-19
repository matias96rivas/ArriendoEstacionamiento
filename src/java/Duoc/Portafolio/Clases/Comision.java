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
public class Comision {
 private int id_comision;
 private int porcentaje;
 
 public Comision(int id_comision, int porcentaje){
 this.id_comision=id_comision;
 this.porcentaje=porcentaje;
 }
 
 public Comision(){
     
 }

    public int getId_comision() {
        return id_comision;
    }

    public void setId_comision(int id_comision) {
        this.id_comision = id_comision;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
 
 
 
}

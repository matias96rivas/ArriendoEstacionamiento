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
public class Habilitacion {
    private int id_habilitacion;
    private int estado_habilitacion;

    public Habilitacion() {
    }
    
    

    public Habilitacion(int id_habilitacion, int estado_habilitacion) {
        this.id_habilitacion = id_habilitacion;
        this.estado_habilitacion = estado_habilitacion;
    }
    
    

    public int getId_habilitacion() {
        return id_habilitacion;
    }

    public void setId_habilitacion(int id_habilitacion) {
        this.id_habilitacion = id_habilitacion;
    }

    public int getEstado_habilitacion() {
        return estado_habilitacion;
    }

    public void setEstado_habilitacion(int estado_habilitacion) {
        this.estado_habilitacion = estado_habilitacion;
    }
    
    
    
}

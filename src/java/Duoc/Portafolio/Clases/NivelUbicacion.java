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
public class NivelUbicacion {
private int id_nivel_ubicacion;
private int nivel_ubicacion;

    public NivelUbicacion() {
    }



    public NivelUbicacion(int id_nivel_ubicacion, int nivel_ubicacion) {
        this.id_nivel_ubicacion = id_nivel_ubicacion;
        this.nivel_ubicacion = nivel_ubicacion;
    }



    public int getId_nivel_ubicacion() {
        return id_nivel_ubicacion;
    }

    public void setId_nivel_ubicacion(int id_nivel_ubicacion) {
        this.id_nivel_ubicacion = id_nivel_ubicacion;
    }

    public int getNivel_ubicacion() {
        return nivel_ubicacion;
    }

    public void setNivel_ubicacion(int nivel_ubicacion) {
        this.nivel_ubicacion = nivel_ubicacion;
    }


}

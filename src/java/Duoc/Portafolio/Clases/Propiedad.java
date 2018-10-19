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
public class Propiedad {
private int id_propiedad;
private String descripcion;
private NivelUbicacion id_nivelU;

    public Propiedad() {
    }

    public Propiedad(int id_propiedad, String descripcion, NivelUbicacion id_nivelU) {
        this.id_propiedad = id_propiedad;
        this.descripcion = descripcion;
        this.id_nivelU = id_nivelU;
    }



    public int getId_propiedad() {
        return id_propiedad;
    }

    public void setId_propiedad(int id_propiedad) {
        this.id_propiedad = id_propiedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NivelUbicacion getId_nivelU() {
        return id_nivelU;
    }

    public void setId_nivelU(NivelUbicacion id_nivelU) {
        this.id_nivelU = id_nivelU;
    }


}

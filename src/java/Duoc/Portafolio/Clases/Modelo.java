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
public class Modelo {
 private int id_modelo;
 private String nombre;
 private Marca id_marca;

    public Modelo() {
    }
 
 

    public Modelo(int id_modelo, String nombre, Marca id_marca) {
        this.id_modelo = id_modelo;
        this.nombre = nombre;
        this.id_marca = id_marca;
    }
 
 

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getId_marca() {
        return id_marca;
    }

    public void setId_marca(Marca id_marca) {
        this.id_marca = id_marca;
    }
 
 
 
}

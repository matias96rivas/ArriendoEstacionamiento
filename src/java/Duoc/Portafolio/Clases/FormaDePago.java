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
public class FormaDePago {
private int id_formaPago;
private String descripcion;
private Pago id_pago;

    public FormaDePago() {
    }



    public FormaDePago(int id_formaPago, String descripcion, Pago id_pago) {
        this.id_formaPago = id_formaPago;
        this.descripcion = descripcion;
        this.id_pago = id_pago;
    }



    public int getId_formaPago() {
        return id_formaPago;
    }

    public void setId_formaPago(int id_formaPago) {
        this.id_formaPago = id_formaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pago getId_pago() {
        return id_pago;
    }

    public void setId_pago(Pago id_pago) {
        this.id_pago = id_pago;
    }


}

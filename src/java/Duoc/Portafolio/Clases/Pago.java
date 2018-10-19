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
public class Pago {
private int id_pago;
private int id_periodo_pago;
private Date fecha_pago;


public Pago(int id_pago, int id_periodo_pago, Date fecha_pago){
this.id_pago=id_pago;
this.id_periodo_pago=id_periodo_pago;
this.fecha_pago = fecha_pago;
}
public Pago(){
    
}

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_periodo_pago() {
        return id_periodo_pago;
    }

    public void setId_periodo_pago(int id_periodo_pago) {
        this.id_periodo_pago = id_periodo_pago;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }


}

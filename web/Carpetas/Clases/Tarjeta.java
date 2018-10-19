package Carpetas.Clases;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dheler!
 */
public class Tarjeta {
    private int id_tarjeta;
    private int num_tarjeta;
    private Date fecha_expiracion;

    public Tarjeta(int id_tarjeta, int num_tarjeta, Date fecha_expiracion){
    this.id_tarjeta = id_tarjeta;
    this.num_tarjeta= num_tarjeta;
    this.fecha_expiracion= fecha_expiracion;
    }
        
     public Tarjeta(){
         
     }
    public int getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(int num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public Date getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }
    
    
}

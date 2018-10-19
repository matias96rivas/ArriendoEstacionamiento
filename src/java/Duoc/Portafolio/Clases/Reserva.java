package Duoc.Portafolio.Clases;
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
public class Reserva {
    private int id_reserva;
    private Date fecha_reserva;
    private Date hora_ingreso;
    private Date hora_salida;
    private int valor_tarifa;
    private int horas_totales;
    private int valor_bruto;
    private int valor_neto;
    private Estacionamiento id_estacionamiento;
    private Comision id_comsion;
    private Pago id_pago;
    private Vehiculo patente_vehiculo;
    
    

    public Reserva(int id_reserva, Date fecha_reserva, Date hora_ingreso, Date hora_salida, int valor_tarifa, int horas_totales, int valor_bruto, int valor_neto, Estacionamiento id_estacionamiento, Comision id_comsion, Pago id_pago, Vehiculo patente_vehiculo) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
        this.valor_tarifa = valor_tarifa;
        this.horas_totales = horas_totales;
        this.valor_bruto = valor_bruto;
        this.valor_neto = valor_neto;
        this.id_estacionamiento = id_estacionamiento;
        this.id_comsion = id_comsion;
        this.id_pago = id_pago;
        this.patente_vehiculo = patente_vehiculo;
    }
    
    

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(Date hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public Date getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Date hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getValor_tarifa() {
        return valor_tarifa;
    }

    public void setValor_tarifa(int valor_tarifa) {
        this.valor_tarifa = valor_tarifa;
    }

    public int getHoras_totales() {
        return horas_totales;
    }

    public void setHoras_totales(int horas_totales) {
        this.horas_totales = horas_totales;
    }

    public int getValor_bruto() {
        return valor_bruto;
    }

    public void setValor_bruto(int valor_bruto) {
        this.valor_bruto = valor_bruto;
    }

    public int getValor_neto() {
        return valor_neto;
    }

    public void setValor_neto(int valor_neto) {
        this.valor_neto = valor_neto;
    }

    public Estacionamiento getId_estacionamiento() {
        return id_estacionamiento;
    }

    public void setId_estacionamiento(Estacionamiento id_estacionamiento) {
        this.id_estacionamiento = id_estacionamiento;
    }

    public Comision getId_comsion() {
        return id_comsion;
    }

    public void setId_comsion(Comision id_comsion) {
        this.id_comsion = id_comsion;
    }

    public Pago getId_pago() {
        return id_pago;
    }

    public void setId_pago(Pago id_pago) {
        this.id_pago = id_pago;
    }

    public Vehiculo getPatente_vehiculo() {
        return patente_vehiculo;
    }

    public void setPatente_vehiculo(Vehiculo patente_vehiculo) {
        this.patente_vehiculo = patente_vehiculo;
    }
    
    

    public Reserva() {
    }

    public Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }
    
    
}

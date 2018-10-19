package Duoc.Portafolio.Clases;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dheler!
 */
public class Usuario {
    private int id_usuario;
    private String rut;
    private String password;
    private TipoUsu tipoUsu;
    private int estado;
    
    

    public Usuario(int id_usuario, String rut, String password, TipoUsu tipoUsu, int estado) {
        this.id_usuario = id_usuario;
        this.rut = rut;
        this.password = password;
        this.tipoUsu = tipoUsu;
        this.estado = estado;
    }
    
    

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsu getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(TipoUsu tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    

    public Usuario() {
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
       
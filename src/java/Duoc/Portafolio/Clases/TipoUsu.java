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
public class TipoUsu {
  private int id_tipo_usuario;
  private String descripcion;
  
  public TipoUsu(int id_tipo_usuario,String descripcion){
   this.id_tipo_usuario = id_tipo_usuario;
   this.descripcion=descripcion;   
  }
  
  public TipoUsu(){
      
  }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  
}

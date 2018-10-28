/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Herramientas;

import Duoc.Portafolio.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class Convertidor {
    
    Connection cone;

    public Convertidor() {
        cone = new Conexion().obtenerConexion();
    }
    
    public static Integer aEntero(String algo){
        Integer resultado = null;
        
        if (algo != null) {
            try {
                resultado = Integer.valueOf(algo);
            } catch (NumberFormatException nfe) {
                nfe.getMessage();
            }
        }
        return resultado;
    }
    
    public static Double aDouble(String algo){
        Double resultado = null;
        if (algo != null) {
            try {
                resultado = Double.valueOf(algo);
            } catch (NumberFormatException nfe) {
                nfe.getMessage();
            }
        }
        return resultado;
        
    }
    
    
}

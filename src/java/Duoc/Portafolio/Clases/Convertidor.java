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
public class Convertidor {
    
      public Convertidor() {
    }
    
    
    
    public static int aInt(String s){
        int resultado = 0;
        
        if (s != null) {
            try {
                resultado = Integer.valueOf(s);
            } catch (NumberFormatException e) {
                
            }
        }
        return resultado;
    }
    
    public static Double aDouble(String s){
        Double resultado = null;
        
        if (s != null) {
            try {
                resultado = Double.valueOf(s);
            } catch (NumberFormatException e) {
            }
        }
        return resultado;
    }
}

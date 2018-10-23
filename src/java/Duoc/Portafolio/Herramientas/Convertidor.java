/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Herramientas;

/**
 *
 * @author Matias
 */
public class Convertidor {

    public Convertidor() {
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

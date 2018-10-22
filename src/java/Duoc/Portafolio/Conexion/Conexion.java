/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dheler!
 */
public class Conexion {
    private static Connection cone;
    
    private String usuario = "zana";
    private String pass = "1234";
    
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public Conexion(){
        try {
            //Cargar libreria jdbc para Oracle
            Class.forName("Oracle.jdbc.OracleDriver").newInstance();
            this.cone = DriverManager.getConnection(url,usuario, pass);
        } catch (Exception e) {
            System.out.println("Error de Conexion");
        }
    }
    public Connection obtenerConexion(){
            return cone;
        }
}

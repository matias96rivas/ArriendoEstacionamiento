/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Controlador;

import Duoc.Portafolio.Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matias
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    Connection cone = new Conexion().obtenerConexion();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PreparedStatement ps = cone.prepareStatement("SELECT * FROM USUARIO WHERE nombre_usuario = ? AND contrasena = ?");
            
            String user = req.getParameter("txtRut");
            String pass = req.getParameter("txtPass");
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HttpSession sesion = req.getSession(true);
                
                sesion.setAttribute("user", user);
                resp.sendRedirect("perfil.jsp");
                req.getRequestDispatcher("perfil.jsp").forward(req, resp);
            }else{
                resp.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.getMessage();
        }finally{
            try {
                cone.close();
            } catch (SQLException ex) {
                ex.getMessage();
                Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}

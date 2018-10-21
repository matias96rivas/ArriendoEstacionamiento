/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Controlador;
import Duoc.Portafolio.Clases.ClienteArrendador;
import Duoc.Portafolio.Clases.Convertidor;
import Duoc.Portafolio.Clases.Tarjeta;
import Duoc.Portafolio.Clases.TipoUsu;
import Duoc.Portafolio.Clases.Vehiculo;
import Duoc.Portafolio.Dao.DaoClienteArrendador;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dheler!
 */
@WebServlet(name = "ServletClienteArrendador", urlPatterns = {"/ServletClienteArrendador"})
public class ServletClienteArrendador extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        String direccionar = null;
        String mensaje = null;
        
        DaoClienteArrendador daoC = new DaoClienteArrendador();
        
        switch(accion){
            case "listar":
                List<ClienteArrendador> clientes = daoC.listarClienteArrendador();
                if (clientes != null){
                    req.setAttribute("clientes", clientes);
                }else{
                   mensaje = daoC.getMensaje();
                }
                direccionar = "datos.jsp";
                break;
            
            case "agregar":
                ClienteArrendador cliente = new ClienteArrendador();
                
                default:
                    mensaje = "Accion no reconocida";
    }
        RequestDispatcher rd = req.getRequestDispatcher(direccionar);
        rd.forward(req, resp);
    }
    
    private String verificar(HttpServletRequest req, ClienteArrendador cliente){
        String mensaje ="<ul>";
        String rut = req.getParameter("txtRut");
        String pass = req.getParameter("txtPass");
        
        TipoUsu tu = new TipoUsu();
        
       
     return mensaje;   
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

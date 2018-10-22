/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Controlador;

import Duoc.Portafolio.Clases.ClienteArrendador;
import Duoc.Portafolio.Clases.Comuna;
import Duoc.Portafolio.Clases.DuenoEstacionamiento;
import Duoc.Portafolio.Clases.Estacionamiento;
import Duoc.Portafolio.Clases.TipoUsu;
import Duoc.Portafolio.Clases.Usuario;
import Duoc.Portafolio.Clases.Vehiculo;
import Duoc.Portafolio.Dao.DaoClienteArrendador;
import Duoc.Portafolio.Dao.DaoDuenoEstacionamiento;
import Duoc.Portafolio.Dao.DaoEstacionamiento;
import Duoc.Portafolio.Dao.DaoUsuario;
import Duoc.Portafolio.Dao.DaoVehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matias
 */
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    DaoUsuario daoUser = new DaoUsuario();
    DaoClienteArrendador daoCliente = new DaoClienteArrendador();
    DaoDuenoEstacionamiento daoDueno = new DaoDuenoEstacionamiento();
    DaoEstacionamiento daoEstacionamiento = new DaoEstacionamiento();
    DaoVehiculo daoVahiculo = new DaoVehiculo();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //parametro para identificar la accion
        String accion = request.getParameter("accion");
        //pregunto si la accion es igual al metodo
        if (accion.equals("agregarUsuario")) {
            agregarUsuario(request, response);
        }
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

    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {
        try {
            //datos personales
            String rut = request.getParameter("txtRut");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String fecha = request.getParameter("txtNacimiento");
            String correo = request.getParameter("txtCorreo");
            //datos cuenta
            String nombreUsu = request.getParameter("txtNombreUser");
            String contrasena = request.getParameter("txtPass");
            String contrasenaConf = request.getParameter("txtPassConf");
            int tipoUsu = Integer.parseInt(request.getParameter("cboTipoUsu"));
            int estado = 0;
            //datos del vehiculo
            String patente = request.getParameter("txtPatente");
            int anio = Integer.parseInt(request.getParameter("txtAnio"));
            String marca = request.getParameter("txtMarca");
            String modelo = request.getParameter("txtModelo");
            //datos estacionamiento
            int comuna = Integer.parseInt(request.getParameter("txtComuna"));
            String direccion = request.getParameter("txtDireccion");
                      
            //creo un nuevo usuario
            Usuario u = new Usuario();
            //seteo los datos con lo datos que venian desde el formulario
            u.setNombre(nombreUsu);
            if (contrasena.equals(contrasenaConf)) {
                u.setPassword(contrasena);
            }else{
                
            }
            //tipo de usuario
            TipoUsu tu = new TipoUsu();
            tu.setId_tipo_usuario(tipoUsu);
            u.setTipoUsu(tu);
            
            u.setEstado(estado);
            
            if (tipoUsu == 2) {
                //creo un nuevo cliente arendador
                ClienteArrendador ca = new ClienteArrendador();
                //creo un nuevo vehiculo
                Vehiculo v = new Vehiculo();
                
                //seteo los datos del cliente
                ca.setRut_arrendador(rut);
                ca.setNombre(nombre);
                ca.setApellido(apellido);
                //le doy formato a la fecha 
                Date fechaN = null;
                SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
                fechaN = spdf.parse(fecha);
                ca.setFecha_nacimiento(fechaN);
                ca.setCorreo_electronico(correo);
                
                //seteo los daros del vehiculo
                v.setPatente(patente);
                v.setAnio(anio);
                
                daoCliente.agregarClienteArrendador(ca);
                daoVahiculo.agregarVehiculo(v);
                
            }else if(tipoUsu == 3){
                //creo un nuevo cliente arrendatario
                DuenoEstacionamiento de = new DuenoEstacionamiento();
                //creo un nuevo estacionamiento
                Estacionamiento e = new Estacionamiento();
                
                //guardo los datos
                de.setRut_dueno(rut);
                de.setNombre(nombre);
                de.setApellido(apellido);
                //le doy formato a la fecha 
                Date fechaNDE = null;
                SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
                fechaNDE = spdf.parse(fecha);
                de.setFecha_nacimiento(fechaNDE);
                de.setCorreo_electronico(correo);
                de.setDireccion(direccion);               
                
                //Comuna
                Comuna c = new Comuna();
                c.setId_comuna(comuna);
                e.setComuna(c);
                
                daoDueno.agregarDuenoEstacionamiento(de);
                daoEstacionamiento.agregarEstacionamiento(e);                
            }
            daoUser.agregarUsuario(u);
        } catch (Exception e) {
        }
    }

}

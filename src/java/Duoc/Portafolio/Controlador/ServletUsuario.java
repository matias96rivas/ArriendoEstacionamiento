/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duoc.Portafolio.Controlador;

import Duoc.Portafolio.Clases.ClienteArrendador;
import Duoc.Portafolio.Clases.DuenoEstacionamiento;
import Duoc.Portafolio.Clases.Tarjeta;
import Duoc.Portafolio.Clases.TipoUsu;
import Duoc.Portafolio.Clases.Usuario;
import Duoc.Portafolio.Dao.DaoTarjeta;
import Duoc.Portafolio.Dao.DaoUsuario;
import Duoc.Portafolio.Herramientas.Convertidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matias
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        String mensaje = null;
        String mensajeT = null;
        String mensajeC = null;
        String mensajeD = null;
        String direccionar = null;

        DaoUsuario daoU = new DaoUsuario();
        DaoTarjeta daoT = new DaoTarjeta();

        switch (accion) {
            case "listar":
                List<Usuario> lista = daoU.listarUsuario();

                if (lista != null) {
                    req.setAttribute("listaUsuario", lista);
                } else {
                    mensaje = daoU.getMensaje();
                }
                direccionar = "listarUsuario.jsp";
                req.getRequestDispatcher(direccionar).forward(req, resp);
                break;
            case "agregarUsuario":
                Usuario u = new Usuario();
                Tarjeta t = new Tarjeta();
                ClienteArrendador c = new ClienteArrendador();
                DuenoEstacionamiento de = new DuenoEstacionamiento();

                mensaje = verificarU(req, u);
                mensajeT = verificarT(req, t);
//                mensajeC = verificarC(req, c);

                if (mensaje == null && mensajeT == null) {
                    daoU.agregarUsuario(u);
                    mensaje = daoU.getMensaje();

                    daoT.agregarTarjeta(t);
                    mensajeT = daoT.getMensaje();

                    if (mensaje != null || mensajeT != null) {
                        req.setAttribute("usuario", u);
                        direccionar = "registrate.jsp";
                        req.getRequestDispatcher(direccionar).forward(req, resp);
                    } else {
                        String msg = "<div>";
                        msg += "<div class='alert'>";
                        msg += "<span class='closebtn'>&times;</span>";
                        msg += "<strong>Alerta!</strong>";
                        msg += mensaje;
                        msg += "</div></div>";
                        req.setAttribute("msg", msg);
                        direccionar = "index.jsp";
                        req.getRequestDispatcher(direccionar).forward(req, resp);
                    }
                } else {
                    req.setAttribute("usuario", u);
                    direccionar = "registrate.jsp";
                    req.getRequestDispatcher(direccionar).forward(req, resp);
                }
                break;
        }
    }

    private String verificarU(HttpServletRequest req, Usuario u) {
        String mensaje = "<ul>";

        String nombre = req.getParameter("txtNombreUser");
        String pass = req.getParameter("txtPass");       
        int estado = 1;        
        int id_tipo_usu = Integer.parseInt(req.getParameter("cboTipoUsu"));      

        if ((nombre.trim().length() <= 3)) {
            mensaje += "<li>El nombre de usuario debe tener al menos 3 caracteres.</li>";
        }
        if ((pass.trim().length() <= 3)) {
            mensaje += "<li>Contraseña insegura!!! Por favor, ingrese una contraseña con más de 3 caracteres.</li>";
        }

        u.setNombre(nombre);
        u.setPassword(pass);
        u.setEstado(estado);
        u.setTipoUsu(id_tipo_usu);

        if (mensaje.equals("<ul>")) {
            mensaje = null;
        } else {
            mensaje = "</ul>";
        }
        return mensaje;

    }

    private String verificarT(HttpServletRequest req, Tarjeta t) {
        String mensajeT = "<ul>";

        int numero = Convertidor.aEntero(req.getParameter("txtNTarjeta"));
        String fecha = req.getParameter("txtFecha");

        Date fechaAux = null;
        SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fechaAux = spdf.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        t.setNum_tarjeta(numero);
        t.setFecha_expiracion(fechaAux);

        if (mensajeT.equals("<ul>")) {
            mensajeT = null;
        } else {
            mensajeT = "</ul>";
        }

        return mensajeT;
    }

//    private String verificarC(HttpServletRequest req, ClienteArrendador c) {
//        String mensajeC = "<ul>";
//        
//        String rut = req.getParameter("txtRut");
//        String nombre = req.getParameter("txtNombre");
//        String nombre = req.getParameter("txtApellido");
//        
//        
//        return mensajeC;
//    }

}

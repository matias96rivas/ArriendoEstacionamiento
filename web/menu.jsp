<%-- 
    Document   : manu
    Created on : 04-09-2018, 4:23:18
    Author     : Matias
--%>

<%@page import="clases.TipoUsu"%>
<%@page import="Modelo.DaoLogin"%>
<%@page import="clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    DaoLogin dao = new DaoLogin();

    Usuario u = (Usuario) session.getAttribute("user");

    if (u == null) {
        response.sendRedirect("index.jsp");
    } else {
        out.println("Rut: " + u.getNombre());
        out.println("Pass: " + u.getPass());

        TipoUsu tu = dao.getTipo(u.getTipo_usu());

        switch (tu.getId_tipo()) {
            case 1:
                response.sendRedirect("administrador/perfil.jsp");
                break;
            case 2:
                response.sendRedirect("arrendatario/perfil.jsp");
                break;
            case 3:
                response.sendRedirect("arrendador/perfil.jsp");
                break;
        }
    }
%>


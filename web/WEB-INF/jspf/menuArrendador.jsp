<%-- 
    Document   : menuArrendador
    Created on : 15-10-2018, 19:00:51
    Author     : Matias
--%>

<%@page import="Duoc.Portafolio.Clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario u = (Usuario) session.getAttribute("user");

    if (u == null) {
        response.sendRedirect("index.jsp");
    } else {
%>
<!-- Sidebar/menu -->
<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
    <span class="w3-bar-item w3-right">Arriendo mi Estacionamiento</span>
</div>
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
    <div class="w3-container w3-row">
        <div class="w3-col s4">
            <img src="../img/log.PNG" class="w3-circle w3-margin-right" style="width:46px">
        </div>
        <div class="w3-col s8 w3-bar">
            <h4>Arrendador</h4>
            <span>Bienvenido, <strong><% out.println(u.getNombre());%></strong></span><br>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
            <a href="datos.jsp" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
            <a href="configurar.jsp" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
        </div>
    </div>
    <hr>
    <div class="w3-container">
        <h5>Herramientas</h5>
    </div>
    <div class="w3-bar-block">
        <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
        <a href="administraciones.jsp" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-sliders"></i>  Administraciones</a>
        <a href="vehiculo.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-car"></i>  Mi Vehículo</a>
        <a href="buscarEstacionamiento.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-search"></i>  Buscar Estacionamientos</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-star-half-empty"></i>  Calificar Servicio</a>
        <div class="w3-padding-32">
            <a href="../CerrarSesion.do" class="w3-bar-item w3-button w3-padding"><i class="fa fa-close"></i>  Cerrar Sesion</a><br><br>
        </div>
        
    </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<%}%>
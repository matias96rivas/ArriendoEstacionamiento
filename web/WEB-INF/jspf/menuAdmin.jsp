<%-- 
    Document   : menuAdmin
    Created on : 15-10-2018, 19:01:14
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
    <div class="w3-container w3-row">
        <div class="w3-col s4">
            <img src="img/log.PNG" class="w3-circle w3-margin-right" style="width:50px">
        </div>
        <div class="w3-col s8 w3-bar">
            <h4>Administrador</h4>
            <span>Bienvenido, <strong> <% out.println(u.getNombre());%> </strong></span><br>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
        </div>
    </div>
    <hr>
    <div class="w3-container">
        <h5>Herramientas</h5>
    </div>
    <div class="w3-bar-block">
        <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
        <a href="#" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-sliders"></i>  Administraciones</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-road"></i>  Estacionamientos</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  Usuarios</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-file-o"></i>  Reportes</a>
        <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>  Configuraciones</a><br><br>

        <a href="CerrarSesion.do" class="w3-bar-item w3-button w3-padding"><i class="fa fa-close"></i>  Cerrar Sesion</a><br><br>
    </div>

    <!-- Overlay effect when opening sidebar on small screens -->
    <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

</nav>

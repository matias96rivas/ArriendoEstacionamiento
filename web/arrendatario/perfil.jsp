<%-- 
    Document   : perfil
    Created on : 15-10-2018, 20:28:12
    Author     : Matias
--%>

<%@page import="Duoc.Portafolio.Clases.Usuario"%>
<%@page import="Duoc.Portafolio.Dao.DaoLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    DaoLogin dao = new DaoLogin();

    Usuario u = (Usuario) session.getAttribute("user");

    if (u == null) {
        response.sendRedirect("index.jsp");
    } else {        
%>
<html>
    <title>W3.CSS Template</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
    </style>
    <head><link rel="icon" href="img/logo.PNG"></head>
    <body class="w3-light-grey">

        <!-- Top container -->
        <div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
            <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
            <span class="w3-bar-item w3-right">Arriendo mi Estacionamiento</span>
        </div>

        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
            <div class="w3-container w3-row">
                <div class="w3-col s4">
                    <img src="../img/log.PNG" class="w3-circle w3-margin-right" style="width:46px">
                </div>
                <div class="w3-col s8 w3-bar">
                    <h4>Arrendatario</h4>
                    <span>Bienvenido, <strong><% out.println(u.getNombre());%></strong></span><br>
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
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-road"></i>  Mis Estacionamientos</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-file-o"></i>  Reportes de Transacciones</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-car"></i>  Mi vehículo</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-star-half-empty"></i>  Calificar Servicio</a>
                <a href="../CerrarSesion.do" class="w3-bar-item w3-button w3-padding"><i class="fa fa-close"></i>  Cerrar Sesion</a><br><br>
            </div>
        </nav>


        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <h5><b><i class="fa fa-dashboard"></i> Estadisticas</b></h5>
            </header>

            <div class="w3-row-padding w3-margin-bottom">
                <div class="w3-quarter">
                    <div class="w3-container w3-red w3-padding-16">
                        <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>0</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Cuantos arriendan mis estacionamientos</h4>
                    </div>
                </div>
                
            </div>

            

            <!-- Footer -->
            <footer class="w3-container w3-padding-16 w3-light-grey">
                <h4>FOOTER</h4>
                <p>Powered by <a href="#" target="_blank">IronSamrt Developers</a></p>
            </footer>

            <!-- End page content -->
        </div>

        <script>
        // Get the Sidebar
            var mySidebar = document.getElementById("mySidebar");

        // Get the DIV with overlay effect
            var overlayBg = document.getElementById("myOverlay");

        // Toggle between showing and hiding the sidebar, and add overlay effect
            function w3_open() {
                if (mySidebar.style.display === 'block') {
                    mySidebar.style.display = 'none';
                    overlayBg.style.display = "none";
                } else {
                    mySidebar.style.display = 'block';
                    overlayBg.style.display = "block";
                }
            }

        // Close the sidebar with the close button
            function w3_close() {
                mySidebar.style.display = "none";
                overlayBg.style.display = "none";
            }
        </script>

    </body>
</html>

<%}%>
<%-- 
    Document   : vehiculo
    Created on : 15-10-2018, 23:01:48
    Author     : Matias
--%>

<%@page import="clases.Usuario"%>
<%@page import="Modelo.DaoLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario u = (Usuario) session.getAttribute("user");

    if (u == null) {
        response.sendRedirect("index.jsp");
    } else {
%>
<html>
    <title>Ariendo mi Estacionamiento</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    <style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}      
    </style>
    <head><link rel="icon" href="img/logo.PNG"></head>

    <body class="w3-light-grey">
        <jsp:include page="/WEB-INF/jspf/menuArrendador.jsp"/>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <h3><b><i class="fa fa-car"></i> Mi Vehículo</b></h3>
            </header>

            <div class="w3-container w3-padding-32 col-md-8">
                <form action="/action_page.php" target="_blank">
                    <input class="w3-input w3-border" type="text" placeholder="Nombre:" required name="txtNombre">
                    <input class="w3-input w3-section w3-border" type="text" placeholder="Apellido:" required name="txtApellido">
                    <input class="w3-input w3-section w3-border" type="text" placeholder="Rut:" required name="txtRut">
                    <input class="w3-input w3-section w3-border" type="date" placeholder="Fecha de Nacimiento:" required name="txtNacimiento">
                </form>
            </div>
            <div class="col-md-4">
                <img src="../img/auto2.png" style="width: 320px; height: 200px;">
            </div>
            <br>

            <div class="w3-container w3-padding-32">
                <a href="agregarVehiculo.jsp">
                    <button class="w3-button w3-black w3-section" type="submit">
                        <i class="fa fa-plus"></i> Agregar nuevo Vehiculo
                    </button>
                </a>
                <a href="configurarVehiculo.jsp">
                    <button class="w3-button w3-black w3-section" type="submit">
                        <i class="fa fa-cog"></i> Cambiar datos de Vehiculo
                    </button>
                </a>

            </div>



            <!-- Footer -->
            <footer class="w3-container w3-padding-16 w3-light-grey">
                <h4>FOOTER</h4>
                <p>Powered by IronSmart Developers</p>
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

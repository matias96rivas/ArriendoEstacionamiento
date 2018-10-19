<%-- 
    Document   : perfil
    Created on : 15-10-2018, 19:08:04
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
<!DOCTYPE html>
<html>
    <title>Ariendo mi Estacionamiento</title>
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
        
        <jsp:include page="/WEB-INF/jspf/menuArrendador.jsp"/>
        
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <h5><b><i class="fa fa-road"></i> Estacionamientos disponibles</b></h5>
            </header>

            <div class="w3-row-padding w3-margin-bottom">
                <iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d13294.354807516667!2d-70.58165773343502!3d-33.59002673230287!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses!2scl!4v1536053798157" width="960" height="500" frameborder="0" style="border:0" allowfullscreen></iframe>
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
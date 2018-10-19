<%-- 
    Document   : error
    Created on : 04-09-2018, 4:17:37
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Arriendo mi Estacionamiento</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <style>
        body,h1 {font-family: "Raleway", sans-serif}
        body, html {height: 100%}
        
        .bgimg {
            background-image: url('img/fondoerror.jpg');
            min-height: 100%;
            background-position: center;
            background-size: cover;
        }
    </style>
    <head><link rel="icon" href="img/log.PNG"></head>
    <body>

        <div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
            <div class="w3-display-topleft w3-padding-large w3-xlarge">
                <img src="img/log.PNG" style="width: 100px; height: 100px">
            </div>
            <div class="w3-display-middle">
                <h1 class="w3-jumbo w3-animate-top">Credenciales Incorrectas</h1>
                <h1 class="w3-animate-top">Rut de usuario o contraseñas no válidas</h1>
                <hr class="w3-border-grey" style="margin:auto;width:40%">
                <p class="w3-large w3-center">Haz click <a href="index.jsp">acá</a> para volver a intentarlo.</p>
            </div>
            <div class="w3-display-bottomleft w3-padding-large">
                Powered by <a href="#" target="_blank">IronSamrt Developers</a>
            </div>
        </div>

    </body>
</html>


<%-- 
    Document   : registrate
    Created on : 12-10-2018, 15:32:44
    Author     : Matias
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Duoc.Portafolio.Conexion.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Duoc.Portafolio.Dao.DaoComuna"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title  -->
        <title>Arriendo mi Estacionamiento</title>

        <!-- Favicon  -->
        <link rel="icon" href="img/logo.PNG">

        <!-- Style CSS -->
        <link rel="stylesheet" href="style.css">

        <!-- login -->
        <link href="css/login.css" rel="stylesheet" type="text/css"/>

        <!-- formulario -->
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="css/tablaFormulario.css" rel="stylesheet" type="text/css"/>

        <!--  formato fecha-->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>

    </head>

    <body>
        <!-- Preloader Start -->
        <div id="preloader">
            <div class="preload-content">
                <div id="world-load"></div>
            </div>
        </div>
        <!-- Preloader End -->

        <!-- ***** Header Area Start ***** -->
        <jsp:include page="WEB-INF/jspf/menu.jsp" />
        <!-- ********** Hero Area End ********** -->       


        <div class="main-content-wrapper section-padding-100">
            <div class="container">
                <div class="row justify-content-center">
                    <!-- ============= Post Content Area Start ============= -->
                    <div class="col-12 col-lg-8">
                        <div class="post-content-area mb-50">
                            <!-- Catagory Area -->
                            <div class="world-catagory-area">
                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="title">Ingresa tus datos y registrate:</li>                                    
                                </ul>
                                <!-- Contact Section -->
                                <div class="w3-container w3-padding-32" >
                                    <form action="ServletUsuario" method="POST">
                                        <input type="hidden" name="accion" id="accion" value="agregarUsuario">
                                        <!--<h5 class="title">Ingrese sus datos de personales:</h5>
                                        <input class="w3-input w3-section" type="text" placeholder="Rut:" required name="txtRut">
                                        <input class="w3-input w3-section w3-border" type="text" placeholder="Nombre:" required name="txtNombre">
                                        <input class="w3-input w3-section w3-border" type="text" placeholder="Apellido:" required name="txtApellido">
                                        <input class="w3-input w3-section w3-border" type="date" placeholder="Fecha de Nacimiento:" required name="txtNacimiento">
                                        <input class="w3-input w3-section w3-border" type="text" placeholder="Correo electrónico:" required name="txtCorreo">
                                        --><h5 class="title">Ingrese los datos de su cuenta:</h5>
                                        <input class="w3-input w3-border" type="text" placeholder="Nombre de usuario:" required name="txtNombreUser">
                                        <input class="w3-input w3-section w3-border" type="text" placeholder="Contraseña:" required name="txtPass">


                                        <select name="cboTipoUsu" id="cboTipoUsu" class="w3-input w3-section w3-border">
                                            <option>Tipo de Usuario:</option>
                                            <%
                                                try {
                                                    String sql = "SELECT * FROM TIPO_USUARIO WHERE id_tipo_usuario = 3 or id_tipo_usuario = 2";

                                                    Connection cone = new Conexion().obtenerConexion();
                                                    Statement stm = cone.createStatement();

                                                    ResultSet rs = stm.executeQuery(sql);

                                                    while (rs.next()) {


                                            %>
                                            <option value="<%=rs.getInt("id_tipo_usuario")%>">
                                                <%=rs.getString("descripcion")%>
                                            </option>
                                            <%
                                                    }
                                                } catch (Exception e) {
                                                }
                                            %>
                                        </select> 

                                        <h5 class="title">Ingrese los datos de su Tarjeta Bancaria:</h5>
                                        <input class="w3-input w3-border" type="text" placeholder="Ingrese el n° de su tarjeta:" required name="txtNTarjeta">
                                        <input class="w3-input w3-section w3-border" type="date" placeholder="Ingrese la fecha de expiración:" id="datepicker" required name="txtFecha">


                                        <button class="w3-button w3-black w3-section" type="submit">
                                            <i class="fa fa-paper-plane"></i> Registrarse
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- ========== Sidebar Area ========== -->
                    <div class="col-12 col-md-8 col-lg-4">
                        <div class="post-sidebar-area wow fadeInUpBig" data-wow-delay="0.2s">
                            <!-- Widget Area -->
                            <div class="sidebar-widget-area">
                                <h5 class="title">Acerca de Nosotros</h5>
                                <div class="widget-content">
                                    <p>Hoy en día encontrar un estacionamiento en Santiago de Chile, es cada día más complicado y caro, debido a esto, nace la idea <strong>Arriendo mi Estacionamiento</strong>. Ésta idea consiste básicamente, que cuando los dueños particulares de estacionamientos dejan libre su lugar mientras se van a trabajar o van a algún otro lado, puedan disponer de este mismo para el arriendo, lo cual les generará un ingreso monetario extra y además de brindarles la oportunidad y comodidad a otros automovilistas de tener un lugar seguro en donde estacionar sus vehículos.</p>
                                </div>
                            </div>

                            <!-- Widget Area -->
                            <div class="sidebar-widget-area">
                                <h5 class="title">Siguenos en nuestras redes sociales.</h5>
                                <div class="widget-content">
                                    <div class="social-area d-flex justify-content-between">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-pinterest"></i></a>
                                        <a href="#"><i class="fa fa-vimeo"></i></a>
                                        <a href="#"><i class="fa fa-instagram"></i></a>
                                        <a href="#"><i class="fa fa-google"></i></a>
                                    </div>
                                </div>
                            </div>                            
                        </div>
                    </div>
                </div>                
            </div>
        </div>

        <!-- ***** Modal de login ***** -->
        <div id="id01" class="modal">

            <form class="modal-content animate" action="ServletLogin" method="POST">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Cerrar">&times;</span>
                    <img src="img/log.PNG" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <label for="uname"><b>Nombre de usuario:</b></label>
                    <input type="text" placeholder="Ingrese su rut" name="txtRut" required>

                    <label for="psw"><b>Contraseña:</b></label>
                    <input type="password" placeholder="Ingrese su contraseña" name="txtPass" required>

                    <button name="Ingresar" value="btnAccion" type="submit">Login</button>
                    <label>
                        <input type="checkbox" checked="checked" name="remember"> Recordar mi contraseña.
                    </label>
                </div>

            </form>
        </div>
        <!-- ***** fin de modal ***** -->

        <!-- ***** Footer Area Start ***** -->
        <footer class="footer-area">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-4">
                        <div class="footer-single-widget">
                            <a href="#"><img src="img/logo.PNG" style="width: 100px; height: 100px" alt=""></a>
                            <div class="copywrite-text mt-30">
                                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> Todos los rderechos reservados | Página desarrollada<i class="fa fa-heart-o" aria-hidden="true"></i> por IronSmart Developers.
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- ***** Footer Area End ***** -->

        <!-- jQuery (Necessary for All JavaScript Plugins) -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Plugins js -->
        <script src="js/plugins.js"></script>
        <!-- Active js -->
        <script src="js/active.js"></script>
        <!-- Login -->
        <script src="js/login.js" type="text/javascript"></script>

        <!-- formulario -->
        <script src="js/tablaFormulario.js" type="text/javascript"></script>

        <!-- formato fecha -->
        <script>
                                        $(document).ready(function () {
                                            var date_input = $('input[name="txtFecha"]'); //our date input has the name "date"
                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                            var options = {
                                                format: 'dd/mm/yyyy',
                                                container: container,
                                                todayHighlight: true,
                                                autoclose: true,
                                            };
                                            date_input.datepicker(options);
                                        });
        </script>

    </body>

</html>
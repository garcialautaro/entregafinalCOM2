<%-- 
    Document   : vendedor
    Created on : 16-dic-2021, 14:43:05
    Author     : lauch
--%>

<%@page import="logica.MedioPago"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.Vendedor"%>
<%@page import="logica.Paquete"%>
<%@page import="logica.Servicio"%>
<%@page import="logica.TipoServicio"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Empresa de Turismo</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">  
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <!-- body -->

    <body class="main-layout contineer_page">
        <%
            HttpSession misession = request.getSession();
            String usuario = (String) misession.getAttribute("nombreUsuario");
            if (usuario == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#" /></div>
        </div>
        <!-- end loader -->
        <!-- header -->
        <header>
            <!-- header inner -->

            <div class="header">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-2 col-lg-2 col-md-2 col-sm-3 col logo_section">
                            <div class="full">
                                <div class="center-desk">
                                    <div class="logo">
                                        <a href="index.jsp">INICIO</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-10 col-lg-10 col-md-10 col-sm-9">

                            <div class="menu-area">
                                <div class="limit-box">
                                    <nav class="main-menu ">
                                        <ul class="menu-area-main">
                                            <li> <a href="abmPersonas.jsp">ABM Personas</a> </li>
                                            <li > <a href="abmServiciosPaquetes.jsp">ABM Servicios y Paquetes</a> </li>
                                            <li class="active"> <a href="abmVentas.jsp">ABM Ventas</a> </li>
                                            <li> <a href="abmConfig.jsp">ABM Config</a> </li>
                                            <li > <a href="login.jsp">Panel ADM</a> </li>
                                        </ul>
                                    </nav>

                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end header inner -->

            <!-- end header -->


        </header>

        <div class="backgro_mh">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heding">
                            <h2>ALTA DE UNA VENTA</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!--  footer -->
    <footr>
        <div class="footer ">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                    </div>
                    <form id="formulario" action="SvAltaVenta" method="POST" class="contact_bg">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="col-md-12">
                                    <div class="col-md-12">
                                        <p style="color: white">Seleccione el Servicio de la siguiente lista :</p>
                                        <input type="radio" name="codigoServicio" value="<%=0%>" checked>seleccione una
                                        <br>
                                        <%
                                            List<Servicio> listaServicios = (List) misession.getAttribute("listaServicios");
                                            List<Paquete> listaPaquetes = (List) misession.getAttribute("listaPaquetes");
                                            List<Vendedor> listaVendedores = (List) misession.getAttribute("listaVendedores");
                                            List<Cliente> listaClientes = (List) misession.getAttribute("listaClientes");
                                            List<MedioPago> listaMedioPagos = (List) misession.getAttribute("listaMedioPagos");
                                            for (Servicio serv : listaServicios) {

                                        %>
                                        <input type="radio" name="codigoServicio" value="<%=serv.getCodigoServicio()%>"><%=serv.getNombreServicio()%>
                                        <br>
                                        <%
                                            }
                                        %>
                                        <p style="color: white">Seleccione el codigo del Paquete de la siguiente lista :</p>
                                        <input type="radio" name="codigoPaquete" value="<%=0%>" checked>seleccione una
                                        <br>
                                        <%
                                            for (Paquete paq : listaPaquetes) {
                                        %>
                                        <input type="radio" name="codigoPaquete" value="<%=paq.getCodigoPaquete()%>"><%=paq.getCodigoPaquete()%>
                                        <br>
                                        <%
                                            }
                                        %>
                                        <p style="color: white">Seleccione el Vendedor de la siguiente lista :</p>
                                        <input type="radio" name="codigoVendedor" value="<%=0%>" checked>seleccione una
                                        <br>
                                        <%
                                            for (Vendedor ve : listaVendedores) {
                                        %>
                                        <input type="radio" name="codigoVendedor" value="<%=ve.getIdVendedor()%>"><%=ve.getNombreVendedor() + " " + ve.getApellidoVendedor()%>
                                        <br>
                                        <%
                                            }
                                        %>
                                        <p style="color: white">Seleccione el Cliente de la siguiente lista :</p>
                                        <input type="radio" name="codigoCliente" value="<%=0%>" checked>seleccione una
                                        <br>
                                        <%
                                            for (Cliente cli : listaClientes) {
                                        %>
                                        <input type="radio" name="codigoCliente" value="<%=cli.getIdCliente()%>"><%=cli.getNombreCliente() + " " + cli.getApellidoCliente()%>
                                        <br>
                                        <%
                                            }
                                        %>
                                        <p style="color: white">Seleccione el Medio de Pago de la siguiente lista :</p>
                                        <input type="radio" name="codigoMP" value="<%=0%>" checked>seleccione una
                                        <br>
                                        <%
                                            for (MedioPago mp : listaMedioPagos) {
                                        %>
                                        <input type="radio" name="codigoMP" value="<%=mp.getCodMedioPago()%>"><%=mp.getNombreMP()%>
                                        <br>
                                        <%
                                            }
                                        %>
                                    </div>
                                    <div class="col-md-12">
                                        <input class="contactus" placeholder="Fecha de la venta (dd/MM/yyyy)" name="fechaVenta">
                                    </div>
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                        <button type="submit" class="send">Enviar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                                <div class="address">
                                    <ul class="loca">
                                        <li>
                                            <a href="#"><img src="icon/loc.png" alt="#" /></a>Locations

                                        <li>

                                            <a href="#"><img src="icon/call.png" alt="#" /></a>+12586954775 </li>
                                        <li>
                                            <a href="#"><img src="icon/email.png" alt="#" /></a>demo@gmail.com </li>
                                    </ul>


                                </div>
                            </div>
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                                <ul class="social_link">
                                    <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin-square" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <div class="container">
                <div class="copyright">

                    <p>Copyright 2019 All Right Reserved By <a href="https://html.design/">Free  html Templates</a></p>
                </div>
            </div>
        </div>
    </footr>
    <!-- end footer -->
    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-3.0.0.min.js"></script>
    <script src="js/plugin.js"></script>
    <!-- sidebar -->
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/custom.js"></script>
    <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>




</body>

</html>
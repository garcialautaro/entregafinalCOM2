<%@page import="logica.MedioPago"%>
<%@page import="logica.Paquete"%>
<%@page import="logica.TipoServicio"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Servicio"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.Usuario"%>
<%@page import="logica.Vendedor"%>
<%@page import="java.util.List"%>
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
        <!--  footer -->
    <footr>
        <div class="footer ">
            <div class="container"> <h2 style="color:white"> </h2>
                <div class="row"> <h2 style="color:white"> LISTA DE PAQUETES</h2>
                    <div class="col-md-12">
                        
                        <table>
                            <thead>
                                <tr class ="contact_bg">

                                    <th class="container" id="fila1">Codigo</th>
                                    <th class="container" id="fila2">Nombre</th>
                                    <th class="container" id="fila3">Comision</th>
                                    <th class="container" id="fila3">Modificar</th>
                                    <th class="container" id="fila3">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<MedioPago> listaMedioPagos = (List) misession.getAttribute("listaMedioPagos");
                                    for (MedioPago mp : listaMedioPagos) {
                                %>
                                <tr class ="contact_bg">
                                    <%  Integer codMedioPago = mp.getCodMedioPago();%> 
                                    <td class="container" id="fila1" style="color:white"> 
                                        <%=codMedioPago%>
                                    </td>
                                    <%  String nombreMP = mp.getNombreMP(); %> 
                                    <td class="container" id="fila2" style="color:white"> 
                                        <%=nombreMP%> 
                                    </td>                                       
                                    <%  Double comisionMP = mp.getComisionMP(); %> 
                                    <td class="container" id="fila2" style="color:white"> 
                                        <%=comisionMP%> 
                                    </td>
                                                                     
                                    <td class="container" id="fila4" style="color:white">
                                        <form name ="frmModificarMP" action="SvModificarMP" method="POST" style="display:inline">
                                            <input type="hidden" name="idMedioPago" value="<%=codMedioPago%>">
                                            <button type="submit" class="submit" data-title="Edit" style="display:inline">¿?</button>
                                        </form>
                                    </td>
                                    <td class="container" id="fila5" style="color:white">
                                        <form name ="frmEliminarMP" action="SvEliminarMP" method="POST" style="display:inline">
                                            <input type="hidden" name="idMedioPago" value="<%=codMedioPago%>">
                                            <button type="submit" class="submit" data-title="Delete" style="display:inline">X</button>
                                        </form>
                                    </td>

                                </tr>
                                <%}%>
                            </tbody>
                        </table>

                    </div>
                    
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                                <div class="address">
                                    


                                </div>
                            </div>
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                                
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
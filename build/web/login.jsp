<%-- 
    Document   : vendedor
    Created on : 16-dic-2021, 14:43:05
    Author     : lauch
--%>

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
            String nombreUsuario = (String) misession.getAttribute("nombreUsuario");
            if (nombreUsuario != null) {
                response.sendRedirect("panelAdministracion.jsp");
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
                                        <a href="index.jsp">Turismo</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-10 col-lg-10 col-md-10 col-sm-9">

                            <div class="menu-area">
                                <div class="limit-box">
                                    <nav class="main-menu ">
                                        <ul class="menu-area-main">
                                            <li > <a href="index.jsp">Inicio</a> </li>
                                            <li> <a href="servicios.jsp">Servicios</a> </li>
                                            <li> <a href="paquetes.jsp">Paquetes </a> </li>
                                            <li> <a href="vendedores.jsp">Vendedores</a> </li>
                                            <li> <a href="mediospago.jsp">Medios de pago</a> </li>
                                            <li class="active"> <a href="login.jsp">Login</a> </li>
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
                            <h2>LOGIN</h2>
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
                        <form action="SvLogin" method="POST" class="contact_bg">

                            <div class="row">

                                <div class="col-md-12">
                                    <div class="col-md-12">

                                        <input class="contactus" placeholder="Usuario" type="text" name="nombreUsuario">
                                    </div>

                                    <input class="contactus" placeholder="Contrase??a" type="password" name="contraseniaUsuario">
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                    <button type="submit" class="send">Enviar</button>
                                </div>

                            </div>
                        </form>
                    </div>


                </div>

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

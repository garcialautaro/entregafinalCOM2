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
        <title>Empresa de turismo</title>
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

    <body class="main-layout">
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#" /></div>
        </div>
        <!-- end loader -->
        <!-- header -->
        <header>
            <!-- header inner -->
            <div class="header-top">
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
                                                <li class="active"> <a href="index.jsp">Inicio</a> </li>
                                                <li> <a href="servicios.jsp">Servicios</a> </li>
                                                <li> <a href="paquetes.jsp">Paquetes</a> </li>
                                                <li>
                                                    <form action="SvConsultaVendedores" method="GET" class="menu-area-main">
                                                        <a href="SvConsultaVendedores">Vendedores</a>
                                                    </form> 
                                                </li>
                                                <li> <a href="mediospago.jsp">Medios de pago</a> </li>
                                                <li > <a href="login.jsp">Login</a> </li>
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
                <section class="slider_section">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">

                                <div class="container">
                                    <div class="carousel-caption">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="text-bg">
                                                    <span>la mejor</span>
                                                    <h1>EMPRESA DE TURISMO QUE ENCONTRARAS</h1>
                                                    <p>Planificá tus viajes y estadías, y mucho más... SOLO CON UN CLICK!</p>
                                                    <a href="#">Nuestros servicios</a> <a href="#">Nuestros paquetes</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">

                                <div class="container ">
                                    <div class="carousel-caption">

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="text-bg">
                                                    <span>la mejor</span>
                                                    <h1>EMPRESA DE TURISMO QUE ENCONTRARAS</h1>
                                                    <p>Contacta con nuestros vendedores</p>
                                                    <a href="#">Nuestros vendedores</a><a href="#">Hacé tu reserva</a>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                            </div>


                            <div class="carousel-item">

                                <div class="container">
                                    <div class="carousel-caption ">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="text-bg">
                                                    <span>la mejor</span>
                                                    <h1>EMPRESA DE TURISMO QUE ENCONTRARAS</h1>
                                                    <p>Dale una mirada a nuestra galería, o mira la opinion de nuestros clientes</p>
                                                    <a href="#">Galeria</a> <a href="#">Nuestros clientes</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                            <i class="fa fa-long-arrow-left" aria-hidden="true"></i>

                        </a>
                        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>

                        </a>
                    </div>



                </section>
            </div>
        </header>



        <!-- about  -->
        <div id="about" class="about">
            <div class="container">
                <div class="row display_boxflex">
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <div class="about-box">
                            <h2>Acerca de nosotros</h2>
                            <p>Somos una compañia fundada en 1940, dedicada completamente a la satisfaccion
                                de nuestros clientes y a plena disposicion de sus necesidades. Te esperamos!</p>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <div class="about-box">
                            <figure><img src="images/about.png" alt="#" /></figure>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- end abouts -->




        <!-- upcoming -->
        <div id="upcoming" class="upcoming">
            <div class="container-fluid padding_left3">
                <div class="row display_boxflex">
                    <div class="col-xl-5 col-lg-5 col-md-5 col-sm-12">
                        <div class="box_text">
                            <div class="titlepage">
                                <h2>Nuestros servicios</h2>
                            </div>
                            <p>Contamos con un amplia gama de disponibilidad en hoteles, alquiler de autos,
                                pasajes de colectivo, pasajes de avion, pasajes de tren, excursiones y entradas
                                a eventos.</p>
                            <a href="Javascript:void(0)">Esto te gusta? Hace click!</a>
                        </div>
                    </div> 

                    <div class="col-xl-7 col-lg-7 col-md-7 col-sm-12 border_right">
                        <div class="upcomimg">
                            <figure><img src="images/up.jpg" alt="#"/></figure>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end upcoming -->

        <!-- Gallery -->


        <div id="gallery" class="Gallery">
            <div class="container"> 
                <div class="row display_boxflex">
                    <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12">
                        <div class="row">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 margi_bott">
                                <div class="Gallery_img">
                                    <figure><img src="images/Gallery1.jpg" alt="#"/></figure>
                                </div>
                                <div class="hover_box">

                                    <ul class="icon_hu">
                                        <h3>Music night</h3>
                                        <li><a href="#"><img src="icon/h.png" alt="#"/></a></li>
                                        <li><a href="#"><img src="icon/h.png" alt="#"/></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 margi_bott">
                                <div class="Gallery_img">
                                    <figure><img src="images/Gallery2.jpg" alt="#"/></figure>
                                </div>
                                <div class="hover_box">

                                    <ul class="icon_hu">
                                        <h3>Music night</h3>
                                        <li><a href="#"><img src="icon/h.png" alt="#"/></a></li>
                                        <li><a href="#"><img src="icon/h.png" alt="#"/></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 margi_bott1">
                                <div class="Gallery_img">
                                    <figure><img src="images/Gallery3.jpg" alt="#"/></figure>
                                </div>
                                <div class="hover_box">

                                    <ul class="icon_hu">
                                        <h3>Music night</h3>
                                        <li><a href="#"><img src="icon/h.png" alt="#"/></a></li>
                                        <li><a href="#"><img src="icon/h.png" alt="#"/></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                <div class="Gallery_img">
                                    <figure><img src="images/Gallery4.jpg" alt="#"/></figure>
                                </div>
                                <div class="hover_box">

                                    <ul class="icon_hu">
                                        <h3>Music night</h3>
                                        <li><a href="#"><img src="icon/h.png" alt="#"/></a></li>
                                        <li><a href="#"><img src="icon/h.png" alt="#"/></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                        <div class="Gallery_text">
                            <div class="titlepage">
                                <h2>Galeria</h2>
                            </div>
                            <p>Echale un vistazo a las fotos enviadas por nuestros clientes!</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- end Gallery --> 




        <!--  footer -->
    <footr>
        <div class="footer ">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form class="contact_bg">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="titlepage">
                                        <h2>Contactanos</h2>
                                    </div>
                                    <div class="col-md-12">
                                        <input class="contactus" placeholder="Ingrese su nombre" type="text" name="Ingrese su nombre">
                                    </div>
                                    <div class="col-md-12">
                                        <input class="contactus" placeholder="Ingrese su mail" type="text" name="Ingrese su mail">
                                    </div>
                                    <div class="col-md-12">
                                        <input class="contactus" placeholder="Ingrese su telefono" type="text" name="Ingrese su telefono">
                                    </div>
                                    <div class="col-md-12">
                                        <textarea class="textarea" placeholder="Mensaje" type="text" name="Mensaje"></textarea>
                                    </div>
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                        <button class="send">Enviar</button>
                                    </div>
                                </div>
                            </div>
                        </form>

                    </div>
                    <div class="col-md-12 border_top">
                        <form class="news">
                            <h3>Newsletter</h3>
                            <input class="newslatter" placeholder="Ingrese su mail" type="text" name=" Ingrese su mail2">
                            <button class="submit">Suscribirme</button>
                        </form>
                    </div>
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                                <div class="address">
                                    <ul class="loca">
                                        <li>
                                            <a href="#"><img src="icon/loc.png" alt="#" /></a>Ubicación

                                        <li>

                                            <a href="#"><img src="icon/call.png" alt="#" /></a>54 263-4540527</li>
                                        <li>
                                            <a href="#"><img src="icon/email.png" alt="#" /></a>empresaturismo@gmail.com</li>
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

                    <p>Se reservan todos los derechos de autor a <a href="https://html.design/">Plantillas gratis de HTML</a></p>
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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="author" content="SemiColonWeb" />


    <!-- Stylesheets
    ============================================= -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700|Roboto:300,400,500,700&display=swap" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="CSS/style.css" type="text/css" />
    <link rel="stylesheet" href="CSS/swiper.css" type="text/css" />

    <!-- One Page Module Specific Stylesheet -->
    <!--<link rel="stylesheet" href="one-page/onepage.css" type="text/css" />-->
    <!-- / -->

    <link rel="stylesheet" href="CSS/dark.css" type="text/css" />
    <link rel="stylesheet" href="CSS/font-icons.css" type="text/css" />
    <link rel="stylesheet" href="one-page/css/et-line.css" type="text/css" />
    <link rel="stylesheet" href="CSS/animate.css" type="text/css" />
    <link rel="stylesheet" href="CSS/magnific-popup.css" type="text/css" />

    <!--<link rel="stylesheet" href="one-page/css/fonts.css" type="text/css" />-->

    <link rel="stylesheet" href="CSS/custom.css" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Document Title
    ============================================= -->
    <title>F-GO</title>

    <style>
        @media (min-width: 992px) {

            #top-bar.transparent-topbar {
                z-index: 399;
                border-bottom: 0;
                margin-top: 15px;
            }

            #top-bar.transparent-topbar {
                background: transparent !important;
            }

            #top-bar + #header.transparent-header.floating-header {
                margin-top: 15px;
            }

        }

        .dark .top-links li > a,
        .dark #top-social li a { color: #FFF; }

        .dark .top-links li:hover { background-color: rgba(255,255,255,0.15); }

        .dark #top-social li { border-left: 0; }
    </style>

</head>

<body class="stretched">

<!-- Document Wrapper
============================================= -->
<div id="wrapper" class="clearfix">

    <jsp:include page="header.jsp"></jsp:include>
    <section id="slider" class="slider-element slider-parallax swiper_wrapper min-vh-60 min-vh-md-100 include-header">
        <div class="slider-inner">

            <div class="swiper-container swiper-parent">
                <div class="swiper-wrapper">
                    <div class="swiper-slide dark">
                        <div class="container">
                            <div class="slider-caption slider-caption-center">
                                <h2 data-animate="fadeInUp">Welcome To F-GO</h2>
                                <p class="d-none d-sm-block" data-animate="fadeInUp" data-delay="200"></p>
                            </div>
                        </div>
                        <div class="swiper-slide-bg" style="background-image: url('https://i.ibb.co/0XdGtSm/banner.png');"></div>
                    </div>
                    <div class="swiper-slide dark">
                        <div class="container">
                            <div class="slider-caption slider-caption-center">
                                <h2 data-animate="fadeInUp">Beautifully Flexible</h2>
                                <p class="d-none d-sm-block" data-animate="fadeInUp" data-delay="200">Looks beautiful &amp; ultra-sharp on Retina Screen Displays. Powerful Layout with Responsive functionality that can be adapted to any screen size.</p>
                            </div>
                        </div>
                        <div class="video-wrap">
                            <video poster="images/videos/explore-poster.jpg" preload="auto" loop autoplay muted>
                                <source src='images/videos/explore.mp4' type='video/mp4' />
                                <source src='images/videos/explore.webm' type='video/webm' />
                            </video>
                            <div class="video-overlay" style="background-color: rgba(0,0,0,0.55);"></div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="container">
                            <div class="slider-caption">
                                <h2 data-animate="fadeInUp">Great Performance</h2>
                                <p class="d-none d-sm-block" data-animate="fadeInUp" data-delay="200">You'll be surprised to see the Final Results of your Creation &amp; would crave for more.</p>
                            </div>
                        </div>
                        <div class="swiper-slide-bg" style="background-image: url('images/slider/swiper/3.jpg'); background-position: center top;"></div>
                    </div>
                </div>
                <div class="slider-arrow-left"><i class="icon-angle-left"></i></div>
                <div class="slider-arrow-right"><i class="icon-angle-right"></i></div>
                <div class="slide-number"><div class="slide-number-current"></div><span>/</span><div class="slide-number-total"></div></div>
            </div>

        </div>
    </section>
    <section id="content">
        <div  class="content-wrap pb-0">
            <div style="" class="container">
                <div class="row align-items-center">

                    <div class="col-lg-5">
                        <div class="heading-block">
                            <h1>Welcome to F-GO<br>Thuê xe tự lái</h1>
                        </div>
                        <p class="lead">Bạn đang cần tìm một dịch vụ cho thuê xe tự lái uy tín, tiện lợi. F-GO với đội xe chất lượng cao,
                            đội ngũ nhân viên chuyên nghiệp, nhiệt tình sẽ mang đến cho bạn những trải nghiệm thú vị, thuận tiện
                            nhất.</p>
                    </div>

                    <div class="col-lg-7 align-self-end">

                        <div class="position-relative overflow-hidden">
                            <img src="images/services/main-fbrowser.png" data-animate="fadeInUp" data-delay="100" alt="Chrome">
                            <img src="images/Mercedes-Benz-Carmudi.jpg" style="top: 0; left: 0; min-width: 100%; min-height: 100%;" data-animate="fadeInUp" data-delay="400" alt="iPhone" class="position-absolute">
                        </div>

                    </div>

                </div>

            </div>
        </div>


    </section>
</div>


</section>





<jsp:include page="footer.jsp"></jsp:include>


<!-- Footer
============================================= -->
<!-- #footer end -->

</div><!-- #wrapper end -->

<!-- Go To Top
============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>

<!-- JavaScripts
============================================= -->
<script src="JS/jquery.js"></script>
<script src="JS/plugins.min.js"></script>

<!-- Footer Scripts
============================================= -->
<script src="JS/functions.js"></script>

</body>
</html>
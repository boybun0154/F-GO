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
                    
                    <div class="container">
                        <div class="fancy-title title-center title-border topmargin">
                            <h3>Các xe nổi bật</h3>
                        </div>
                    </div>
                    <div  id="related-portfolio" class="owl-carousel owl-carousel-full portfolio-carousel carousel-widget" data-margin="0" data-pagi="false" data-items-xs="1" data-items-sm="2" data-items-md="3" data-items-lg="4">
                    <c:forEach items="${listP}" var="o">
                        <article  class="portfolio-item pf-graphics pf-illustrations">
                            <div class="grid-inner">
                                <div class="portfolio-image">
                                    <div class="fslider" data-arrows="false">
                                        <div class="flexslider">
                                            <div class="slider-wrap">
                                                <div class="slide"><a href="portfolio-single-gallery.html"><img style='width:100%;height:300px;' src="${o.productImg} alt="Car"></a></div>
                                                <!--                                                    <div class="slide"><a href="portfolio-single-gallery.html"><img src="images/portfolio/4/6-1.jpg" alt="Shake It"></a></div>
                                                                                                    <div class="slide"><a href="portfolio-single-gallery.html"><img src="images/portfolio/4/6-2.jpg" alt="Shake It"></a></div>
                                                                                                    <div class="slide"><a href="portfolio-single-gallery.html"><img src="images/portfolio/4/6-3.jpg" alt="Shake It"></a></div>-->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="bg-overlay" data-lightbox="gallery">
                                        <div class="bg-overlay-content dark flex-column" data-hover-animate="fadeIn">
                                            <div class="portfolio-desc pt-0 center" data-hover-animate="fadeInDownSmall" data-hover-animate-out="fadeOutUpSmall" data-hover-speed="350">
                                                <h3><a href="view_car_detail?pid=${o.productID}">${o.productName}</a></h3>
                                                <span><a href="#"><fmt:formatNumber value = "${o.price}" type = "currency" /></a> </span>
                                                <span><a href="#">${o.yearRelease}</a></span>
                                            </div>
                                            <div class="d-flex">
                                                <a href="images/portfolio/full/6.jpg" class="overlay-trigger-icon bg-light text-dark" data-hover-animate="fadeInUpSmall" data-hover-animate-out="fadeOutDownSmall" data-hover-speed="350" data-lightbox="gallery-item"><i class="icon-line-stack-2"></i></a>
                                                <a href="images/portfolio/full/6-1.jpg" class="d-none" data-lightbox="gallery-item"></a>
                                                <a href="images/portfolio/full/6-2.jpg" class="d-none" data-lightbox="gallery-item"></a>
                                                <a href="images/portfolio/full/6-3.jpg" class="d-none" data-lightbox="gallery-item"></a>
                                                <a href="portfolio-single-gallery.html" class="overlay-trigger-icon bg-light text-dark" data-hover-animate="fadeInUpSmall" data-hover-animate-out="fadeOutDownSmall" data-hover-speed="350"><i class="icon-line-ellipsis"></i></a>
                                            </div>
                                        </div>
                                        <div class="bg-overlay-bg dark" data-hover-animate="fadeIn"></div>
                                    </div>
                                </div>
                            </div>
                        </article>
                    </c:forEach>
                </div>
                </section>
        </div>
        <div style="text-align:center;" class="watchmore-btn">
            <form action="allproduct" method="POST">
                <button type="submit" class="button">Xem thêm toàn bộ xe</button>
            </form>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <body>
        <jsp:include page="header2.jsp"></jsp:include>

        <div class="content">
            <div class="header">
                <h2>Doanh thu tháng</h2>
            </div>
            <canvas id="myChart" style="width:100%;max-width:1000px;margin: 0 auto"></canvas>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
    <!-- Go To Top
============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>

<!-- JavaScripts
============================================= -->
<script src="JS/jquery.js"></script>
<script src="JS/plugins.min.js"></script>
<script src="https://maps.google.com/maps/api/js?key=YOUR-API-KEY"></script>

<!-- Footer Scripts
============================================= -->
<script src="JS/functions.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <script src="./stat.js"></script> 
    <script src="https://code.jquery.com/jquery-3.2.1.js"
    integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
    <script>
        $(function () {
            $('.product-card').hover(function () {
                $(this).find('.description').animate({
                    height: "toggle",
                    opacity: "toggle"
                }, 300);
            });
        });
        let subMenu = document.getElementById("subMenu");
        const $menu = $('.sub-menu-wrap');
        function toggleMenu() {
            subMenu.classList.toggle("open-menu");
        }
        $(document).mouseup(function (e) {
            var container = $(".user-pic");
            if (!container.is(e.target) && subMenu.classList.toggle("open-menu")) {
                subMenu.classList.toggle("open-menu");
            }
        });
    </script>

    <script>
        /* 
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        let month = ["Thang 1", "Thang 2", "Thang 3", "Thang 4", "Thang 5", "Thang 6", "Thang 7", "Thang 8", "Thang 9", "Thang 10", "Thang 11", "Thang 12"]
        let statics = [];
        var barColors = ["orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange"];

        $(document).ready(function () {
//Call api 
            $.ajax({
                url: "http://localhost:8080/F-Go/getStatic",
//        dataType: json,
                type: 'GET',
                dataType: "json",
                success: function (data) {
//      statics["2"] = 800000.0


                    statics[0] = data[1];
                    statics[1] = data[2];
                    statics[2] = data[3];
                    statics[3] = data[4];
                    statics[4] = data[5];
                    statics[5] = data[6];
                    statics[6] = data[7];
                    statics[7] = data[8];
                    statics[8] = data[9];
                    statics[9] = data[10];
                    statics[10] = data[11];
                    statics[11] = data[12];
                    new Chart("myChart", {
                        type: "bar",
                        data: {
                            labels: month,
                            datasets: [{
                                    backgroundColor: barColors,
                                    data: statics
                                }]
                        },
                        options: {
                            legend: {display: false},
                            title: {
                                display: true,
                                text: "Doanh thu theo tháng"
                            }
                        }
                    });
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("error: " + textStatus.toString())
                },
            }
            );


        })




    </script>
</html>

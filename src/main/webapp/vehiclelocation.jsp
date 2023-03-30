<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>F-GO</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="SemiColonWeb" />

        <!-- Stylesheets
        ============================================= -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700|Roboto:300,400,500,700&display=swap" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css" />
        <link rel="stylesheet" href="CSS/style.css" type="text/css" />
        <link rel="stylesheet" href="CSS/swiper.css" type="text/css" />

        <!-- One Page Module Specific Stylesheet -->
        <link rel="stylesheet" href="one-page/onepage.css" type="text/css" />
        <!-- / -->

        <link rel="stylesheet" href="CSS/dark.css" type="text/css" />
        <link rel="stylesheet" href="CSS/font-icons.css" type="text/css" />
        <link rel="stylesheet" href="one-page/css/et-line.css" type="text/css" />
        <link rel="stylesheet" href="CSS/animate.css" type="text/css" />
        <link rel="stylesheet" href="CSS/magnific-popup.css" type="text/css" />

        <link rel="stylesheet" href="one-page/css/fonts.css" type="text/css" />

        <link rel="stylesheet" href="CSS/custom.css" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <!-- Document Title
        ============================================= -->
        <title>Header - Floating Style | Canvas</title>

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
        <br/>
        <br/>
        <br/>
        <br/>
        <!--The div element for the map -->
        <div id="map" style="height: 800px; width: 100%;"></div>

        <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDBIyHQm-psnijne-QnAKam2nh92CXtlfM&callback=initMap&v=weekly"
            defer
        ></script>
        <jsp:include page="footer.jsp"></jsp:include>

        <script src="https://code.jquery.com/jquery-3.2.1.js"
        integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
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
            var acc = null;
            var role = null;
            acc = document.getElementById("testacc");
            role = document.getElementById("testaccrole");
            function getLocation() {
                if (navigator.geolocation) {
                    navigator.geolocation.watchPosition(savePosition);
                } else {
                    console.log("Geolocation is not supported by this browser.");
                }
            }
            function savePosition(position) {
                //pass position value to servlet
                console.log("lat:" + position.coords.latitude + " lng:" + position.coords.longitude);
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        console.log(this.responseText);
                    }
                };
                xhttp.open("GET", "/SaveLocation?acc=" + acc.value + "&lat=" + position.coords.latitude + "&lng=" + position.coords.longitude, true);
                xhttp.send();
            }
            if (acc.value && role.value == 0) {
                console.log(acc.value);
                console.log(role.value);
                getLocation();
            }
        </script>
<script>
    var map;
    function initMap() {
        //get location list from servlet name "LoadVehicleLocation" using ajax
        $.ajax({
            url: "loadvehiclelocation",
            type: "GET",
            dataType: "json",
            success: function (data) {
                //get location list from servlet
                var locations = data;
                //set map
                map = new google.maps.Map(document.getElementById("map"), {
                    zoom: 15,
                    center: new google.maps.LatLng(15.978606452797194, 108.26207630897451),
                });
                // const defaultMaker = new google.maps.Marker({
                //     position: { lat: 15.978606452797194, lng: 108.26207630897451 },
                //     map: map,
                //     label: "fpt",
                // });
                //set marker
                var marker, i;
                for (i = 0; i < locations.length; i++) {
                    console.log(locations[i]);
                    var acc=locations[i].acc;
                    var lat=locations[i].lat;
                    console.log(lat);
                    var lng=locations[i].lng;
                    console.log(lng);
                     marker = new google.maps.Marker({
                        position: { lat: lng, lng:lat },
                        map: map,
                        label: acc,
                    });
                }
            },
            error: function (e) {
                alert("Error: " + e);
            }
        });
    }
    // function initMap() {
    //     const map = new google.maps.Map(document.getElementById("map"), {
    //         zoom: 15,
    //         center: { lat: 15.978606452797194, lng: 108.26207630897451 },
    //     });
    //     const locations=[
    //         new google.maps.LatLng(15.978606452797194, 108.26207630897451),
    //     ]
    //     const markers = locations.map((location, i) => {
    //         return new google.maps.Marker({
    //             position: location,
    //             map:map,
    //             label: "A",
    //         });
    //     });
    // }
    //10mins refresh

    window.initMap = initMap;
</script>


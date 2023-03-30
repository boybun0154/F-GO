<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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

            <section class="pt-5 pb-5 mt-5" style="min-height: 80vh">
                <div class="container">
                    <div class="row w-100">
                        <div class="col-lg-12 col-md-12 col-12">
                            <h3 class="display-5 mb-2 text-center">Danh sách xe yêu thích</h3>
                            <table id="wishlist" class="table table-condensed table-responsive mt-5">
                                <thead>
                                    <tr>
                                        <th class="text-center" style="width:40%">Thông tin của xe</th>
                                        <th class="text-center" style="width:18%">Hãng xe</th>
                                        <th class="text-center" style="width:20%">Giá thuê/ngày</th>
                                        <th class="text-center" style="width:20%"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${wlist}" var="wl">
                                    <tr>
                                        <c:forEach items="${plist}" var="p">
                                            <c:if test="${p.productID == wl.productID}">
                                                <td data-th="Product">
                                                    <div class="row">
                                                        <div class="col-md-5 text-left">
                                                            <img src="${p.productImg}" alt=""
                                                                 class="img-fluid d-none d-md-block rounded mb-2 shadow ">
                                                        </div>
                                                        <div class="col-md-7 text-left mt-sm-2">
                                                            <h5>${p.productName}</h5>
                                                            <p class="font-weight-light product-info">Chỗ ngồi: ${p.seat}</p>
                                                            <p class="font-weight-light product-info">Hộp số: ${p.gear}</p>
                                                            <p class="font-weight-light product-info">Màu: ${p.color}</p>
                                                            <p class="font-weight-light product-info">Biển số: ${p.licensePlate}</p>
                                                            <p class="font-weight-light product-info">Nhiên liệu: ${p.fuel}</p>
                                                            <p class="font-weight-light product-info">Năm sản xuất: ${p.yearRelease}</p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-center" data-th="Category"> ${p.productName} </td>
                                                <td class="text-center" data-th="Price"> ${p.price}đ </td>
                                                <td class="actions" data-th="">
                                                    <div class="text-right">
                                                        <a href="load_to_order?pid=${p.productID}" class="btn btn-primary mb-2" style="height: 38px;">Đặt xe</a>
                                                        <a href="view_car_detail?pid=${p.productID}" class=" view-btn btn btn-white border-secondary bg-white btn-md mb-2">
                                                            <i class="far fa-eye"></i>
                                                        </a>
                                                        <a href="delete_wishlist?wlid=${wl.wishlistID}" class="delete-btn btn btn-white border-secondary bg-white btn-md mb-2">
                                                            <i class="fas fa-trash"></i>
                                                        </a>
                                                    </div>
                                                </td>
                                            </c:if>
                                        </c:forEach>     
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row w-100 d-flex align-items-center">
                    <div class="col-12 mb-3 mb-m-1 order-md-1 text-md-right">
                        <a href="allproduct" class="btn btn-back">
                            <i class="fas fa-arrow-left mr-2"></i>Trở về xem danh sách xe</a>
                    </div>
                </div>
            </div>
        </section>

        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
    </body>

</html>

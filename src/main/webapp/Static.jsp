<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
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
                    <h2>Thông kê chính</h2>
                </div>
                <div class="container mb-3 mt-3">
                    <table class="table table-striped table-bordered mydatatable text-center" style="width: 100%">
                        <thead style="text-align:center;">
                            <tr>
                                <th>Số lượt truy cập</th>
                                <th>Doanh thu tổng</th>
                                <th>Số khách đã thuê</th>
                                <th>Số lượt đánh giá</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${view}</td>
                            <td>${total}</td>
                            <td>${num}</td>
                            <td>${rate}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="content">
            <div class="header">
                <h2>Thống kê top 5 xe được thuê nhiều nhất tháng</h2>
            </div>
            <div class="container mb-3 mt-3">
                <table class="table table-striped table-bordered mydatatable text-center" style="width: 100%">
                    <thead style="text-align:center;">
                        <tr>
                            <th>ID</th>
                            <th>Tên xe</th>
                            <th>Hình ảnh</th>
                            <th>Số lần thuê</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listcar}" var="o">
                            <tr>
                                <td>${o.productID}</td>
                                <td>${o.productName}</td>
                                <td style=" text-align: center"><img src="${o.productImg}" width= "100"/></td>
                                <td>${o.productTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="content">
            <div class="header">
                <h2>Thống kê top 5 khách hàng sử dụng dịch vụ nhiều nhất</h2>
            </div>
            <div class="container mb-3 mt-3">
                <table class="table table-striped table-bordered mydatatable text-center" style="width: 100%">
                    <thead style="text-align:center;">
                        <tr>
                            <th>ID Tài Khoản</th>
                            <th>ID Khách Hàng</th>
                            <th>Tên Khách Hàng</th>
                            <th>Số lần sử dụng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listperson}" var="p">
                            <tr>
                                <td>${p.accountId}</td>
                                <td>${p.customerId}</td>
                                <td>${p.customerName}</td>
                                <td>${p.customerTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
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
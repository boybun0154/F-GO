<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="SemiColonWeb" />
                
        <link rel="stylesheet" href="./CSS/orderStyle2.css">
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

            <div class="container-content d-lg-flex">
                <div class="box-1 bg-light user">
                    <div class="box-inner-1 pb-3">
                        <div class="d-flex justify-content-between mb-3 userdetails">
                            <p class="fw-bold" style="font-size:1.4rem">${product.productName}</p>
                        <p class="" style="font-size:1.2rem"> <span class="fas fa-dollar-sign"></span>&nbsp;${product.price}đ</p>
                    </div>
                    <div id="my" class="img-details">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="${product.productImg}"
                                     class="d-block w-100">
                            </div>
                        </div>
                    </div>
                    <div class="row text-center mt-3">
                        <p class="col-6 dis info ">Chỗ ngồi: ${product.seat}</p>
                        <p class="col-6 dis info ">Biển số: ${product.licensePlate}</p>
                    </div>
                    <div class="row text-center">
                        <p class="col-6 dis info ">Hộp số: ${product.gear}</p>
                        <p class="col-6 dis info ">Nhiên liệu: ${product.fuel}</p>
                    </div>
                    <div class="row text-center">
                        <p class="col-6 dis info ">Màu: ${product.color}</p>
                        <p class="col-6 dis info ">Năm sản xuất: ${product.yearRelease}</p>
                    </div>
                    <div class="row">
                        <p class="dis info">${product.productTitle}</p>
                    </div>
                </div>
            </div>
            <div class="box-2">
                <div class="box-inner-2">
                    <div>
                        <p class="fw-bold" style="font-size:1.2rem">Thông tin đặt thuê xe</p>
                        <p class="dis mb-4">Điền đầy đủ các thông tin bên dưới</p>
                    </div>
                    <form action="checkout" method="POST">
                        <input type="hidden" name="accid" value="${sessionScope.acc.accountID}">
                        <input type="hidden" name="pid" value="${product.productID}">
                        <div class="mb-3">
                            <p class="dis fw-bold mb-2" style="font-size:1rem">Địa chỉ nhận xe</p>
                            <textarea class="form-control validate" name="address" rows="2" required></textarea>
                        </div>
                        <div class="mb-3">
                            <p class="dis fw-bold mb-2" style="font-size:1rem">Khu vực di chuyển</p>
                            <textarea class="form-control validate" name="area" rows="1" required></textarea>
                        </div>
                        <div class="mb-3">
                            <p class="dis fw-bold mb-2" style="font-size:1rem">Nơi bắt đầu</p>
                            <textarea class="form-control validate" name="startLocation" rows="1" required></textarea>
                        </div>
                        <div class="mb-3">
                            <p class="dis fw-bold mb-2" style="font-size:1rem">Nơi kết thúc</p>
                            <textarea class="form-control validate" name="endLocation" rows="1" required></textarea>
                        </div>
                        
                            <p class="dis fw-bold mb-2" style="font-size:1rem">Ngày thuê xe</p>
                            <div class="d-flex w-50 mb-3">
                                <div class="d-flex w-100">
                                    <input id="dateBeginPickerId" type="date" name="dateBegin" class="form-control validate px-0" required>
                                </div>
                            </div>
                            <p class="dis fw-bold mb-2" style="font-size:1rem">Hạn trả xe</p>
                            <div class="d-flex w-50 mb-3">
                                <div class="d-flex w-100">
                                    <input id="dateEndPickerId" type="date" name="dateEnd" class="form-control validate px-0" required>
                                </div>
                            </div>
                            <div> 
                            <div class="addresss">
                                <p class="dis fw-bold mb-3">Hình thức thanh toán: Đặt cọc trước 50% tổng số tiền</p>
                                <!--                                <div class="d-flex align-items-center justify-content-between mb-2">
                                                                    <p class="fw-bold">Tổng cộng</p>
                                                                    <p class="fw-bold"><i class="fas fa-money-check"></i>&nbsp;3200000đ</p>
                                                                </div>-->
                                <div class="payment">
                                    <input id="payment_default" type="radio" name="payment_method" value="momo">
                                    <label for="payment_default" data-toggle="collapse" data-target="#collapsedefult"
                                           aria-controls="collapsedefult">Momo</label>
                                </div>
                                <div class="payment">
                                    <input id="payment_default" type="radio" name="payment_method" value="vnpay">
                                    <label for="payment_default" data-toggle="collapse" data-target="#collapsedefult"
                                           aria-controls="collapsedefult">VNPay</label>
                                </div>
                                <div class="payment">
                                    <input id="payment_default" type="radio" name="payment_method" value="paypal">
                                    <label for="payment_default" data-toggle="collapse" data-target="#collapsedefult"
                                           aria-controls="collapsedefult">PayPal</label>
                                </div>
                                <button class="btn btn-block btn-primary mt-2" type="submit">Thanh toán</button>
                                <a href="view_car_detail?pid=${product.productID}" class="btn btn-back mt-2" data-abc="true" style="float: right"> <i class="fa fa-chevron-left"></i>Trở về</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
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

            var today = new Date();
            var tomorrow = new Date();

            var dd = today.getDate();
            var mm = today.getMonth() + 1; //January is 0!
            var yyyy = today.getFullYear();
            if (dd < 10) {
                dd = '0' + dd;
            }
            if (mm < 10) {
                mm = '0' + mm;
            }
            today = yyyy + '-' + mm + '-' + dd;

            tomorrow = yyyy + '-' + mm + '-' + (dd + 1);

            document.getElementById("dateBeginPickerId").setAttribute("min", today);
            document.getElementById("dateEndPickerId").setAttribute("min", tomorrow);

            function DateCheck() {
                var StartDate = document.getElementById('dateBeginPickerId').value;
                var EndDate = document.getElementById('dateEndPickerId').value;
                var eDate = new Date(EndDate);
                var sDate = new Date(StartDate);
                if (StartDate !== '' && StartDate !== '' && sDate > eDate){
                    alert("Ngày trả xe phải sau ngày nhận xe!");
                    document.getElementById('dateEndPickerId').value = null;
                }
            }
            ;
            $(document).ready(function () {
                $("#dateEndPickerId").change(function () {
                    DateCheck();
                });
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
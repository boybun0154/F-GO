<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div style="justify-content: center" class="header">
                <h2>Chi tiết thông tin xe</h2>
            </div>

            <div class="container mb-3 mt-5">
                <div class="row">
                    <div class="car-img col-12 col-md-6 mt-2">
                        <img src="${detail.productImg}"
                             alt="Hình ảnh của xe">
                    </div>
                    <div class="col-12 col-md-6 mt-3">
                        <div class="car-info mb-3">Tên xe: ${detail.productName}</div>
                        <div class="car-info mb-3">Hãng xe: <c:if test="${detail.categoryID == 1}">
                                Hyundai
                            </c:if>
                            <c:if test="${detail.categoryID == 2}">
                                VinFast
                            </c:if>
                            <c:if test="${detail.categoryID == 3}">
                                Mazda
                            </c:if>
                            <c:if test="${detail.categoryID == 4}">
                                Toyota
                            </c:if>
                            <c:if test="${detail.categoryID == 5}">
                                Honda
                            </c:if></div>
                        <div class="car-info mb-3">Mô tả: ${detail.productTitle}</div>
                        <div class="car-info mb-3">Giá thuê/ngày: ${detail.price}đ</div>
                        <div class="car-info mb-3">Chỗ ngồi: ${detail.seat}</div>
                        <div class="car-info mb-3">Hộp số: ${detail.gear}</div>
                        <div class="car-info mb-3">Biển số xe: ${detail.licensePlate}</div>
                        <div class="car-info mb-3">Nhiên liệu: ${detail.fuel}</div>
                        <div class="car-info mb-3">Năm sản xuất: ${detail.yearRelease}</div>
                        
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 col-sm-2 col-md-2 mt-3 mb-3 text-center edit-btn">
                        <a href="load_to_edit?pid=${detail.productID}" class="btn btn-primary">Chỉnh sửa</a>
                    </div>
                    <div class="col-6 col-sm-2 col-md-2 mt-3 mb-3 text-center">
                        <a href="manageproduct" class="btn btn-back">Quay lại</a>
                    </div>
                </div>
            </div>
        </div>

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

<!-- Footer Scripts
============================================= -->
<script src="JS/functions.js"></script>
    </body>
</html>

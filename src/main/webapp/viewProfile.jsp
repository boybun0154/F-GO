<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
       <link rel="stylesheet" href="./CSS/viewProfileStyle2.css"/>
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
                    <h2>Chi tiết thông tin tài khoản</h2>
                </div>
                <!--<p class="font-italic"></p>-->
                <div class="container mb-3 mt-5 ">
                    <div class="row user-info mb-3 pt-3">
                        <div class="padding-left-25 text-bold col-6">Họ và Tên:</div>
                        <div class="col-6">${detail.customerName}</div>
                </div>
                <div class="row user-info mb-3">
                    <div class="padding-left-25 text-bold col-6">Số điện thoại:</div>
                    <div class="col-6">${detail.phone}</div>
                </div>
                <div class="row user-info mb-3">
                    <div class="padding-left-25 text-bold col-6">Hình ảnh khuôn mặt:</div>
                    <div class="col-6"><img src="${detail.faceImg}"
                                            alt="Hình ảnh khuôn mặt người dùng" width="200"></div>
                </div>
                <div class="row user-info mb-3">
                    <div class="padding-left-25 text-bold col-6">Căn cước công dân:</div>
                    <div class="col-6"><img src="${detail.nationalId}"
                                            alt="Hình ảnh căn cước công dân" width="200"></div>
                </div>
                <div class="row user-info mb-3">
                    <div class="padding-left-25 text-bold col-6">Giấy phép lái xe:</div>
                    <div class="col-6"><img src="${detail.drivingLicense}"
                                            alt="Hình ảnh giấy phép lái xe" width="200"></div>
                </div>
                <div class="row user-info mb-3">
                    <div class="padding-left-25 text-bold col-6">Email:</div>
                    <div class="col-6">${detail.email}</div>
                </div>
                <div class="row user-info mb-3">
                    <div class="padding-left-25 text-bold col-6">Trạng thái tài khoản:</div>
                    <div class="col-6">
                        <c:if test="${detail.isVerify == 0}">
                            Chưa xác thực
                        </c:if> 
                        <c:if test="${detail.isVerify == 1}">
                            Đã xác thực
                        </c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 col-sm-3 col-md-3 mt-3 mb-3 text-center edit-btn">
                        <a href="load_to_edit_profile?cusid=${detail.customerId}" class="btn btn-primary">Chỉnh sửa</a>
                    </div>
                    <div class="col-6 col-sm-3 col-md-3 mt-3 mb-3 text-center">
                        <a href="Home" class="btn btn-back">Quay lại</a>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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

            <input type="hidden" id="testacc" value="${sessionScope.acc.account}" />
        <input type="hidden" id="testaccrole" value="${sessionScope.acc.role}" />
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div class="container" style="display: contents;">
            <h1>${message}</h1>
            <h1 style="text-align: center">Danh sách Order</h1>
            <br/>
            <br/>


            <table class="table table-striped table-bordered mydatatable">
                <thead>
                    <tr class="" style="text-align:center">
                        <th class="col-auto">ID</th>
                        <th class="col-auto">Tên khách hàng</th>
                        <th class="col-auto">Số điện thoại</th>
                        <th class="col-auto">Tên xe thuê</th>
                        <th class="col-auto">Địa chỉ nhận xe</th>
                        <th class="col-auto">Số tiền còn lại</th>
                        <th class="col-auto">Trạng thái</th>
                        <th class="col-auto">Ngày nhận</th>
                        <th class="col-auto">Ngày hẹn trả</th>
                        <th class="col-auto">Vùng hoạt động</th>
                        <th class="col-auto">Nơi bắt đầu</th>
                        <th class="col-auto">Nơi kết thúc</th>
                        <th class="col-auto">Trạng thái thanh toán</th>
                        <th class="col-auto">Chức năng</th>
                        <th class="col-auto"></th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <tr  class="">
                        <c:forEach items="${listO}" var="Order">
                            <td>${Order.orderId}</td>
                            <c:forEach items="${listC}" var="a">
                                <c:if test="${Order.customerID == a.customerId}">
                                    <td>${a.customerName}</td>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${listC}" var="a">
                                <c:if test="${Order.customerID == a.customerId}">
                                    <td>${a.phone}</td>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${listP}" var="p">
                                <c:if test="${Order.productId == p.productID}">
                                    <td>${p.productName}</td>
                                </c:if>
                            </c:forEach>
                            <td>${Order.address}</td>
                            <td>${Order.totalMoney / 2}</td>       
                            <c:if test="${Order.status == 0}">
                                <td>Đã trả xe</td>
                            </c:if>
                            <c:if test="${Order.status == 1}">
                                <td>Đang thuê</td>
                            </c:if>
                            <td>${Order.timeBegin}</td>       
                            <td>${Order.timeEnd}</td>
                            <td>${Order.area}</td>
                            <td>${Order.startLocation}</td>
                            <td>${Order.endLocation}</td>
                            <c:if test="${Order.statusMoney == 0}">
                                <td>Chưa thanh toán</td>
                            </c:if>
                            <c:if test="${Order.statusMoney == 1}">
                                <td>Đã thanh toán</td>
                            </c:if>
                            <c:if test="${Order.status == 1}">
                                <td style="text-align:center;">
                                    <a data-toggle="modal" data-id="${Order.orderId}" title="Report" 
                                       class="open-ReportModal" href="#ReportModal">
                                        <button class="btn btn-danger">Report</button></a>

                                </td>


                            </c:if>
                            <c:if test="${Order.status == 0}">
                                <td style="text-align:center;">
                                    <a  data-id="${Order.orderId}" title="Report" 
                                        class="">
                                        <button disabled class="btn btn-danger">Report</button></a>
                                    </c:if>

                                <c:if test="${Order.statusMoney == 0}">
                                <td>
                                    <a data-id="" title="" 
                                       class="btn btn-warning text-light" href="ReportControl?accountID=${accid}&action=paid&&orderID=${Order.orderId}" >
                                        Pay</a>  
                                </td>
                            </c:if>
                            <c:if test="${Order.statusMoney == 1}">
                                <td>
                                    <a data-id="" title="" 
                                       class="btn btn-warning disabled text-light" href="ReportControl?accountID=${accid}&action=paid&&orderID=${Order.orderId}">
                                        Pay</a>
                                </td>
                            </c:if>

                        </tr>
                    </c:forEach>
                    </tr>
                </tbody>
            </table>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div style="display:none!important" class="modal hide"  id="ReportModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
            <div class="add-block" style="overflow-y: scroll; max-height:85%;  margin-top: 50px; margin-bottom:50px;" > 
                <div class="modal-content tm-bg-primary-dark tm-block tm-block-h-auto"> 
                    <div class="modal-header" style="display: contents;"> 
                        <h3 class="modal-title tm-block-title">Report</h3> 
                    </div> 
                    <div class="modal-body">
                        <form action="ReportControl" method="post" class="tm-edit-product-form">
                            <div class="row tm-edit-product-row overflow" style="justify-content: center">
                                <div class="col-xl-6 col-lg-6 col-md-12">
                                    <div class="form-group mb-3">
                                        <label for="orderid">Order Id</label>
                                        <input id="orderid" name="orderid" value="" type="text" class="form-control validate" readonly />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="damagePercent">Phần trăm hư hỏng</label>
                                        <input id="damagePercent" name="damagePercent" min="0" type="number" class="form-control validate" required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="exDistance">Số km vượt quá</label>
                                        <input id="exDistance" name="exDistance" min="0" type="number" class="form-control validate" required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="title">Tiêu đề</label>
                                        <input id="title" name="title" type="text" class="form-control validate" required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="content">Nội dung</label>
                                        <textarea  id="content" name="content" type="text" class="form-control validate"></textarea>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="prePic">Ảnh trước khi giao</label>
                                        <input id="prePic" name="prePic" type="file" accept="image/*" class="form-control" required />
                                        <input name="preLink" id="preLink" type="text" class="form-control" value="image-input" hidden>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="afterPic">Ảnh sau khi trả xe</label>
                                        <input id="afterPic" name="afterPic" type="file" accept="image/*" class="form-control" required />
                                        <input name="afterLink" id="afterLink" type="text" class="form-control" value="image-input" hidden>
                                    </div>
                                    <div class="form-group mb-3">
                                        <input type="hidden" id="accountID" name="accountID" class="form-control" value="${accid}" />
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="justify-content: center">
                                <div class="col-3 mt-3 text-center">
                                    <button type="submit" class="btn btn-primary text-uppercase">Gửi report</button>
                                </div>  
                                <div class="col-3 mt-3 text-center">
                                    <a href="" type="button" class="btn btn-back">Trở lại</a>
                                </div> 
                            </div>
                        </form>
                    </div> 
                </div> 
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
            $('document').ready(function () {
                $('input[name="prePic"]').on('change', function () {
                    let $files = $(this).get(0).files;
                    if ($files.length) {
                        if ($files[0].size > $(this).data('max-size') * 1024) {
                            console.log('Vui lòng chọn file có dung lượng nhỏ hơn!');
                            return false;
                        }
                        console.log('Đang upload hình ảnh lên imgbb...');
                        let apiUrl = 'https://api.imgbb.com/1/upload?key=c2ac895f56085e398fd942062a073bde';
                        let settings = {
                            url: apiUrl,
                            method: "POST",
                            timeout: 0,
                            processData: false,
                            mimeType: "multipart/form-data",
                            contentType: false
                        };
                        let formData = new FormData();
                        formData.append('image', $files[0]);
                        settings.data = formData;
                        $.ajax(settings).done(function (response) {
                            console.log(response);
                            let obj = JSON.parse(response);
                            $("#preLink").val(obj.data.url);
                        });
                    }
                });

                $('input[name="afterPic"]').on('change', function () {
                    let $files = $(this).get(0).files;
                    if ($files.length) {
                        if ($files[0].size > $(this).data('max-size') * 1024) {
                            console.log('Vui lòng chọn file có dung lượng nhỏ hơn!');
                            return false;
                        }
                        console.log('Đang upload hình ảnh lên imgbb...');
                        let apiUrl = 'https://api.imgbb.com/1/upload?key=c2ac895f56085e398fd942062a073bde';
                        let settings = {
                            url: apiUrl,
                            method: "POST",
                            timeout: 0,
                            processData: false,
                            mimeType: "multipart/form-data",
                            contentType: false
                        };
                        let formData = new FormData();
                        formData.append('image', $files[0]);
                        settings.data = formData;
                        $.ajax(settings).done(function (response) {
                            console.log(response);
                            let obj = JSON.parse(response);
                            $("#afterLink").val(obj.data.url);
                        });
                    }
                });
            });
        </script>
        <script>
            $(document).on("click", ".open-ReportModal", function () {
                var id = $(this).data('id');
                $(".modal-body #orderid").val(id);
                // As pointed out in comments, 
                // it is unnecessary to have to manually call the modal.
                // $('#addBookDialog').modal('show');
            });
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

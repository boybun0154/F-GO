<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đặt xe</title>
        <link rel="stylesheet" href="./CSS/orderStyle.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>

    <body>
        <jsp:include page="navbar.jsp"></jsp:include>

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
                                    <input id="dateBeginPickerId" type="text" name="dateBegin"
                                           class="form-control validate px-0" autocomplete="off" required>
                                </div>
                            </div>
                            <p class="dis fw-bold mb-2" style="font-size:1rem">Hạn trả xe</p>
                            <div class="d-flex w-50 mb-3">
                                <div class="d-flex w-100">
                                    <input id="dateEndPickerId" type="text" name="dateEnd"
                                           class="form-control validate px-0" autocomplete="off" required>
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
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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

            // var today = new Date();
            // var tomorrow = new Date();
            // var dd = today.getDate();
            // var mm = today.getMonth() + 1; //January is 0!
            // var yyyy = today.getFullYear();
            // if (dd < 10) {
            //     dd = '0' + dd;
            // }
            // if (mm < 10) {
            //     mm = '0' + mm;
            // }
            // today = yyyy + '-' + mm + '-' + dd;
            // tomorrow = yyyy + '-' + mm + '-' + (dd + 1);
            // document.getElementById("dateBeginPickerId").setAttribute("min", today);
            // document.getElementById("dateEndPickerId").setAttribute("min", tomorrow);
            $(function () {
                $.ajax({
                    type : 'GET',
                    headers : {
                        Accept : "application/json; charset=utf-8",
                        "Content-Type" : "application/json; charset=utf-8"
                    },
                    url : '${pageContext.request.contextPath }/productAjax',
                    success : function(result) {
                        var data = $.parseJSON(result);
                        var dates = [];
                        for (var i = 0; i < data.length; i++) {
                            if (data[i].productId == $('input[name="pid"]').val()) {
                                var timeBegin = new Date(data[i].timeBegin);
                                var timeEnd = new Date(data[i].timeEnd);
                                var currentDate = new Date(timeBegin);
                                while (currentDate <= timeEnd) {
                                    dates.push(currentDate.toISOString().slice(0,10));
                                    currentDate.setDate(currentDate.getDate() + 1);
                                }
                            }
                        }
                        console.log(dates);
                        $("#dateBeginPickerId").datepicker({
                            dateFormat : 'yy-mm-dd',
                            minDate : 0,
                            maxDate: '+6m',
                            numberOfMonths: 2,
                            beforeShowDay : function (date) {
                                var string = jQuery.datepicker.formatDate('yy-mm-dd', date);
                                return [dates.indexOf(string) == -1]
                            },
                            onSelect: function(dateText, inst) {
                                var startDate = $("#dateBeginPickerId").datepicker("getDate");
                                var endDate = $("#dateEndPickerId").datepicker("getDate");
                                checkSelectedDates(startDate, endDate, dates);
                                DateCheck();
                            }
                        });
                        $("#dateEndPickerId").datepicker({
                            dateFormat : 'yy-mm-dd',
                            minDate : 1,
                            maxDate: '+6m',
                            numberOfMonths: 2,
                            beforeShowDay : function (date) {
                                var string = jQuery.datepicker.formatDate('yy-mm-dd', date);
                                return [dates.indexOf(string) == -1]
                            },
                            onSelect: function(dateText, inst) {
                                var startDate = $("#dateBeginPickerId").datepicker("getDate");
                                var endDate = $("#dateEndPickerId").datepicker("getDate");
                                checkSelectedDates(startDate, endDate, dates);
                                DateCheck();
                            }
                        });
                    }
                });
            });

            function checkSelectedDates(startDate, endDate, dates) {
                var selectedDates = [];
                var currentDate = new Date(startDate);
                while (currentDate <= endDate) {
                    selectedDates.push(currentDate.toISOString().slice(0,10));
                    currentDate.setDate(currentDate.getDate() + 1);
                }
                // console.log(selectedDates);
                for (var i = 0; i < selectedDates.length; i++) {
                    if (dates.indexOf(selectedDates[i]) != -1) {
                        // There is a disabled date in the selected range
                        // Show an error message or take any other appropriate action
                        alert("Ngày bạn chọn đã có người đặt!");
                        document.getElementById('dateEndPickerId').value = null;
                        break;
                    }
                }
            };

            function DateCheck() {
                var StartDate = document.getElementById('dateBeginPickerId').value;
                var EndDate = document.getElementById('dateEndPickerId').value;
                var eDate = new Date(EndDate);
                var sDate = new Date(StartDate);
                if (StartDate !== '' && StartDate !== '' && sDate > eDate){
                    alert("Ngày trả xe phải sau ngày nhận xe!");
                    document.getElementById('dateEndPickerId').value = null;
                }
            };
            // $(document).ready(function () {
            //     $("#dateEndPickerId").change(function () {
            //         DateCheck();
            //     });
            //     $("#dateBeginPickerId").change(function () {
            //         DateCheck();
            //     });
            // });
        </script>
    </body>

</html>
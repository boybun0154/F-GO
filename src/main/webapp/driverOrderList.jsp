<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>F-Go</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="./CSS/manageStyle.css">
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>


            <input type="hidden" id="testacc" value="${sessionScope.acc.account}" />
        <input type="hidden" id="testaccrole" value="${sessionScope.acc.role}" />
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div class="container">
            <h1>${message}</h1>
            <table class="table table-striped table-bordered mydatatable">
                <thead>
                    <tr class="" style="text-align:center">
                        <th class="col-auto">ID</th>
                        <th class="col-auto">Tên khách hàng</th>
                        <th class="col-auto">Số điện thoại</th>
                        <th class="col-auto">Tên xe thuê</th>
                        <th class="col-auto">Địa chỉ nhận xe</th>
                        <th class="col-auto">Tổng số tiền</th>
                        <th class="col-auto">Trạng thái</th>
                        <th class="col-auto">Ngày nhận</th>
                        <th class="col-auto">Ngày hẹn trả</th>
                        <th class="col-auto">Vùng hoạt động</th>
                        <th class="col-auto">Nơi bắt đầu</th>
                        <th class="col-auto">Nơi kết thúc</th>
                        <th class="col-auto">Chức năng</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <tr  class="">
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
                        <td>${Order.totalMoney}</td>       
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
                        <td style="text-align:center;">
                            <button class="add-btn btn btn-warning text-uppercase">Report</button>
                        </td>
                    </tr>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="add-modal hide" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
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
                                        <input id="orderid" name="orderid" value=${Order.orderId} type="text" class="form-control validate" readonly />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="damagePercent">Phần trăm hư hỏng</label>
                                        <input id="damagePercent" name="damagePercent" type="text" class="form-control validate" required />
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
                                        <input id="prePic" name="prePic" type="file" class="form-control validate" required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="afterPic">Ảnh sau khi trả xe</label>
                                        <input id="afterPic" name="afterPic" type="file" class="form-control validate" required />
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
            let modal = document.querySelector(".add-modal");
            var btnOpen = document.querySelector(".add-btn");
            var btnCancel = document.querySelector(".btn-back");
            function toggleModal(e) {
                console.log(e.target);
                modal.classList.toggle("hide")
            }
            btnOpen.addEventListener('click', toggleModal);
            btnCancel.addEventListener('click', toggleModal);
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
    </body>
</html>

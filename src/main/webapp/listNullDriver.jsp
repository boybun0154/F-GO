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
        <div class="container" style="display: contents;">
            <h1>${message}</h1>
                        <h1 style="text-align: center">Danh sách Order chưa có tài xế</h1>
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
                        <th class="col-auto">Ngày nhận</th>
                        <th class="col-auto">Ngày hẹn trả</th>
                        <th class="col-auto">Vùng hoạt động</th>
                        <th class="col-auto">Nơi bắt đầu</th>
                        <th class="col-auto">Nơi kết thúc</th>
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
                            
                            <td>${Order.timeBegin}</td>       
                            <td>${Order.timeEnd}</td>
                            <td>${Order.area}</td>
                            <td>${Order.startLocation}</td>
                            <td>${Order.endLocation}</td>
                            <td>
                                <a href="/F-Go/nulldriver?orderID=${Order.orderId}&driverID=${driverID}&action=update" class="">
                                    <button class="btn btn-danger">Nhận</button></a>
                            </td>

                            

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
    </body>
</html>

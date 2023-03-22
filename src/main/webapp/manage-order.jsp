<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Manage Order</title>
        <link rel="stylesheet" href="./CSS/manageStyle.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
        
        <div class="content">
            <div class="header">
                <h2>Quản lý đơn thuê</h2>
            </div>
<!--            <div class="group-function">
                <button class="add-btn btn btn-primary text-uppercase">Thêm đơn thuê mới</button>
            </div>-->
            <div class="container mb-3 mt-3">
                <table class="table table-striped table-bordered mydatatable">
                    <thead style="text-align:center;">
                        <tr class="">
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
                            <th class="col-auto">ID người phụ trách</th>
                            <th class="col-auto">Trạng thái thanh toán</th>
                            <th class="col-auto">Chức năng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listO}" var="o">
                            <tr  class="">
                                <td>${o.orderId}</td>
                                <c:forEach items="${listC}" var="a">
                                    <c:if test="${o.customerID == a.customerId}">
                                        <td>${a.customerName}</td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${listC}" var="a">
                                    <c:if test="${o.customerID == a.customerId}">
                                        <td>${a.phone}</td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${listP}" var="p">
                                    <c:if test="${o.productId == p.productID}">
                                        <td>${p.productName}</td>
                                    </c:if>
                                </c:forEach>
                                <td>${o.address}</td>
                                <td>${o.totalMoney}</td>       
                                <c:if test="${o.status == 0}">
                                    <td>Đã trả xe</td>
                                </c:if>
                                <c:if test="${o.status == 1}">
                                    <td>Đang thuê</td>
                                </c:if>
                                <td>${o.timeBegin}</td>       
                                <td>${o.timeEnd}</td>
                                <td>${o.area}</td>
                                <td>${o.startLocation}</td>
                                <td>${o.endLocation}</td>
                                <td>${o.driverId}</td>
                                <c:if test="${o.statusMoney == 0}">
                                    <td>Đã thanh toán cọc</td>
                                </c:if>
                                <c:if test="${o.statusMoney == 1}">
                                    <td>Chưa thanh toán cọc</td>
                                </c:if>
                                <td style="text-align:center;">
                                    <a href="load_to_edit_order?oid=${o.orderId}" class="btn">
                                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                        <span><strong>Chỉnh sửa</strong></span>
                                    </a>
                                    <a href="delete_order?oid=${o.orderId}" class="btn">
                                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                        <span><strong>Xoá</strong></span>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="add-modal hide">
            <div class="container add-block">
                <div class="row">
                    <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                        <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="tm-block-title">Thêm đơn thuê mới</h2>
                                </div>
                            </div>
                            <form id="form" action="addorder" method="post" class="tm-edit-product-form">
                                <div class="row tm-edit-product-row">
                                    <div class="col-xl-6 col-lg-6 col-md-12">
                                        <div class="form-group mb-3">
                                            <label for="name">Họ tên khách hàng
                                            </label>
                                            <input id="name" name="name" type="text" class="form-control validate" required onkeyup="validationname()" />
                                            <span id="textname"></span>
                                        </div>    
                                        <div class="form-group mb-3">
                                            <label for="carid">Id xe thuê
                                            </label>
                                            <input id="carid" name="carid" type="text" class="form-control validate" required />
                                            
                                        </div>  
                                        <div class="form-group mb-3">
                                            <label for="phone">Số điện thoại
                                            </label>
                                            <input id="phone" name="phone" type="text" class="form-control validate" required onkeyup="validationphone()" />
                                            <span id="textphone"></span>
                                        </div>  
                                        

                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                        <div class="form-group mb-3">
                                            <label for="timeBegin">Ngày bắt đầu
                                            </label>
                                            <input id="timeBegin" name="timeBegin" type="date" class="form-control validate" required />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="timeEnd">Ngày kết thúc
                                            </label>
                                            <input id="timeEnd" name="timeEnd" type="date" class="form-control validate" required />
                                        </div>  
                                         <div class="form-group mt-3 mb-3">
                                            <label for="address">Địa chỉ nhận xe</label>
                                            <textarea id="address" name="address" class="form-control validate" rows="3" required></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="justify-content: center">
                                    <div class="col-3 mt-3 text-center">
                                        <button type="submit" class="btn btn-primary text-uppercase">Thêm đơn thuê</button>
                                    </div>  
                                    <div class="col-3 mt-3 text-center">
                                        <a href="manageorder" type="button" class="btn btn-back">Trở lại</a>
                                    </div> 
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
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
                        const $menu = $('.sub-menu-wrap')
                        function toggleMenu() {
                            subMenu.classList.toggle("open-menu")
                        }
                        $(document).mouseup(function (e) {
                            var container = $(".user-pic");
                            if (!container.is(e.target) && subMenu.classList.toggle("open-menu")) {
                                subMenu.classList.toggle("open-menu")
                            }
                        });
                        $('.mydatatable').DataTable({
                            aoColumns: [
                                null,
                                {orderSequence: false},
                                {orderSequence: false},
                                null,
                                {orderSequence: false},
                                {orderSequence: false},
                                null,
                                null,
                                {orderSequence: false},
                            ],
                            language: {
                                lengthMenu: 'Hiển thị _MENU_ xe',
                                zeroRecords: 'Không tìm thấy kết quả nào!',
                                info: 'Trang _PAGE_ trên _PAGES_',
                                infoEmpty: 'No records available',
                                infoFiltered: '(filtered from _MAX_ total records)',
                            },
                        });
        </script>
        <script type="text/javascript">
            function validationphone(){
                var form = document.getElementById("form");
                var phone = document.getElementById("phone").value;
                var textphone = document.getElementById("textphone");
                var pattern = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
                if(phone.match(pattern)){
                    form.classList.add("valid");
                    form.classList.remove("invalid");
                    textphone.innerHTML = "Đúng định dạng"
                    textphone.style.color = "#00ff00"
                } else {
                    form.classList.remove("valid");
                    form.classList.add("invalid");
                    textphone.innerHTML = "Chưa đúng định dạng"
                    textphone.style.color = "#ff0000"

                }
                if(phone == ""){
                    form.classList.remove("valid");
                    form.classList.remove("invalid");
                    textphone.innerHTML = ""
                }
            }
            
            
        </script>
        
        <script type="text/javascript">
            function validationname(){
                var form = document.getElementById("form");
                var name = document.getElementById("name").value;
                var textname = document.getElementById("textname");
                var pattern = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$";
                if(name.match(pattern)){
                    form.classList.add("valid");
                    form.classList.remove("invalid");
                    textname.innerHTML = "Đúng định dạng"
                    textname.style.color = "#00ff00"

                } else {
                    form.classList.remove("valid");
                    form.classList.add("invalid");
                    textname.innerHTML = "Chưa đúng định dạng"
                    textname.style.color = "#ff0000"
                }
                if(name == ""){
                    form.classList.remove("valid");
                    form.classList.remove("invalid");
                    textphone.innerHTML = ""
                }
            }
            
            
        </script>
    </body>
</html>

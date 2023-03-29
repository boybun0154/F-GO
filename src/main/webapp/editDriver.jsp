<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Manage Account</title>
        <link rel="stylesheet" href="./CSS/manageStyle.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>

            <div class="content">
                <div class="header">
                    <h2>Quản lý tài khoản tài xế</h2>
                </div>
                <div class="group-function">
                    <button class="add-btn btn btn-primary text-uppercase">Thêm tài khoản</button>
                </div>
                <div class="container mb-3 mt-3">
                    <table class="table table-striped table-bordered mydatatable" style="width: 100%">
                        <thead style="text-align:center;">
                            <tr>
                                <th>ID</th>
                                <th>Tên tài khoản</th>
                                <th>Mật khẩu</th>
                                <th>Tên tài xế</th>
                                <th>Số điện thoại</th>
                                <th>Địa chỉ</th>
                                <th>Mã bằng lái</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listDA}" var="o">
                            <tr>
                                <td style="text-align:center;">${o.driverId}</td>
                                <td style="text-align:center;">${o.account}</td>
                                <td style="text-align:center;">${o.password}</td>
                                <td style="text-align:center;">${o.name}</td>
                                <td style="text-align:center;">${o.phone}</td>
                                <td style="text-align:center;">${o.address}</td>
                                <td style="text-align:center;">${o.license}</td>

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
                                    <h2 class="tm-block-title">Thêm tài khoản mới</h2>
                                </div>
                            </div>
                            <form action="AddDriverAccount" method="post" class="tm-edit-product-form">
                                <div class="row tm-edit-product-row" style="justify-content: center">
                                    <div class="col-xl-9 col-lg-9 col-md-12">
                                        <div class="form-group mb-3">
                                            <div class="row">
                                                <div class="col-12"> 
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <label for="username">Tên tài khoản
                                                            </label>
                                                            <input id="username" name="username" type="text" class="form-control validate" required />
                                                        </div>
                                                        <div class="col-6">
                                                            <label for="password">Mật khẩu
                                                            </label>
                                                            <input id="password" name="password" type="text" class="form-control validate" required />
                                                        </div>
                                                    </div>
                                                </div>  
                                            </div>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="name">Tên tài xế
                                            </label>
                                            <input id="name" name="name" type="text" class="form-control validate" required />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="phone">Số điện thoại
                                            </label>
                                            <input id="phone" name="phone" type="text" class="form-control validate" required />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="address">Địa chỉ
                                            </label>
                                            <input id="address" name="address" type="text" class="form-control validate" required />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="license">Bằng lái
                                            </label>
                                            <input id="license" name="license" type="text" class="form-control validate" required />
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="justify-content: center">
                                    <div class="col-3 mt-3 text-center">
                                        <button type="submit" class="btn btn-primary text-uppercase">Thêm tài khoản</button>
                                    </div>  
                                    <div class="col-3 mt-3 text-center">
                                        <a href="AddDriverAccount" type="button" class="btn btn-back">Trở lại</a>
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
                    null,
                    {orderSequence: false},
                    {orderSequence: false},
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
    </body>
</html>
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
        <link rel="stylesheet" href="./CSS/manageStyle.css">
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
                            <form id="form" action="AddDriverAccount" method="post" class="tm-edit-product-form">
                                <div class="row tm-edit-product-row" style="justify-content: center">
                                    <div class="col-xl-9 col-lg-9 col-md-12">
                                        <div class="form-group mb-3">
                                            <div class="row">
                                                <div class="col-12"> 
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <label for="username">Tên tài khoản
                                                            </label>
                                                            <input id="username" name="username" type="text" class="form-control validate" required onkeyup="validationAccName()" />
                                                            <span id="textusername"></span>
                                                        </div>
                                                        <div class="col-6">
                                                            <label for="password">Mật khẩu
                                                            </label>
                                                            <input id="password" name="password" type="password" class="form-control validate" required onkeyup="validationPass()" />
                                                            <span id="textpass"></span>
                                                        </div>
                                                    </div>
                                                </div>  
                                            </div>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="name">Tên tài xế
                                            </label>
                                            <input id="name" name="name" type="text" class="form-control validate" required onkeyup="validationname()" />
                                                                                        <span id="textname"></span>

                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="phone">Số điện thoại
                                            </label>
                                            <input id="phone" name="phone" type="text" class="form-control validate" required onkeyup="validationphone()" />
                                                                                        <span id="textphone"></span>

                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="address">Địa chỉ
                                            </label>
                                            <input id="address" name="address" type="text" class="form-control validate" required onkeyup="validationAddress()" />
                                            <span id="textAddress"></span>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="license">Bằng lái
                                            </label>
                                            <input id="license" name="license" type="text" class="form-control validate" required onkeyup="validationLicense()" />
                                            <span id="textLicense"></span>
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
        <script type="text/javascript">
            function validation(){
                var form = document.getElementById("form");
                var email = document.getElementById("email").value;
                var text = document.getElementById("text");
                var pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
                if(email.match(pattern)){
                    form.classList.add("valid");
                    form.classList.remove("invalid");
                    text.innerHTML = "Đúng định dạng"
                    text.style.color = "#00ff00"
                } else {
                    form.classList.remove("valid");
                    form.classList.add("invalid");
                    text.innerHTML = "Chưa đúng định dạng"
                    text.style.color = "#ff0000"

                }
                if(email == ""){
                    form.classList.remove("valid");
                    form.classList.remove("invalid");
                    text.innerHTML = ""
                }
            }
            
            
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
            function validationAccName(){
                var form = document.getElementById("form");
                var username = document.getElementById("username").value;
                var textusername = document.getElementById("textusername");
                var pattern = "^[A-Za-z0-9]+$";
                if(username.match(pattern)){
                    form.classList.add("valid");
                    form.classList.remove("invalid");
                    textusername.innerHTML = "Đúng định dạng"
                    textusername.style.color = "#00ff00"

                } else {
                    form.classList.remove("valid");
                    form.classList.add("invalid");
                    textusername.innerHTML = "Chưa đúng định dạng"
                    textusername.style.color = "#ff0000"
                }
                if(username == ""){
                    form.classList.remove("valid");
                    form.classList.remove("invalid");
                    username.innerHTML = ""
                }
            }
            
            
            function validationPass(){
                var form = document.getElementById("form");
                var password = document.getElementById("password").value;
                var textpass = document.getElementById("textpass");
                var pattern = "^[A-Za-z0-9]+$";
                if(password.match(pattern)){
                    form.classList.add("valid");
                    form.classList.remove("invalid");
                    textpass.innerHTML = "Đúng định dạng"
                    textpass.style.color = "#00ff00"

                } else {
                    form.classList.remove("valid");
                    form.classList.add("invalid");
                    textpass.innerHTML = "Chưa đúng định dạng"
                    textpass.style.color = "#ff0000"
                }
                if(password == ""){
                    form.classList.remove("valid");
                    form.classList.remove("invalid");
                    password.innerHTML = ""
                }
            }
            
            
            function validationAddress(){
                var form = document.getElementById("form");
                var address = document.getElementById("address").value;
                var textAddress = document.getElementById("textAddress");
                var pattern = "[^a-zA-Z\d\s]";
                if(address.match(pattern)){
                    form.classList.add("valid");
                    form.classList.remove("invalid");
                    textAddress.innerHTML = "Đúng định dạng"
                    textAddress.style.color = "#00ff00"

                } else {
                    form.classList.remove("valid");
                    form.classList.add("invalid");
                    textAddress.innerHTML = "Chưa đúng định dạng"
                    textAddress.style.color = "#ff0000"
                }
                if(address == ""){
                    form.classList.remove("valid");
                    form.classList.remove("invalid");
                    address.innerHTML = ""
                }
            }
            
            
            function validationLicense(){
                var form = document.getElementById("form");
                var license = document.getElementById("license").value;
                var textLicense = document.getElementById("textLicense");
                var pattern = "^[A-Za-z0-9]+$";
                if(license.match(pattern)){
                    form.classList.add("valid");
                    form.classList.remove("invalid");
                    textLicense.innerHTML = "Đúng định dạng"
                    textLicense.style.color = "#00ff00"

                } else {
                    form.classList.remove("valid");
                    form.classList.add("invalid");
                    textLicense.innerHTML = "Chưa đúng định dạng"
                    textLicense.style.color = "#ff0000"
                }
                if(license == ""){
                    form.classList.remove("valid");
                    form.classList.remove("invalid");
                    license.innerHTML = ""
                }
            }

            
            
            
            
            
            
        </script>
    </body>
</html>
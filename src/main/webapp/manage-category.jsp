<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>F-GO</title>
        <link rel="stylesheet" href="./CSS/manageStyle.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="SemiColonWeb" />

        <!-- Stylesheets
        ============================================= -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700|Roboto:300,400,500,700&display=swap" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css" />
        <link rel="stylesheet" href="CSS/style.css" type="text/css" />
        <link rel="stylesheet" href="CSS/swiper.css" type="text/css" />

        <!-- One Page Module Specific Stylesheet -->
        <link rel="stylesheet" href="one-page/onepage.css" type="text/css" />
        <!-- / -->

        <link rel="stylesheet" href="CSS/dark.css" type="text/css" />
        <link rel="stylesheet" href="CSS/font-icons.css" type="text/css" />
        <link rel="stylesheet" href="one-page/css/et-line.css" type="text/css" />
        <link rel="stylesheet" href="CSS/animate.css" type="text/css" />
        <link rel="stylesheet" href="CSS/magnific-popup.css" type="text/css" />

        <link rel="stylesheet" href="one-page/css/fonts.css" type="text/css" />

        <link rel="stylesheet" href="CSS/custom.css" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <!-- Document Title
        ============================================= -->
        <title>Header - Floating Style | Canvas</title>

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
                <h2>Quản lý loại xe</h2>
            </div>
            <div class="group-function">

                <!-- <div class="searchBar">
                    <input type="text" id="searchBar" placeholder="Nhập tên xe bạn muốn tìm kiếm">
                </div> -->

                <button class="add-btn btn btn-primary text-uppercase">Thêm loại xe mới</button>



                <!-- <div class="sortby">
                    <div class="dropdown">
                        <button class="dropdown-btn">Sắp xếp theo</button>
                        <div class="dropdown-content">
                            <a href="#">Chỗ ngồi</a>
                            <a href="#">Giá tiền</a>
                            <a href="#">Năm sản xuất</a>
                        </div>
                    </div>
                </div> -->
            </div>
            <div class="container mb-3 mt-3">
                <table class="table table-striped table-bordered mydatatable" style="width: 100%">
                    <thead style="text-align:center;">
                        <tr>
                            <th>ID</th>
                            <th>Loại xe</th>
                            <th>Hình ảnh</th>
                            <th>Chức năng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listC}" var="o">
                            <tr>
                                <td>${o.categoryId}</td>
                                <td>${o.categoryName}</td>
                                <td style=" text-align: center"><img src="${o.categoryImg}" width= "100" height="70"/></td>
                                
                                <td style="text-align:center;">
                                    <a href="load_to_edit_category?cid=${o.categoryId}" class="btn">
                                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                        <span><strong>Chỉnh sửa</strong></span>
                                    </a>
                                    <a href="delete_category?cid=${o.categoryId}" class="btn">
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
                                    <h2 class="tm-block-title">Thêm loại xe mới</h2>
                                </div>
                            </div>
                            <form action="addcategory" method="post" class="tm-edit-product-form" enctype="multipart/form-data">
                                <div class="row tm-edit-product-row">
                                    <div class="col-xl-6 col-lg-6 col-md-12">
                                        <div class="form-group mb-3">
                                            <label for="catename">Tên loại xe
                                            </label>
                                            <input id="catename" name="catename" type="text" class="form-control validate" required />
                                        </div>

                                       

                                        
                                        
                                        
                                        

                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                        <!--                                <div class="tm-product-img-dummy mx-auto">
                                                                            <i class="fa fa-cloud-upload tm-upload-icon"
                                                                               onclick="document.getElementById('fileInput').click();"></i>
                                                                        </div>-->
                                        <!--                                <div class="custom-file mt-3 mb-3">
                                                                            <input name="image" id="fileInput" type="file" />
                                                                            <input name="image" type="button" class="btn btn-primary btn-block mx-auto" value="UPLOAD PRODUCT IMAGE"
                                                                                   onclick="document.getElementById('fileInput').click();" />
                                                                        </div>-->
                                        <div class="form-group mb-3">
                                            <label>Hình Ảnh</label>
                                            <input id="image" name="image" type="file" accept="image/*" class="form-control" required>
                                            <input id="link" name="link" type="text" class="form-control" value="image-input" hidden>
                                        </div>
                                        
                                        
                                        
                                        
                                    </div>
                                </div>
                                <div class="row justify-content-center">        
                                    <div class="col-3 text-center mt-3">
                                        <button type="submit" class="btn btn-primary text-uppercase">Thêm loại xe</button>
                                    </div>  
                                    <div class="col-3 text-center mt-3">
                                        <a href="managecategory" type="button" class="btn btn-back">Trở lại</a>
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
        <script>
            $('document').ready(function () {
                $('input[type=file]').on('change', function () {
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
                            $("#link").val(obj.data.url);
                        });
                    }
                });
            });
        </script>
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

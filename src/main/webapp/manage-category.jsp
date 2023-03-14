<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Manage Category</title>
        <link rel="stylesheet" href="./CSS/manageStyle.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
        
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
                                            <input name="image" type="file" class="form-control" required>
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

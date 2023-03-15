<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./CSS/editProductStyle.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="container add-block">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title">Chỉnh sửa</h2>
                            </div>
                        </div>
                        <form action="edit_customer" method="post" class="tm-edit-product-form" enctype="multipart/form-data">
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-6 col-lg-6 col-md-12">
                                    <div class="form-group">
                                        <input name="id" type="hidden" class="form-control validate" value="${edit.customerId}" required  />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Họ và tên
                                        </label>
                                        <input id="name" name="name" type="text" class="form-control validate" value="${edit.customerName}" required />
                                        <span id="textname"></span>
                                    </div>


                                    <div class="form-group mb-3">
                                        <label for="phone">Số điện thoại
                                        </label>
                                        <input id="phone" name="phone" type="text" class="form-control validate" value="${edit.phone}" required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="email">Email
                                        </label>
                                        <input id="email" name="email" type="text" class="form-control validate" value="${edit.email}" required />
                                    </div>
                                    <div class="form-group">
                                        <input id="accountId" name="accountId" type="hidden" class="form-control validate" value="${edit.accountId}" required />
                                    </div>


                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                    <div class="form-group mt-3 mb-3">
                                        <label>Hình ảnh khuôn mặt</label>
                                        <input name="faceImg" type="file" accept="image/*" class="form-control" required>
                                        <input id="faceLink" name="faceLink" type="text" class="form-control" value="image-input" hidden>
                                    </div>
                                    <div class="form-group mt-3 mb-3">
                                        <label>Căn cước công dân</label>
                                        <input name="nationalId" type="file" accept="image/*" class="form-control" required>
                                        <input id="idLink" name="idLink" type="text" class="form-control" value="image-input" hidden>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label>Bằng lái xe</label>
                                        <input name="drivinglicense" type="file" accept="image/*" class="form-control" required>
                                        <input id="licenseLink" name="licenseLink" type="text" class="form-control" value="image-input" hidden>
                                    </div>
                                </div>
                            </div>
                            <div class="row justify-content-center">        
                                <div class="col-3 text-center mt-3">
                                    <button type="submit" class="btn btn-primary text-uppercase">Lưu</button>
                                </div>  
                                <div class="col-3 text-center mt-3">
                                    <a href="viewprofile?accountID=${edit.accountId}" type="button" class="btn btn-back">Trở lại</a>
                                </div>  
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script>
            $('document').ready(function () {
                $('input[name=faceImg]').on('change', function () {
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
                            $("#faceLink").val(obj.data.url);
                        });
                    }
                });
            });
        </script>
        <script>
            $('document').ready(function () {
                $('input[name=nationalId]').on('change', function () {
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
                            $("#idLink").val(obj.data.url);
                        });
                    }
                });
            });
        </script>
        <script>
            $('document').ready(function () {
                $('input[name=drivinglicense]').on('change', function () {
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
                            $("#licenseLink").val(obj.data.url);
                        });
                    }
                });
            });
        </script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
    </body>
</html>
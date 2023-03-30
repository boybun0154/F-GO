<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>F-GO</title>
        <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./CSS/signupStyle.css">
    </head>
    <body>
    <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
        <div class="container">
            <div class="card signup-card">
                <div class="row no-gutters">
                    <div class="col-md-5">
                        <img src="IMG/login.jpg" alt="signup" class="signup-card-img">
                    </div>
                    <div class="col-md-7">
                        <div class="card-body">
                            <div class="brand-wrapper">
                                <img src="IMG/logo.png" alt="logo" class="logo">
                            </div>
                            <p class="signup-card-description">Đăng ký tài khoản F-Go</p>
                            <form action="VerifyCode" method="post" autocomplete="off">
                                <p style="color: forestgreen">Mã xác thực đã được gửi đến mail của bạn tại ${email}</p>
                                <div class="form-group">
                                    <input type="text" name="email" value="${email}" hidden>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope fa-2x mx-4"></i></span>
                                        <input type="text" name="inputcode" placeholder="Mã xác thực">
                                    </div>
                                </div>
                                <small style="color: red">${mess}</small>
                                <button class="btn btn-block signup-btn mb-4" type="submit">Xác thực</button>
                            </form>

                            <p class="signup-card-footer-text">Đã có tải khoản? <a href="login.jsp" class="text-reset">Trở lại đăng nhập</a></p>

                            <div style=" margin-top: 20px;">
                                <a class="btn-back" href="Home">Quay lại Trang chủ</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>
</html>

  
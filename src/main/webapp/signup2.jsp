<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign up F-Go</title>
        <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
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
                                <form action="signup" method="post">
                                    <p style="color: red">${mess}</p>
                                    <p style="color: red">${messS}</p>
                                    <div class="form-group">
                                        <label for="user" class="sr-only">Tài khoản</label>
                                        <input type="text" name="user" id="user"  class="form-control"
                                               placeholder="Tài khoản" required>
                                    </div>
                                    <div class="form-group mb-4">
                                        <label for="password" class="sr-only">Mật Khẩu</label>
                                        <input type="password" name="pass" id="password" class="form-control"
                                               placeholder="Mật khẩu" required>
                                    </div>
                                    <div class="form-group mb-4">
                                        <label for="repassword" class="sr-only">Nhập Lại Mật Khẩu</label>
                                        <input type="password" name="repass" id="repassword" class="form-control"
                                               placeholder="Nhập lại mật khẩu" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="sr-only">Họ và tên</label>
                                        <input type="text" name="name" id="name"  class="form-control"
                                               placeholder="Họ và tên" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="phone" class="sr-only">Số điện thoại</label>
                                        <input type="text" name="phone" id="phone"  class="form-control"
                                               placeholder="Số điện thoại" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="sr-only">Email</label>
                                        <input type="text" name="email" id="email"  class="form-control"
                                               value=${email} readonly>
                                    </div>
                                    <button class="btn btn-block signup-btn mb-4" type="submit">Đăng kí</button>
                                </form>

                                <p class="signup-card-footer-text">Đã có tải khoản? <a href="login.jsp" class="text-reset">Trở lại đăng nhập</a></p>

                                <p>Hoặc</p>
                                <div class="social-signup row">
                                    <div class="col-md-6 mb-2">
                                        <a class="btn btn-outline-dark social-login-btn" href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/F-Go/GoogleLoginServlet&response_type=code
                                           &client_id=207223522866-t903tlahfetmc1hdi4h0bgoarumaec3c.apps.googleusercontent.com&approval_prompt=force" role="button">
                                            <img width="20px" alt="Google sign-in"
                                                 src="IMG/google_logo.png" />
                                            Đăng nhập bằng Google
                                        </a>
                                    </div>
                                </div>
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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login F-GO</title>
        <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/loginStyle.css">
    </head>
    <body>
        <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
            <div class="container">
                <div class="card login-card">
                    <div class="row no-gutters">
                        <div class="col-md-5">
                            <img src="IMG/login.jpg" alt="login" class="login-card-img">
                        </div>
                        <div class="col-md-7">
                            <div class="card-body">
                                <div class="brand-wrapper">
                                    <img src="IMG/logo.png" alt="logo" class="logo">
                                </div>
                                <p class="login-card-description">Đăng nhập vào F-Go</p>
                                <form action="LoginControl" method="post">
                                    <p style="color: red">${mess}</p>
                                    <div class="form-group">
                                        <label for="text" class="sr-only">Tài khoản</label>
                                        <input type="text" name="account" id="account" class="form-control"
                                               placeholder="Tài khoản" required>
                                    </div>
                                    <div class="form-group mb-4">
                                        <label for="password" class="sr-only">Mật Khẩu</label>
                                        <input type="password" name="password" id="password" class="form-control"
                                               placeholder="Mật khẩu" required>
                                    </div>
                                    <a href="forgotPassword.jsp" class="forgot-password-link">Quên mật khẩu?</a>
                                    <input name="login" id="login" class="btn btn-block login-btn mb-4" type="submit"
                                           value="Đăng nhập">
                                </form>

                                <p class="login-card-footer-text">Chưa có tải khoản? <a href="signup.jsp" class="text-reset">Đăng ký
                                        tại đây!</a></p>

                                <p>Hoặc</p>
                                <div class="social-login row">
                                    <div class="col-md-6 mb-2">
                                        <a class="btn btn-outline-dark social-login-btn" href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/GoogleLoginServlet&response_type=code
                                           &client_id=610265253425-dq7bkc7t5dv5ogd4q0ol2b58sv3bfj3d.apps.googleusercontent.com&approval_prompt=force" role="button">
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

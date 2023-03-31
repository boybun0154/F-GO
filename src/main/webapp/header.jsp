
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="top-bar" class="transparent-topbar dark">
                <div class="container">

                    <div class="row justify-content-between">
                        <div class="col-12 col-md-auto">

                            <!-- Top Links
                            ============================================= -->
                            <div class="top-links">
                                <ul class="top-links-container">
                                    <li class="top-links-item"><a href="Home">Home</a></li>
                                        <c:if test="${sessionScope.acc == null}">
                                        <li class="top-links-item"><a href="login.jsp">Login</a></li>
                                        <li class="top-links-item"><a href="signup.jsp">Signup</a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.acc != null}">

                                        <li class="top-links-item"><a href="logout">Logout</a></li>
                                        </c:if>

                                    <!--<li class="top-links-item"><a href="contact.html">Contact</a></li>-->

                                </ul>
                            </div><!-- .top-links end -->

                        </div>

                        <div class="col-12 col-md-auto">

                            <!-- Top Social
                            ============================================= -->
                            <ul id="top-social">
                                <li><a href="#" class="si-facebook"><span class="ts-icon"><i class="icon-facebook"></i></span><span class="ts-text">Facebook</span></a></li>
                                <li><a href="#" class="si-twitter"><span class="ts-icon"><i class="icon-twitter"></i></span><span class="ts-text">Twitter</span></a></li>
                                <li><a href="#" class="si-pinterest"><span class="ts-icon"><i class="icon-pinterest"></i></span><span class="ts-text">Pinterest</span></a></li>
                                <li><a href="#" class="si-instagram"><span class="ts-icon"><i class="icon-instagram2"></i></span><span class="ts-text">Instagram</span></a></li>
                                <li><a href="tel:+1.11.85412542" class="si-call"><span class="ts-icon"><i class="icon-call"></i></span><span class="ts-text">+1.11.85412542</span></a></li>
                                <li><a href="mailto:info@canvas.com" class="si-email3"><span class="ts-icon"><i class="icon-envelope-alt"></i></span><span class="ts-text">info@canvas.com</span></a></li>
                            </ul><!-- #top-social end -->

                        </div>
                    </div>

                </div>
            </div>
<header id="header" class="transparent-header floating-header">
                <div id="header-wrap">
                    <div class="container">
                        <div class="header-row">

                            <!-- Logo
                            ============================================= -->
                            <div id="logo">
                                <a style="height: 30px;border-radius: 4px;vertical-align: baseline;" href="Home" class="standard-logo" data-dark-logo="IMG/logo.png"><img src="IMG/logo.png" alt="Canvas Logo"></a>
                                <a href="Home" class="retina-logo" data-dark-logo="images/logo-dark@2x.png"><img src="images/logo@2x.png" alt="Canvas Logo"></a>
                            </div><!-- #logo end -->

                            <div class="header-misc">

                                <!-- Top Search
                                ============================================= -->
                                <div id="top-search" class="header-misc-icon">
                                    <a href="#" id="top-search-trigger"><i class="icon-line-search"></i><i class="icon-line-cross"></i></a>
                                </div><!-- #top-search end -->

                                <!-- Top Cart
                                ============================================= -->
                                <div id="top-cart" class="header-misc-icon d-none d-sm-block">
                                    <!--<a href="#" id="top-cart-trigger"><i class="icon-line-bag"></i><span class="top-cart-number">5</span></a>-->

                                    <c:if test="${sessionScope.acc.role == 0}">
                                        <a   type="button" href="wishlist"><i class="icon-line-bag"></i></a>
                                        </c:if>


                                </div><!-- #top-cart end -->

                            </div>

                            <div id="primary-menu-trigger">
                                <svg class="svg-trigger" viewBox="0 0 100 100"><path d="m 30,33 h 40 c 3.722839,0 7.5,3.126468 7.5,8.578427 0,5.451959 -2.727029,8.421573 -7.5,8.421573 h -20"></path><path d="m 30,50 h 40"></path><path d="m 70,67 h -40 c 0,0 -7.5,-0.802118 -7.5,-8.365747 0,-7.563629 7.5,-8.634253 7.5,-8.634253 h 20"></path></svg>
                            </div>

                            <!-- Primary Navigation
                            ============================================= -->
                            <nav class="primary-menu">

                                <ul class="menu-container">
                                    <li class="menu-item">
                                        <a class="menu-link" href="Home"><div>Home</div></a>
                                        
                                    </li>
                                    <li class="menu-item">
                                        <a class="menu-link" href="#"><div>About Us</div></a>
                                        
                                    </li>
                                    <li class="menu-item mega-menu">
                                        <a class="menu-link" href="#"><div>Contact</div></a>
                                        
                                    </li>
                                    <li class="menu-item mega-menu">
                                        <a class="menu-link" href="#"><div>Instruction</div></a>
                                        
                                    </li>
                                    <li class="menu-item">
                                        <a class="menu-link" href="shop.html"><div></div></a>
                                    </li>
                                    <c:if test="${sessionScope.acc != null}">    
                                        <li class="menu-item">
                                            <a class="menu-link" href="#"><div>Hello ${sessionScope.acc.account}</div></a>
                                            <ul class="sub-menu-container">
                                                <c:if test="${sessionScope.acc.role == 2}">
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="static"><div><i class="icon-wpforms"></i>Thống kê chính</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="Stat.jsp"><div><i class="icon-wpforms"></i>Theo dõi doanh thu</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="manageadmin"><div><i class="icon-wpforms"></i>Quản lý admin</div></a>
                                                    </li>

                                                </c:if>

                                                <c:if test="${sessionScope.acc.role == 1 || sessionScope.acc.role == 2}">

                                                    <li class="menu-item">
                                                        <a class="menu-link" href="manageaccount"><div><i class="icon-wpforms"></i>Quản lý tài khoản</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="Blacklist"><div><i class="icon-wpforms"></i>Quản lý danh sách den</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="AddDriverAccount"><div><i class="icon-wpforms"></i>Quản lý tài khoản tài xế</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="managecustomer"><div><i class="icon-wpforms"></i>Quản lý khách hàng</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="manageorder"><div><i class="icon-wpforms"></i>Quản lý đơn thuê</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="manageproduct"><div><i class="icon-wpforms"></i>Quản lý xe</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="managecategory"><div><i class="icon-wpforms"></i>Quản lý loại xe</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="vehiclelocation.jsp"><div><i class="icon-wpforms"></i>Xem vị trí phương tiện</div></a>
                                                    </li>
                                                </c:if>

                                                <c:if test="${sessionScope.acc.role == 0}">
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="viewprofile?accountID=${sessionScope.acc.accountID}"><div><i class="icon-wpforms"></i>Thông tin cá nhân</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="load_to_view_order?accid=${sessionScope.acc.accountID}"><div><i class="icon-cogs"></i>Thông tin thuê xe</div></a>
                                                    </li>
                                                </c:if>
                                                <c:if test="${sessionScope.acc.role ==3}">

                                                    <li class="menu-item">
                                                        <a class="menu-link" href="nulldriver?accountID=${sessionScope.acc.accountID}"><div><i class="icon-wpforms"></i>Order chưa có tài xế</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="ReportControl?accountID=${sessionScope.acc.accountID}"><div><i class="icon-wpforms"></i>Xem danh sách Order</div></a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="ReportEditServlet?accountID=${sessionScope.acc.accountID}"><div><i class="icon-wpforms"></i>Xem danh sách Report</div></a>
                                                    </li>

                                                </c:if>
                                                    <li class="menu-item">
                                                        <a class="menu-link" href="changePassword.jsp"><div><i class="icon-wpforms"></i>Đổi mật khẩu</div></a>
                                                    </li>
                                                    
                                            </ul>
                                        </li>
                                    </c:if>

                                </ul>

                            </nav><!-- #primary-menu end -->

                            <form class="top-search-form" action="search.html" method="get">
                                <input type="text" name="q" class="form-control" value="" placeholder="Type &amp; Hit Enter.." autocomplete="off">
                            </form>

                        </div>
                    </div>
                </div>
                <div class="header-wrap-clone"></div>
            </header>
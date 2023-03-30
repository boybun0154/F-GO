<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="DAO.AddFeeDAO" %>
<%@ page import="entity.additionFee" %>
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
                    <h2>Quản lý report</h2>
                </div>
                <div class="container mb-3 mt-3">
                    <table class="table table-striped table-bordered" style="width: 100%">
                        <thead style="text-align:center;">
                            <tr>
                                <th>id</th>
                                <th>Order id</th>
                                <th>Damage Percentage</th>
                                <th>exDistance</th>
                                <th>Title</th>
                                <th>Content</th>
                                <th>Date</th>
                                <th>Payment status</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${reports}" var="o">
                        <c:forEach items="${feeList}" var="f">
                            <c:if test="${o.id == f.report_id}">
                                <c:set var="status" value= "${f.status}"/>
                            </c:if>
                        </c:forEach>
                        <form action="ReportEditServlet" method="post">
                            <input type="hidden" name="id" value="${o.id}">
                            <tr style="text-align:center;">
                                <td>${o.id}</td>
                                <td>${o.order_id}</td>
                                <td>${o.damagePercent}</td>
                                <td>${o.exDistance}</td>
                                <td>${o.title}</td>
                                <td>${o.content}</td>
                                <td>${o.date}</td>
                                <c:if test="${status == null}">
                                    <td></td>
                                </c:if>
                                <c:if test="${status == 1}">
                                    <td>Not paid</td>
                                </c:if>
                                <c:if test="${status == 0}">
                                    <td>Paid</td>
                                </c:if>
                                <c:if test="${o.damagePercent!=0 || o.exDistance!=0}">
                                    <td style="text-align:center; color:white">
                                        <a href="EmailServlet?orderID=${o.order_id}&reportID=${o.id}" title="send mail" class="btn btn-warning text-light"
                                          >Mail</a>
                                    </td>
                                    <td >
                                        <button disabled type="submit" class="btn btn-danger">Delete</button>
                                    </td>
                                    <c:if test="${status == null}">
                                    <td></td>
                                    </c:if>
                                    <c:if test="${status == 1}">
                                    <td >
                                        <a href="ReportEditServlet?accountID=${accid}&action=paid&&reportID=${o.id}" title="paid" class="btn btn-success">Paid</a>
                                    </td>
                                    </c:if>
                                    <c:if test="${status == 0}">
                                        <td >
                                        <a href="ReportEditServlet?accountID=${accid}&action=paid&&reportID=${o.id}" title="paid" class="btn btn-success disabled">Paid</a>
                                    </td>
                                    </c:if>
                                    
                                </c:if>
                                <c:if test="${o.damagePercent== 0 && o.exDistance==0}">
                                    <td style="text-align:center;">
                                        <a title="no addtional fee" class="btn btn-warning disabled text-light"
                                           >Mail</a>
                                    </td>
                                    <td >
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </td>
                                    <td >
                                        <a href="ReportEditServlet?accountID=${accid}&action=paid&&reportID=${o.id}" title="paid" class="btn btn-success disabled">Paid</a>
                                    </td>
                                </c:if>
                            </tr>
                        </form>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
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

        </script>
                        <!-- Go To Top
============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>

<!-- JavaScripts
============================================= -->
<script src="JS/jquery.js"></script>
<script src="JS/plugins.min.js"></script>
<script src="https://maps.google.com/maps/api/js?key=YOUR-API-KEY"></script>

<!-- Footer Scripts
============================================= -->
<script src="JS/functions.js"></script>
    </body>
</html>

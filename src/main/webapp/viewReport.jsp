<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="DAO.AddFeeDAO" %>
<%@ page import="entity.additionFee" %>
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
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${reports}" var="o">
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
                                <c:if test="${o.damagePercent!=0 || o.exDistance!=0}">
                                    <td style="text-align:center;">
                                        <a data-toggle="modal" data-target="#myModal"title="view addtional fee" class="btn btn-warning"
                                         data-id="${o.id}"   >Addtional Fee</a>
                                    </td>
                                    <td >
                                        <button disabled type="submit" class="btn btn-danger">Delete</button>
                                    </td>
                                </c:if>
                                <c:if test="${o.damagePercent== 0 && o.exDistance==0}">
                                    <td style="text-align:center;">
                                        <a title="no addtional fee" class="btn btn-warning disabled"
                                           >Addtional Fee</a>
                                    </td>
                                    <td >
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </td>
                                </c:if>
                            </tr>
                        </form>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
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
    </body>
</html>

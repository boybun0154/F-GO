<%-- 
    Document   : review
    Created on : Jul 3, 2022, 4:53:42 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="SemiColonWeb" />
                
        <link rel="stylesheet" href="./CSS/orderStyle2.css">
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
        <div class="container" style="margin-top:5%; margin-bottom:5%">
            <section class="h-100" style="background-color: #eee; padding:30px">
                <form style="margin-left:30%" action="/F-Go/executePayment" method="post">
                    <table>      
                        <tr>
                            <td colspan="2"><h1>Review order before payment</h1></td>
                            
                            <td>
                                <input type="hidden" name="paymentId" value="${param.paymentId}" />
                                <input type="hidden" name="PayerID" value="${param.PayerID}" />
                            </td>
                        </tr>
                        <tr><td><br/></td></tr>
                        <tr>
                            <td>------------------------------------</td>
                        </tr>
                        <tr>
                            <td><b>Description:</b></td>
                            <td>${transaction.description}</td>
                        </tr>   
                        <tr>
                            <td>Total:</td>
                            <td>${transaction.amount.total} USD</td>
                        </tr>
                        <tr><td><br/></td></tr>
                        <tr>
                            <td colspan="2"><b>Payer Information:</b></td>
                        </tr>
                        <tr>
                            <td>First Name:</td>
                            <td>${payer.firstName}</td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td>${payer.lastName}</td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td>${payer.email}</td>
                        </tr>
                        
                        <tr><td><br/></td></tr>
                        <tr>
                            <td colspan="2"><b>Order Information:</b></td>
                        </tr>
                        <tr>
                            <td>Vehicle name:</td>
                            <td>${item.name}</td>
                        </tr>
                        <tr>
                            <td>Order detail:</td>
                            <td>${item.description}</td>
                        </tr>
                        <tr><td><br/></td></tr>
                        <tr>
                            <td>------------------------------------</td>
                        </tr>
                        <tr>
                            <td colspan="2" >
                                <input class="btn btn-success" style="margin-top:3%" type="submit" value="Pay Now" />
                            </td>
                        </tr>    
                    </table>
                </form>
            </section>
        </div>


        <jsp:include page="footer.jsp"></jsp:include>

        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/home-page.js"></script>
        <script type="text/javascript">
        let subMenu = document.getElementById("subMenu");
            const $menu = $('.sub-menu-wrap');
            function toggleMenu() {
                subMenu.classList.toggle("open-menu");
            }
            $(document).mouseup(function (e) {
                var container = $(".user-pic");
                if (!container.is(e.target) && subMenu.classList.toggle("open-menu")) {
                    subMenu.classList.toggle("open-menu");
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

<!-- Footer Scripts
============================================= -->
<script src="JS/functions.js"></script>
    </body>

</html>


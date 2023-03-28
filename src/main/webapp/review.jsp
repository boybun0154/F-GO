<%-- 
    Document   : review
    Created on : Jul 3, 2022, 4:53:42 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>F-Go</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="CSS/homeStyle.css"/>
        <title>Review Page</title>
    </head>

    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
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
    </body>

</html>


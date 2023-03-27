<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>get List from ajax</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#buttonDisplay').click(function() {
			$.ajax({
				type : 'GET',
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				url : '${pageContext.request.contextPath }/ajax',
				success : function(result) {
					var products = $.parseJSON(result);
					var s = '';
					for(var i = 0; i < products.length; i++) {
                        //print list
                        s += products[i].productID + ' ' + products[i].productName +'<br>'
                        
					}
					$('#result').html(s);
				}
			});
		});

	});
</script>
</head>
<body>

	<h3>Return Object List in Ajax</h3>
	<form>
		<input type="button" value="Dislay" id="buttonDisplay">
		<br>
		<span id="result"></span>
	</form>

</body>
</html>
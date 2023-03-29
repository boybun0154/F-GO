<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>get List from ajax</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
	<link rel="stylesheet" href="./CSS/allProductsStyle.css">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container" style="margin-top: 6%">
		<div class="row">
			<div class="col-4">
				<div class="filter-container">
					<div class="container overflow-auto" style="height: 600px">
						<form onsubmit="filter()">
							<div class="basic-filter">
								<div class="form-group">
									<label for="sorting-select">Sắp xếp theo:</label>
									<select class="form-control" id="sorting-select">
										<option value="0">Mặc định</option>
										<option value="1">Giá thấp nhất</option>
										<option value="2">Giá cao nhất</option>
									</select>
								</div>

								<div class="form-group">
										<label for="price-range">Mức giá</label>
										<input type="range" class="form-control-range" id="price-range" name="price-range"
											   min="300" max="3000000" step="100" value="3000000">
										<div class="d-flex justify-content-between">
											<span class="min-value">300K</span>
											<span class="max-value">3000000K</span>
										</div>
								</div>

								<div class="form-group">
									<label for="vehicle-type">Loại xe</label>
									<div class="row" id="vehicle-type">
										<div class="form-check col-md-4">
											<input class="form-check-input checkBoxType" type="checkbox" name="vt_1" id="vt_1" value="4">
											<label class="form-check-label" for="vt_1">
												<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-4-sedan.png" class="img-fluid" alt="4 chỗ">
												4 chỗ
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input checkBoxType" type="checkbox" name="vt_5" id="vt_5" value="5">
											<label class="form-check-label" for="vt_5">
												<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-5-suv.png" class="img-fluid" alt="5 chỗ">
												5 chỗ
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input checkBoxType" type="checkbox" name="vt_6" id="vt_6" value="2">
											<label class="form-check-label" for="vt_6">
												<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-4-sedan.png" class="img-fluid" alt="2 chỗ">
												2 chỗ
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input checkBoxType" type="checkbox" name="vt_7" id="vt_7" value="7">
											<label class="form-check-label" for="vt_7">
											<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-pickup.png" class="img-fluid">
												Bán tải
											</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="car-brand">Hãng xe</label>
									<select class="form-control" name="car_brand" id="car-brand">
										<option value="0">Tất cả</option>
										<option value="1">Hyundai</option>
										<option value="2">VinFast</option>
										<option value="3">Mazda</option>
										<option value="4">Toyota</option>
										<option value="5">Honda</option>
									</select>
								</div>

								<div class="form-group">
									<label for="transmission-type">Truyền động</label>
									<select class="form-control" id="transmission-type">
										<option value="0">Tất cả</option>
										<option value="1">Số tự động</option>
										<option value="2">Số sàn</option>
										<option value="3">Xe số</option>
										<option value="4">Xe tay ga</option>
									</select>
								</div>
							</div>

							<div class="advance-filter ">
								<div class="form-group">
									<label for="seats">Số chỗ</label>
									<input type="range" class="form-control-range" id="seats" name="seats"
										   min="2" max="10" step="1" value="4">
									<div class="d-flex justify-content-between">
										<span class="min-value">2</span>
										<span class="max-value">10</span>
									</div>
								</div>

								<div class="form-group">
									<label for="year">Năm sản xuất</label>
									<input type="range" class="form-control-range" id="year" name="year"
										   min="2005" max="2023" step="1" value="2023">
									<div class="d-flex justify-content-between">
										<span class="min-value">2005</span>
										<span class="max-value">2023</span>
									</div>
								</div>

								<div class="form-group">
									<label for="fuel">Nhiên liệu</label>
									<select class="form-control" id="fuel">
										<option value="0">Tất cả</option>
										<option value="1">Xăng</option>
										<option value="2">Điện</option>
									</select>
								</div>
							</div>
							<div class="my-4"></div>
							<button type="submit" class="btn btn-outline-secondary btn-lg btn-block mb-4">
								<i class="fa fa-search"></i> Search
							</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-8">
				<div class="product-container">
					<div class="container overflow-auto" style="height: 600px; width: 900px">
						<div id="content" class="row">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.2.1.js"
			integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>
	<script>
	$(document).ready(function() {
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
					s += "<div class=\"product col-sm-6\">\n" +
							"    <a href=\"view_car_detail?pid="+ products[i].productID +"\">\n" +
							"        <div class=\"product-card\">\n" +
							"            <div class=\"card-thumbnail\">\n" +
							"                <img class=\"img-responsive\" style=\"height:250px\" src=\""+ products[i].productImg +"\">\n" +
							"            </div>\n" +
							"            <div class=\"card-content\">\n" +
							"                <div class=\"order-btn\">\n" +
							"                    <a class=\"order-btn-text\" href=\"view_car_detail?pid="+ products[i].productID +"\"><i class=\"fa fa-eye\" aria-hidden=\"true\"></i></a>\n" +
							"                </div>\n" +
							"                <h1 class=\"card-title\">\n" + products[i].productName +
							"\n" +
							"                </h1>\n" +
							"                <h2 class=\"card-sub-title\">\n" +
							"                    "+ products[i].yearRelease +"\n" +
							"                </h2>\n" +
							"                <div class=\"description\">\n" +
							"                    <ul>\n" +
							"                        <li>\n" +
							"                            <i class=\"fa fa-th hidden-xs hidden-sm\"></i>\n" +
							"                            <span>\n" +
							"                                <span class=\"attri\">"+ products[i].licensePlate +"</span> \n" +
							"                            </span>\n" +
							"                        </li>\n" +
							"                        <li>\n" +
							"                            <i class=\"fa fa-users hidden-xs hidden-sm\"></i>\n" +
							"                            <span>\n" +
							"                                <span class=\"attri\">"+ products[i].seat +"</span> \n" +
							"                            </span>\n" +
							"                        </li>\n" +
							"                        <li>\n" +
							"                            <i class=\"fa fa-cogs hidden-xs hidden-sm\"></i>\n" +
							"                            <span>\n" +
							"                                <span class=\"attri\">"+ products[i].gear +"</span> \n" +
							"                            </span>\n" +
							"                        </li>\n" +
							"                    </ul>\n" +
							"                </div>\n" +
							"                <div class=\"price\">\n" +
							"                    <div class=\"price-text\">"+ products[i].price +"đ</div>\n" +
							"                </div>\n" +
							"            </div>\n" +
							"        </div>\n" +
							"    </a>\n" +
							"</div>";

				}
				$('#content').html(s);
			}
		});	
	});

	function filter(){
		event.preventDefault();
		var sortingSelect = document.getElementById("sorting-select").value;
        var priceRange= document.getElementById("price-range").value;
        var vehicleType= document.querySelector('.checkBoxType:checked');
        if(vehicleType != null){
        var vehicleTypeValue= document.querySelector('.checkBoxType:checked').value;
        }
        var carBrand= document.getElementById("car-brand").value;
        var transmissionType= document.getElementById("transmission-type").value;
        var seats= document.getElementById("seats").value;
        var fuel= document.getElementById("fuel").value;
        var year= document.getElementById("year").value;
		console.log("priceRange: "+priceRange+" vehicleTypeValue: "+vehicleTypeValue+" carBrand: "+carBrand+" transmissionType: "+transmissionType+" seats: "+seats+" fuel: "+fuel+" year: "+year)
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
				//sort by price
				if(sortingSelect == "1"){
					products.sort(function(a, b) {
						return a.price - b.price;
					});
				}else if(sortingSelect=="2"){
					products.sort(function(a, b) {
						return b.price - a.price;
					});
				}

				for(var i = 0; i < products.length; i++) {
					var p=	"<div class=\"product col-sm-6\">\n" +
							"    <a href=\"view_car_detail?pid="+ products[i].productID +"\">\n" +
							"        <div class=\"product-card\">\n" +
							"            <div class=\"card-thumbnail\">\n" +
							"                <img class=\"img-responsive\" style=\"height:250px\" src=\""+ products[i].productImg +"\">\n" +
							"            </div>\n" +
							"            <div class=\"card-content\">\n" +
							"                <div class=\"order-btn\">\n" +
							"                    <a class=\"order-btn-text\" href=\"view_car_detail?pid="+ products[i].productID +"\"><i class=\"fa fa-eye\" aria-hidden=\"true\"></i></a>\n" +
							"                </div>\n" +
							"                <h1 class=\"card-title\">\n" + products[i].productName +
							"\n" +
							"                </h1>\n" +
							"                <h2 class=\"card-sub-title\">\n" +
							"                    "+ products[i].yearRelease +"\n" +
							"                </h2>\n" +
							"                <div class=\"description\">\n" +
							"                    <ul>\n" +
							"                        <li>\n" +
							"                            <i class=\"fa fa-th hidden-xs hidden-sm\"></i>\n" +
							"                            <span>\n" +
							"                                <span class=\"attri\">"+ products[i].licensePlate +"</span> \n" +
							"                            </span>\n" +
							"                        </li>\n" +
							"                        <li>\n" +
							"                            <i class=\"fa fa-users hidden-xs hidden-sm\"></i>\n" +
							"                            <span>\n" +
							"                                <span class=\"attri\">"+ products[i].seat +"</span> \n" +
							"                            </span>\n" +
							"                        </li>\n" +
							"                        <li>\n" +
							"                            <i class=\"fa fa-cogs hidden-xs hidden-sm\"></i>\n" +
							"                            <span>\n" +
							"                                <span class=\"attri\">"+ products[i].gear +"</span> \n" +
							"                            </span>\n" +
							"                        </li>\n" +
							"                    </ul>\n" +
							"                </div>\n" +
							"                <div class=\"price\">\n" +
							"                    <div class=\"price-text\">"+ products[i].price +"đ</div>\n" +
							"                </div>\n" +
							"            </div>\n" +
							"        </div>\n" +
							"    </a>\n" +
							"</div>";
						//filter
						var checkPrice=parseInt(products[i].price)<parseInt(priceRange);
						var checkSeat=parseInt(vehicleTypeValue)==parseInt(products[i].seat);
						var checkcarBrand=parseInt(carBrand)==parseInt(products[i].categoryID);
						switch(transmissionType){
							case "1":
								var gear ="Số tự động";
								break;
							case "2":
								var gear ="Số sàn";
								break;
							case "3":
								var gear ="Xe số";
								break;
							case "4":
								var gear ="Xe tay ga";
								break;
						}

						var checktransmissionType=gear==products[i].gear;
						switch(fuel){
							case "1":
								var fuelType ="Xăng";
								break;
							case "2":
								var fuelType ="Điện";
								break;
						}
						var checkfuel=fuelType==products[i].fuel;
						var checkyear=parseInt(year)>parseInt(products[i].yearRelease);
						//check null
						if(vehicleType==null)	checkSeat=true;
						if(parseInt(carBrand)==0)	checkcarBrand=true;
						if(parseInt(transmissionType)==0)	checktransmissionType=true;
						if(parseInt(fuel)==0)	checkfuel=true;
						//check filter
						if(checkPrice && checkSeat && checkcarBrand && checktransmissionType && checkfuel && checkyear){
							s+=p;
						}

				}
				$('#content').html(s);
			}
		});	
	}
</script>

</body>
</html>
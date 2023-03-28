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
						<form action="#" method="post">
							<div class="basic-filter">
								<div class="form-group">
									<label for="sorting-select">Sắp xếp theo:</label>
									<select class="form-control" id="sorting-select">
										<option value="op">Tối ưu</option>
										<option value="dt">Khoảng cách gần nhất</option>
										<option value="pl">Giá thấp nhất</option>
										<option value="ph">Giá cao nhất</option>
										<option value="rt">Đánh giá tốt nhất</option>
									</select>
								</div>

								<div class="form-group">
										<label for="price-range">Mức giá</label>
										<input type="range" class="form-control-range" id="price-range" name="price-range"
											   min="300" max="3000" step="100" value="3000">
										<div class="d-flex justify-content-between">
											<span class="min-value">300K</span>
											<span class="max-value">3000K</span>
										</div>
								</div>

								<div class="form-group">
									<label for="vehicle-type">Loại xe</label>
									<div class="row" id="vehicle-type">
										<div class="form-check col-md-4">
											<input class="form-check-input" type="checkbox" name="vt_3" id="vt_3" value="3">
											<label class="form-check-label" for="vt_3">
												<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-4-mini.png" class="img-fluid" alt="4 chỗ (Mini)">
												4 chỗ (Mini) (165 xe)
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input" type="checkbox" name="vt_1" id="vt_1" value="1">
											<label class="form-check-label" for="vt_1">
												<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-4-sedan.png" class="img-fluid" alt="4 chỗ (Sedan)">
												4 chỗ (Sedan) (642 xe)
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input" type="checkbox" name="vt_4" id="vt_4" value="4">
											<label class="form-check-label" for="vt_4">
												<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-4-hatchback.png" class="img-fluid" alt="4 chỗ (Hatchback)">
												4 chỗ (Hatchback) (31 xe)
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input" type="checkbox" name="vt_5" id="vt_5" value="5">
											<label class="form-check-label" for="vt_5">
												<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-5-suv.png" class="img-fluid" alt="5 chỗ (Gầm cao)">
												5 chỗ (Gầm cao) (128 xe)
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input" type="checkbox" name="vt_2" id="vt_2" value="2">
											<label class="form-check-label" for="vt_2">
												<img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-7-suv.png" class="img-fluid" alt="7 chỗ (Gầm cao)">
												7 chỗ (Gầm cao) (494 xe)
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input" type="checkbox" name="vt_6" id="vt_6" value="6">
											<label class="form-check-label" for="vt_6">
												<div class="thumbnail" style="padding: 0.5rem;"><img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-7-mpv.png" class="img-fluid"></div>
												7 chỗ (Gầm thấp) (235 xe)
											</label>
										</div>
										<div class="form-check col-md-4">
											<input class="form-check-input" type="checkbox" name="vt_7" id="vt_7" value="7">
											<label class="form-check-label" for="vt_7">
												<div class="thumbnail" style="padding: 0.5rem;"><img src="https://n1-cstg.mioto.vn/m/vehicle-types/mf-pickup.png" class="img-fluid"></div>
												Bán tải (78 xe)
											</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="car-brand">Hãng xe</label>
									<select class="form-control" name="car_brand" id="car-brand">
										<option value="0">Tất cả</option>
										<option value="2">BMW (5 xe)</option>
										<option value="4">Ford (75 xe)</option>
										<option value="10">Honda (143 xe)</option>
										<option value="11">Hyundai (195 xe)</option>
										<option value="43">Tesla (1 xe)</option>
										<option value="6">Mazda (116 xe)</option>
										<option value="7">Mercedes (12 xe)</option>
										<option value="9">Toyota (321 xe)</option>
										<option value="29">Vinfast (126 xe)</option>
									</select>
								</div>

								<div class="form-group">
									<label for="transmission-type">Truyền động</label>
									<select class="form-control" id="transmission-type">
										<option value="0">Tất cả</option>
										<option value="1">Số tự động</option>
										<option value="2">Số sàn</option>
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
										   min="2005" max="2023" step="1" value="2005">
									<div class="d-flex justify-content-between">
										<span class="min-value">2005</span>
										<span class="max-value">2023</span>
									</div>
								</div>

								<div class="form-group">
									<label for="fuel">Nhiên liệu</label>
									<select class="form-control" id="fuel">
										<option value="">Tất cả</option>
										<option value="1">Xăng</option>
										<option value="2">Dầu</option>
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
					<div class="container overflow-auto" style="height: 600px">
						<div id="content" class="row">
							<c:forEach items="${listP}" var="o">
								<div class="product col-sm-6">
									<a href="view_car_detail?pid=${o.productID}">
										<div class="product-card">
											<div class="card-thumbnail">
												<img class="img-responsive" src="${o.productImg}">
											</div>
											<div class="card-content">
												<div class="order-btn">
													<a class="order-btn-text" href="view_car_detail?pid=${o.productID}"><i
															class="fa fa-eye" aria-hidden="true"></i></a>
												</div>
												<h1 class="card-title">
														${o.productName}
												</h1>
												<h2 class="card-sub-title">
														${o.yearRelease}
												</h2>
												<div class="description">
													<ul>
														<li>
															<i class="fa fa-th hidden-xs hidden-sm"></i>
															<span>
                                                        <span class="attri">${o.licensePlate}</span> </span>
														</li>
														<li>
															<i class="fa fa-users hidden-xs hidden-sm"></i>
															<span>
                                                        <span class="attri">${o.seat}</span> </span>
														</li>
														<li>
															<i class="fa fa-cogs hidden-xs hidden-sm"></i>
															<span>
                                                        <span class="attri">${o.gear}</span> </span>
														</li>
													</ul>
												</div>
												<div class="price">
													<div class="price-text">${o.price} đ</div>
												</div>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
	</div>
<%--		<div class="row">--%>
<%--			<h3>Return Object List in Ajax</h3>--%>
<%--			<form>--%>
<%--				<input type="button" value="Dislay" id="buttonDisplay">--%>
<%--				<br>--%>
<%--				<span id="result"></span>--%>
<%--			</form>--%>
<%--		</div>--%>
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

</body>
</html>
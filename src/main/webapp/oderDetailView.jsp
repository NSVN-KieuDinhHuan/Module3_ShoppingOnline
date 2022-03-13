<%@ page import="com.codegym.service.ShopService" %>
<%@ page import="com.codegym.dao.shopDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Colo Shop Categories</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="Colo Shop Template">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link href="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
	<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
	<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/animate.css">
	<link rel="stylesheet" type="text/css" href="/plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="/styles/categories_styles.css">
	<link rel="stylesheet" type="text/css" href="/styles/categories_responsive.css">
<style>
	@import url(http://fonts.googleapis.com/css?family=Calibri:400,300,700);




	.card {
		margin-bottom: 30px;
		border: 0;
		-webkit-transition: all .3s ease;
		transition: all .3s ease;
		letter-spacing: .5px;
		border-radius: 8px;
		-webkit-box-shadow: 1px 5px 24px 0 rgba(68, 102, 242, .05);
		box-shadow: 1px 5px 24px 0 rgba(68, 102, 242, .05)
	}

	.card  {
		border-bottom: none;
		padding: 24px;
		border-top-left-radius: 8px;
		border-top-right-radius: 8px
	}



	.card .card-body {
		padding: 30px;
		background-color: transparent
	}

	.btn-primary,
	.btn-primary.disabled,
	.btn-primary:disabled {
		background-color: #4466f2 !important;
		border-color: #4466f2 !important
	}
</style>

</head>

<body>

<div class="super_container">

	<!-- Header -->

	<header class="header trans_300">

		<!-- Top Navigation -->

		<div class="top_nav">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="top_nav_left">free shipping on all u.s orders over $50</div>
					</div>
					<div class="col-md-6 text-right">
						<div class="top_nav_right">
							<ul class="top_nav_menu">

								<!-- Currency / Language / My Account -->

								<li class="currency">
									<a href="#">
										usd
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="currency_selection">
										<li><a href="#">cad</a></li>
										<li><a href="#">aud</a></li>
										<li><a href="#">eur</a></li>
										<li><a href="#">gbp</a></li>
									</ul>
								</li>
								<li class="language">
									<a href="#">
										English
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="language_selection">
										<li><a href="#">French</a></li>
										<li><a href="#">Italian</a></li>
										<li><a href="#">German</a></li>
										<li><a href="#">Spanish</a></li>
									</ul>
								</li>
								<li class="account">
									<a href="#">
										<c:if test="${user!=null}">
											${user.getName()}
										</c:if>
										<c:if test="${user==null}">
											My Account

										</c:if>
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="account_selection">
										<c:if test="${user!=null}">
											<li><a href="/home?action=history "><i class="fa fa-history" aria-hidden="true"></i>History</a></li>
											<li><a href="/home?action=profile "><i class="fa fa-user" aria-hidden="true"></i>Profile</a></li>
											<li><a href="/home?action=logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>										</c:if>
										<c:if test="${user==null}">
											<li><a href="/signin.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
											<li><a href="/register.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
										</c:if>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Main Navigation -->

		<div class="main_nav_container">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-right">
						<div class="logo_container">
							<a href="/home?action=home">GROUP2<span>shop</span></a>
						</div>
						<nav class="navbar">
							<ul class="navbar_menu">
								<li><a href="/home?action=home">home</a></li>
								<li><a href="/home?action=categories">shop</a></li>
								<li><a href="#">promotion</a></li>
								<li><a href="#">pages</a></li>
								<li><a href="#">blog</a></li>
								<li><a href="/home?action=contact">contact</a></li>
							</ul>
							<ul class="navbar_user">
<%--								<li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>--%>
<%--								<li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>--%>
								<li class="checkout">
									<a href="/home?action=orderDetail">
										<i class="fa fa-shopping-cart" aria-hidden="true"></i>
										<span id="checkout_items" class="checkout_items">${oderDetails.size()}</span>
									</a>
								</li>
							</ul>
							<div class="hamburger_container">
								<i class="fa fa-bars" aria-hidden="true"></i>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>

	</header>

	<div class="fs_menu_overlay"></div>





	<div class="container product_section_container">
		<div class="row">
			<div class="col product_section clearfix">

				<!-- Breadcrumbs -->

				<div class="breadcrumbs d-flex flex-row align-items-center">
					<ul>
						<li><a href="/home?action=categories">Shop</a></li>


							<li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Payment</a></li>


					</ul>
				</div>
<c:if test = "${oderDetails.size()==0}">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body cart">
						<div class="col-sm-12 empty-cart-cls text-center"> <img src="https://i.imgur.com/dCdflKN.png" width="130" height="130" class="img-fluid mb-4 mr-3">
							<h3><strong>Your Cart is Empty</strong></h3>
							<h4>Add something to make me happy :)</h4> <a href="/home?action=categories" class="btn btn-primary cart-btn-transform m-3" data-abc="true">continue shopping</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>

				<c:if test = "${oderDetails.size()>0}">
				<div class="row">
					<div class="col-lg-4">

						<div class="invoice-to">
							<h3>Delivery address</h3>
							<hr st>
					<c:if test = "${user!=null}">
							<address class="m-t-5 m-b-5">
								<strong class="text-inverse">${user.name}</strong><br>
								Address: ${user.address}<br>
								Phone: ${user.phone}<br>
								email: ${user.email}<br>
							</address>
					</c:if>
					<c:if test = "${user==null}">
						<div class="alert alert-danger" role="alert">
							you have not signed in
						</div>
						<a href="/signin.jsp"   class="btn btn-primary">Signed in</a>

					</c:if>
						</div>
					</div>
					<div class="col-md-8">

				<caption><h3 style="margin-bottom: 50px">ORDER DETALIES</h3></caption>
				<table class="table">
					<thead>
					<tr style="text-align: center">

						<th style="width: 30%" scope="col">Name</th>
						<th style="width: 15%" scope="col">Quantity</th>
						<th style="width: 15%" scope="col">Price</th>
						<th style="width: 15%" scope="col">Money</th>
						<th style="width: 15%" scope="col">Delete</th>
					</tr>
					</thead>
					<tbody>
					<c:set var = "totalMoney" scope = "request" value = "${0}"/>
					<c:forEach var="order"  items="${oderDetails}">

					<tr style="text-align: center">

						<td>${shopService.findProductByID(order.product_id).name}</td>
						<td>${order.quantity}</td>
						<td>${shopService.findProductByID(order.product_id).price}</td>
						<c:set var = "money" scope = "request" value = "${order.quantity*shopService.findProductByID(order.product_id).price}"/>
						<td><c:out value = "${money}"/> $</td>
						<c:set var = "totalMoney" scope = "request" value = "${Math.round((totalMoney+money)*100/100)}"/>
						<c:set var="orderid" scope = "request" value ="${order.getId()}"/>
						<td><a href="/home?action=orderDetail&id=${orderid}">delete</a></td>
					</tr>

					</c:forEach>
					<tr>
						<td colspan="4"><h3>Total</h3></td>
						<td colspan="2"><h4><c:out value = "${totalMoney}"/> $</h4></td>
					</tr>
					</tbody>
				</table>
					<div style="margin-left: auto;margin-right: auto">
					<a href="/home?action=payment"   class="btn btn-primary">Make Payment</a>
					</div>
				</c:if>
					</div>
				</div>
		</div>
	</div>

				<!-- Breadcrumbs -->











	<!-- Footer -->

	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
						<ul class="footer_nav">
							<li><a href="#">Blog</a></li>
							<li><a href="#">FAQs</a></li>
							<li><a href="contact.html">Contact us</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center">
						<ul>
							<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="footer_nav_container">
						<div class="cr">©2018 All Rights Reserverd. Template by <a href="#">Colorlib</a> &amp; distributed by <a href="https://themewagon.com">ThemeWagon</a></div>
					</div>
				</div>
			</div>
		</div>
	</footer>

</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="/plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="/plugins/easing/easing.js"></script>
<script src="/plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<%--<script src="/js/categories_custom.js"></script>--%>
</body>

</html>

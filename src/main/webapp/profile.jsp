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
	body {
		background-color: #f9f9fa
	}

	.padding {
		padding: 3rem !important
	}

	.user-card-full {
		overflow: hidden
	}

	.card {
		border-radius: 5px;
		-webkit-box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.08);
		box-shadow: 0 1px 20px 0 rgba(69, 90, 100, 0.08);
		border: none;
		margin-bottom: 30px
	}

	.m-r-0 {
		margin-right: 0px
	}

	.m-l-0 {
		margin-left: 0px
	}

	.user-card-full .user-profile {
		border-radius: 5px 0 0 5px
	}

	.bg-c-lite-green {
		background: -webkit-gradient(linear, left top, right top, from(#f29263), to(rgba(62, 138, 96, 0.45)));
		background: linear-gradient(to right, rgba(62, 138, 96, 0.45), #f29263)
	}

	.user-profile {
		padding: 20px 0
	}

	.card-block {
		padding: 1.25rem
	}

	.m-b-25 {
		margin-bottom: 25px
	}

	.img-radius {
		border-radius: 5px
	}

	h6 {
		font-size: 14px
	}

	.card .card-block p {
		line-height: 25px
	}

	@media only screen and (min-width: 1400px) {
		p {
			font-size: 14px
		}
	}

	.card-block {
		padding: 1.25rem
	}

	.b-b-default {
		border-bottom: 1px solid #ffffff
	}

	.m-b-20 {
		margin-bottom: 20px
	}

	.p-b-5 {
		padding-bottom: 5px !important
	}

	.card .card-block p {
		line-height: 25px
	}

	.m-b-10 {
		margin-bottom: 10px
	}

	.text-muted {
		color: #050505 !important
	}

	.b-b-default {
		border-bottom: 1px solid #e0e0e0
	}

	.f-w-600 {
		font-weight: 600
	}

	.m-b-20 {
		margin-bottom: 20px
	}

	.m-t-40 {
		margin-top: 20px
	}

	.p-b-5 {
		padding-bottom: 5px !important
	}

	.m-b-10 {
		margin-bottom: 10px
	}

	.m-t-40 {
		margin-top: 20px
	}

	.user-card-full .social-link li {
		display: inline-block
	}

	.user-card-full .social-link li a {
		font-size: 20px;
		margin: 0 10px 0 0;
		-webkit-transition: all 0.3s ease-in-out;
		transition: all 0.3s ease-in-out
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
							<a href="/home">GROUP2<span>shop</span></a>
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


							<li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Profile</a></li>


					</ul>
				</div>








						<div class="page-content page-container" id="page-content">
							<div class="padding">
								<div class="row container d-flex justify-content-center">
									<div class="col-xl-12 col-md-12">
										<div class="card user-card-full">
											<div class="row m-l-0 m-r-0">
												<div class="col-sm-4 bg-c-lite-green user-profile">
													<div class="card-block text-center text-white">
														<div class="m-b-25"> <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius" alt="User-Profile-Image"> </div>
														<h6 class="f-w-600">${user.name}</h6>
														<p>User ID:${user.id}</p> <i class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
													</div>
												</div>
												<div class="col-sm-8">
													<div class="card-block">
														<h6 class="m-b-20 p-b-5 b-b-default f-w-600">Email</h6>
														<div class="row">
															<div class="col-sm-12">
																<h6 class="text-muted f-w-400">${user.email}</h6>
															</div>
														</div>
														<h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Phone</h6>
														<div class="row">
														<div class="col-sm-12">
															<h6 class="text-muted f-w-400">${user.phone}</h6>
														</div>
														</div>

														<h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Address</h6>
														<div class="row">
															<div class="col-sm-12">
																${user.address}
															</div>
														</div>
														<ul class="social-link list-unstyled m-t-40 m-b-10">
															<li><a href="#!" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="facebook" data-abc="true"><i class="mdi mdi-facebook feather icon-facebook facebook" aria-hidden="true"></i></a></li>
															<li><a href="#!" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="twitter" data-abc="true"><i class="mdi mdi-twitter feather icon-twitter twitter" aria-hidden="true"></i></a></li>
															<li><a href="#!" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="instagram" data-abc="true"><i class="mdi mdi-instagram feather icon-instagram instagram" aria-hidden="true"></i></a></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
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

</body>

</html>

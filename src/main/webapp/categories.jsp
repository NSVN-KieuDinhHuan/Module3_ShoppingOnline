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
										<c:if test="${username!=null}">
											${username}
										</c:if>
										<c:if test="${username==null}">
											My Account

										</c:if>
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="account_selection">
										<c:if test="${username!=null}">
											<li><a href="/home?action=logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
										</c:if>
										<c:if test="${username==null}">
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
							<a href="#">colo<span>shop</span></a>
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
									<a href="/home?action=payment">
										<i class="fa fa-shopping-cart" aria-hidden="true"></i>
										<span id="checkout_items" class="checkout_items">${productNumberInCart}</span>
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

						<c:if test="${categorySevelet==3}">
							<li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Men's</a></li>
						</c:if>
						<c:if test="${categorySevelet==2}">
							<li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Accessories</a></li>
						</c:if>
						<c:if test="${categorySevelet==1}">
							<li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>women</a></li>
						</c:if>
						<c:if test="${categorySevelet==0}">
							<li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>All products</a></li>
						</c:if>

					</ul>
				</div>

				<!-- Sidebar -->

				<div class="sidebar">
					<div class="sidebar_section">
						<div class="sidebar_title">
							<h5>Product Category</h5>
						</div>
						<ul class="sidebar_categories">
							<li ><a href="/home?action=categories&category_id=1">women</a></li>
							<li><a href="/home?action=categories&category_id=2">Accessories</a></li>
							<li><a href="/home?action=categories&category_id=3">Men</a></li>
							<li><a href="/home?action=categories&category_id=">All products</a></li>
						</ul>
					</div>
				</div>



				<!-- Main Content -->

				<div class="main_content">

					<!-- Products -->

					<div class="products_iso">
						<div class="row">
							<div class="col">
								<!-- Product Sorting -->
								 <div class="product_sorting_container product_sorting_container_top">
									<ul class="product_sorting" style="float: right">
										<li>
                                            <c:choose>
                                                <c:when test="${sorting==1}">
                                                    <span class="type_sorting_text">price: Low to High </span>
                                                </c:when>
                                                <c:when test="${sorting==2}">
                                                    <span class="type_sorting_text">price: High to Low</span>
                                                </c:when>
												<c:when test="${sorting==3}">
													<span class="type_sorting_text">Product Name</span>
												</c:when>
                                                <c:otherwise>
                                                    <span class="type_sorting_text">Default Sorting</span>
                                                </c:otherwise>
                                            </c:choose>
											<i class="fa fa-angle-down"></i>
											<ul class="sorting_type">
												<li class="type_sorting_btn"><span><a href="/home?action=categories&sorting=0">Default Sorting</a></span></li>
												<li class="type_sorting_btn"><span><a href="/home?action=categories&sorting=1">price: Low to High</a></span></li>
												<li class="type_sorting_btn"><span><a href="/home?action=categories&sorting=2">price: High to Low</a></span></li>
												<li class="type_sorting_btn"><span><a href="/home?action=categories&sorting=3">Product Name</a></span></li>
											</ul>
										</li>
									</ul>

                                    <div style="float: left">
                                        <form action="/home" method="get">
                                            <div class="input-group rounded">
                                                <input  name="search" value="${search}" type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                                                <button class="btn btn-search fa fa-search" type="submit" ></button>
                                            </div>
                                        </form>
                                    </div></li>
								</div>

								<!-- Product Grid -->
								<div class="product-grid">
                                             <c:forEach var="product"  items="${showAllproducts}">
									            <div class="product-item">
										            <div class="product product_filter">
											            <div class="product_image">
															<a href="home?action=detailProduct&id=${product.id}"><img src=${product.productImage} alt="link"></a>
                                                        </div>
											            <div class="favorite"></div>
											            <div class="product_info">
												           <h6 class="product_name"><a href="home?action=detailProduct&id=${product.id}">${product.name}</a></h6>
												           <div class="product_price">${product.price} $</div>
											            </div>
										            </div>
										           <div class="red_button add_to_cart_button">
                                                     <a href="#">add to cart</a>
                                                   </div>
									            </div>
                                             </c:forEach>
                                </div>
								<!-- Product Sorting -->

							</div>




						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Benefit -->

	<div class="benefit">
		<div class="container">
			<div class="row benefit_row">
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon"><i class="fa fa-truck" aria-hidden="true"></i></div>
						<div class="benefit_content">
							<h6>free shipping</h6>
							<p>Suffered Alteration in Some Form</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon"><i class="fa fa-money" aria-hidden="true"></i></div>
						<div class="benefit_content">
							<h6>cach on delivery</h6>
							<p>The Internet Tend To Repeat</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon"><i class="fa fa-undo" aria-hidden="true"></i></div>
						<div class="benefit_content">
							<h6>45 days return</h6>
							<p>Making it Look Like Readable</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon"><i class="fa fa-clock-o" aria-hidden="true"></i></div>
						<div class="benefit_content">
							<h6>opening all week</h6>
							<p>8AM - 09PM</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Newsletter -->

	<div class="newsletter">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="newsletter_text d-flex flex-column justify-content-center align-items-lg-start align-items-md-center text-center">
						<h4>Newsletter</h4>
						<p>Subscribe to our newsletter and get 20% off your first purchase</p>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
						<input id="newsletter_email" type="email" placeholder="Your email" required="required" data-error="Valid email is required.">
						<button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300" value="Submit">subscribe</button>
					</div>
				</div>
			</div>
		</div>
	</div>

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
<script src="/js/categories_custom.js"></script>
</body>

</html>

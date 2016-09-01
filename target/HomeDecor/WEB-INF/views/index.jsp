<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="shortcut icon" href="/assets/images/logo2.jpg">
<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/assets/css/font-awesome.min.css">
<script src="/assets/js/css3-animate-it.js"></script>
<link rel="stylesheet" href="/assets/css/main.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script  src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
<%-- <script src="<c:url value='/assets/js/angularJsController.js'/>"/></script> --%>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin-left: 15%;
}
</style>
</head>

<body class="home">
	<!-- Fixed navbar -->
	<div><%@ include file="header.jsp"%>
	</div>
	<!-- /.navbar -->

	<!-- Header -->
	<header id="head">
		<div class="container">
			<div class="row">
				<h1 class="lead">HOME DECOR</h1>
				<p class="tagline">Family where Life begins &amp; Love never
					ends...</p>
				<p>
					<a href="about" class="btn btn-default btn-lg" role="button">MORE
						INFO</a> <a class="btn btn-action btn-lg" href="newarrivals"
						role="button">Buy Now >></a>
				</p>
			</div>
		</div>
	</header>
	<!-- /Header -->

	<!-- Intro -->
	<div class="container text-center">
		<br> <br>
		<h2 class="thin">The best place to tell people why they are here</h2>
		<p class="text-muted">Home Decor offers a unique selection of stylish, contemporary, and chic furniture online.</p>
	</div>
	<!-- /Intro-->

	<!-- Highlights - jumbotron -->

	<section id="service"
		class="jumbotron top-space home-section color-dark bg-gray">
		<div class="container marginbot-50">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div>
						<div class="section-heading text-center">
							<h2 class="h-bold">New Arrivals For u</h2>							
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="text-center">
			<div class="container">
				<div class="row animatedParent">
				<div class="col-xs-6 col-sm-4 col-md-4">
						<div class="animated rotateInDownLeft">
							<div class="service-box">
								<div class="service-icon">
									<span><img src="assets\images\images\living.jpg" class="img-thumbnail" 
										alt="living" /></span>
								</div>
									<a href="disp?id=2" class="btn-link" >Living Rooms Set </a>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-4 col-md-4">
						<div class="animated rotateInDownLeft">
							<div class="service-box">
								<div class="service-icon ">
									<span><img src="assets\images\images\bedroom.jpg" class="img-thumbnail"
										alt="Bedroom" /></span>
								</div>					
									<a href="disp?id=1" class="btn-link">Bed Rooms Set</a>
								</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-4 col-md-4">
						<div class="animated rotateInDownLeft">
							<div class="service-box">
								<div class="service-icon">
									<span><img src="assets\images\images\kitchen set.jpg" class="img-thumbnail" width="85%"
										alt="kitchen set" /></span>
								</div>
									<a href="disp?id=3" class="btn-link">Kitchen set</a>

							</div>
						</div>
					</div>
	
				</div>
			</div>
		</div>
	</section>
	<!-- /Highlights -->

	<!-- container -->
	<h2 class="text-center thin h-bold">IN SPOTLIGHT</h2>
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="assets\images\dinning\8-seater-dining-table-sets.jpg" alt="dinning"
						width="460px" height="345px">
				</div>
				<div class="item">
					<img src="assets\images\bedrooms\Dunston_Upholstered_Bed_King_01_2_1.jpg" alt="bedrooms"
						width="460" height="345">
				</div>
				<div class="item">
					<img src="assets\images\images\bedroom1.jpg" alt="Flower"
						width="460" height="345">
				</div>
				
				<div class="item">
					<img src="assets\images\images\dinning1.jpg" alt="Flower"
						width="460" height="345">
				</div>
				<div class="item">
					<img src="assets\images\dinning\Simple-Dining-Room-Design-Ideas.jpg" alt="Flower"
						width="460" height="345">
				</div>

			</div>
			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<!-- /container -->

	<!-- Social links. @TODO: replace by link/instructions in template -->
	<section id="social">
		<div class="container">
			<div class="wrapper clearfix">
				<!-- AddThis Button BEGIN -->
				<div class="addthis_toolbox addthis_default_style">
					<a class="addthis_button_facebook_like"
						fb:like:layout="button_count"></a> <a class="addthis_button_tweet"></a>
					<a class="addthis_button_linkedin_counter"></a> <a
						class="addthis_button_google_plusone" g:plusone:size="medium"></a>
				</div>
				<!-- AddThis Button END -->
			</div>
		</div>
	</section>
	<!-- /social links -->


	<footer id="footer" class="top-space"><%@ include
			file="footer.jsp"%>




	</footer>





	

</body>
</html>
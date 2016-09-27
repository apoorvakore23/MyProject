
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<link rel="stylesheet" media="screen"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/bootstrap-theme.css"
	media="screen">
<link rel="stylesheet" href="assets/css/main.css">
<script src="assets/js/regform.js"></script>
<style>
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>


</head>

<body>
	<!-- Fixed navbar -->
	<div><%@ include file="header.jsp"%>
	</div>
	<!-- /.navbar -->

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">Registration</li>
		</ol>

		<div class="top-margin">

			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Registration</h1>
				</header>

				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Register a new account</h3>
							<p class="text-center text-muted ">
								Already Registered with Us? <a href="signin.html"
									class="glyphicon glyphicon-log-in"> Login</a>
							</p>
							<hr>

							<div class="container-wrapper">


								<form:form action="${pageContext.request.contextPath}/register"
									method="post" commandName="customer">

									<h3>Basic Info:</h3>

									<div class="form-group">
										<label for="name">Name</label><span class="text-danger">*</span>

										<form:input path="customerName" id="name" class="form-Control" />
										<form:errors path="customerName" cssStyle="color: #ff0000" />
									</div>

									<div class="form-group">
										<label for="email">Email</label> <span style="color: #ff0000">${emailMsg}</span>

										<form:input path="customerEmail" id="email"
											class="form-Control" />
										<span class="text-danger">*</span>
										<form:errors path="customerEmail" cssStyle="color: #ff0000" />
									</div>

									<div class="form-group">
										<label for="phone">Phone</label>
										<form:input path="customerPhone" id="phone"
											class="form-Control" />
									</div>

									<div class="form-group">
										<label for="username">Username</label> <span
											style="color: #ff0000">${usernameMsg}</span>

										<form:input path="username" id="username" class="form-Control" />
										<span class="text-danger">*</span>
										<form:errors path="username" cssStyle="color: #ff0000" />
									</div>

									<div class="form-group">
										<label for="password">Password</label>

										<form:password path="password" id="password"
											class="form-Control" />
										<span class="text-danger">*</span>
										<form:errors path="password" cssStyle="color: #ff0000" />
									</div>



									<br />

									<h3>Shipping Address:</h3>

									<div class="form-group">
										<label for="shippingStreet">House Number </label>
										<form:input path="shippingAddress.houseNumber"
											id="houseNumber" class="form-Control" />
									</div>

									<div class="form-group">
										<label for="shippingApartmentNumber">AddressLine1</label>
										<form:input path="shippingAddress.addressLine1"
											id="addressLine1" class="form-Control" />
									</div>

									<div class="form-group">
										<label for="shippingCity">AddressLine2</label>
										<form:input path="shippingAddress.addressLine2"
											id="addressLine2" class="form-Control" />
									</div>

									<div class="form-group">
										<label for="shippingState">city</label>
										<form:input path="shippingAddress.city" id="city"
											class="form-Control" />
									</div>

									<div class="form-group">
										<label for="shippingCountry">state</label>
										<form:input path="shippingAddress.state" id="state"
											class="form-Control" />
									</div>

									<div class="form-group">
										<label for="shippingZip">country</label>
										<form:input path="shippingAddress.country" id="country"
											class="form-Control" />
									</div>
									<div class="form-group">
										<label for="shippingZip">zipCode</label>
										<form:input path="shippingAddress.zipCode" id="zipCode"
											class="form-Control" />
									</div>
									<br />
									<br />

									<input type="submit" value="submit" class="btn btn-default">
									<a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
								</form:form>
						</div>





						</div>
					</div>

				</div>

			</article>
			<!-- /Article -->

		</div>
	</div>
	<!-- /container -->


	<footer id="footer" class="top-space">

		<%@ include file="footer.jsp"%>
	</footer>

	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
</body>
</html>
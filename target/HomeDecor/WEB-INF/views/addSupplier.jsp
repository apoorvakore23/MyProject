<!DOCTYPE html>
<html lang="en">
<head>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="assets/css/bootstrap-theme.css"
	media="screen">
<style>
.errStyle {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body class="home">
<div>
	<%@ include file="header.jsp"%>
	</div><header id="head" class="secondary"></header>
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">Add Supplier</li>
		</ol>

		<div class="row">
		<header class="page-header">
					<h1 class="page-title">Add Supplier</h1>
				</header>
		<form:form role="form" enctype="form-data" action="addSuppliers"
			modelAttribute="supplier">
			<div class="form-group">
				<form:label path="name" >
					<spring:message text="Supplier Name" />
				</form:label>
				<form:input class="form-control" path="name" />
				<form:errors path="name">
					<p class="errStyle">* Product Name should be atleast 3
						characters</p>
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="address">
					<spring:message text="Address of Supplier" />
				</form:label>
				<form:input class="form-control" path="address" />
				<form:errors path="qty">
					<p class="errStyle">* should be greater than 1</p>
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="emailID">
					<spring:message text="EmailID of Supplier" />
				</form:label>
				<form:input class="form-control" path="emailID" />
				<form:errors path="qty">
					<p class="errStyle">* should be greater than 1</p>
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="contactNo">
					<spring:message text="ContactNo of Supplier" />
				</form:label>
				<form:input class="form-control" path="contactNo" />
				<form:errors path="qty">
					<p class="errStyle">* should be greater than 1</p>
				</form:errors>
			</div>
			
			
			<div class="form-group">
				<input class="btn btn-info" type="submit"
					value="<spring:message text="Add Supplier"/>" />

			</div>
		</form:form>


	
	</div></div>
	<footer><%@ include file="footer.jsp"%></footer>
	
		
</body>
	 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	<script src="<c:url value='/assets/js/AngularjsController.js'/>"></script>
</html>
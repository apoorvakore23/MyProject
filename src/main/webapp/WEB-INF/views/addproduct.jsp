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
			<li class="active">Add Product</li>
		</ol>

		<div class="row">
		<header class="page-header">
					<h1 class="page-title">Add Product</h1>
				</header>
		<form:form role="form" enctype="form-data" action="add"
			modelAttribute="product">
			<div class="form-group">
				<form:label path="name" >
					<spring:message text="Product Name" />
				</form:label>
				<form:input class="form-control" path="name" />
				<form:errors path="name" cssClass="errStyle" >					
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="quantity">
					<spring:message text="Quantity Available" />
				</form:label>
				<form:input class="form-control" path="quantity" />
				<form:errors path="quantity" cssClass="errStyle">
					
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="price">
					<spring:message text="Product Price" />
				</form:label>
				<form:input class="form-control" path="price" />
				<form:errors path="price" cssClass="errStyle">
					
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="category">
					<spring:message text="Category" />
				</form:label>
				<form:select class="form-control" path="category">
					<form:option value="Living">Living</form:option>
					<form:option value="Dinning">Dinning</form:option>
					<form:option value="Bedroom">Bedroom</form:option>
				</form:select>

			</div>
			
			<div class="form-group">
				<form:label path="description">
					<spring:message text="Description" />
				</form:label>
				<form:input class="form-control" path="description" />
				<form:errors path="description" cssClass="errStyle">
					
				</form:errors>
			</div>

			
			<div class="form-group">
				<input class="btn btn-info" type="submit"
					value="<spring:message text="Add Product"/>" />

			</div>
		</form:form>


	
	</div></div>
	<footer><%@ include file="footer.jsp"%></footer>
	
		
</body>
	 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	<script src="<c:url value='/assets/js/AngularjsController.js'/>"></script>
</html>
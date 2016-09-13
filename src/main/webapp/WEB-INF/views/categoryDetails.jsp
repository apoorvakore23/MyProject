<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script src="assets/js/angular.js" type="text/javascript" ></script>
<script>

	var decorApp=angular.module('homeDecor',[]);
	decorApp.controller('displaySupplier',function($scope,$http,$location){		
		$scope.supplier = ${supplier} ;		
		$scope.name="HomeDecor";
		$scope.search=location.search.substring(8);
	
	}
			
	);
	
</script>
</head>
<body>


<div>
		<%@ include file="header.jsp"%>
	</div>
	<header id="head" class="secondary"></header>
	<div class="container" >
		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">View Supplier</li>
		</ol>

		<div class="row">
			<header class="page-header">
				<h1 class="page-title">View Supplier</h1>
			</header>
	<div class="list-group" >
		<div class="container" >
		<form:form  modelAttribute="category" enctype="form-data" role="form" action="deleteCategorytrue/${category.id }" method="post">
			<table class="table table-striped" >
				<tr>
					<th>Name</th>
					<td>${category.name}</td>
				</tr>
								<tr>
					<th>Description</th>
					<td>${category.description}</td>
				</tr>
				
			</table>
				</form:form>
						</div>

		<a class="list-group-item" href="cart">
			<button class="btn btn-primary btn-lg btn-block">add to cart</button>
		</a>
	</div>
	<br>
	<br>
	<%@ include file="footer.jsp"%></div></div>
</body>
</html>
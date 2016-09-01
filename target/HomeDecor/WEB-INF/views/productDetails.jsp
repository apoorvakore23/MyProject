<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	decorApp.controller('displayProduct',function($scope,$http,$location){		
		$scope.product = ${product} ;		
		$scope.name="HomeDecor";
		$scope.search=location.search.substring(8);
		alert('hello');
	}
			
	);
	
</script>
</head>
<body>


<div>
		<%@ include file="header.jsp"%>
	</div>
	<header id="head" class="secondary"></header>
	<div class="container" ng-app="homeDecor" ng-controller="displayProduct">
		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">View Product</li>
		</ol>

		<div class="row">
			<header class="page-header">
				<h1 class="page-title">View Product</h1>
			</header>
	<div class="list-group" >

		<div class="container" >


			<table class="table table-striped" ng-repeat="product in product/filter:search">
				<tr>
					<th>Name</th>
					<td>{{product.name}}</td>
				</tr>
								<tr>
					<th>Price</th>
					<td>${product.price}</td>
				</tr>
				<tr>
					<th>Details</th>
					<td>${product.description}</td>
				</tr>
				<tr>
					<th>Category</th>
					<td>${product.category}</td>
				</tr>
				<tr>
			</table>
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
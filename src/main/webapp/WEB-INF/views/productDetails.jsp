<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	
<script>

	var decorApp=angular.module('homeDecor',[]);
	decorApp.controller('displayProduct',function($scope,$http,$location){		
		$scope.product = ${product} ;		
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
		<div class="row">
			
		<div class="list-group" >
		<div class="container" >
		<header class="page-header">			
			<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">View Product</li>
		</ol>
		</header>	
		<h1 class="page-title">View Product</h1>
		<hr><br>
		<div class="col-sm-4"  ng-app = "cartApp">		
		<img src="<c:url value='/assets/Multipath/${product.file}'/>"  alt="noImage" class="img-thumbnail" >
		</div>
		<div class="col-sm-8" >  
				<table class=" table-hover" >
			
				<tr>
					<th>Name</th>
					<td>${product.name}</td>
				</tr>
				<br>
					<br>			<tr>
					<th>Price</th>
					<td>${product.price}</td>
				</tr>
				<tr>
					<th>Details</th>
					<td>${product.description}</td>
				</tr>
				<tr>
					<th>Category</th>
					<td>    ${product.category}</td>
				</tr>
				
			</table>
			<%-- <form:form method="POST" action="${pageContext.request.contextPath}/addtocart?productId=${product.id}"
			modelAttribute="cart" ng-controller="cartCtrl">
						<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

			<input type="hidden" value="${product.id}" />

			<span class="h5"> <label>Quantity : </label><form:input path="quantity" class="form-control"
					type="number" style="width:15%" min="1" max="${product.quantity}" />
			</span>
			<br />
			<sec:authorize access="hasRole('ROLE_USER')">
<button type="submit" class="btn  btn-warning glyphicon glyphicon-shopping-cart">AddToCart</button>
			</sec:authorize>
			
		</form:form> --%>
			
			<p ng-controller="cartCtrl">
                        <a href="<c:url value = "/dispProduct?id=4" />" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large" ng-click="/addToCart('${product.id}')"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                        <a href="<spring:url value="/customer/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                    </p>
				
				</div>
						</div>

		
	</div>
	<br>
	<br>
	</div></div>
	

	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
	<script src="<c:url value="${pageContext.request.contextPath}/assets/js/controller.js?v3" /> "></script>
</body>
<footer id="footer" class="top-space"><%@ include file="/WEB-INF/views/footer.jsp" %>
</footer>	
		

</html>
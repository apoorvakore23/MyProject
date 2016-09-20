<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script src="assets/js/angular.js" type="text/javascript" ></script>
<script>
	var decorApp=angular.module('homeDecor',[]);
	decorApp.controller('getProduct',function($scope,$http,$location){		
		$scope.products = ${pList} ;		
		$scope.name="HomeDecor";
		$scope.search=location.search.substring(8);		
	}			
	);
	
</script>
</head>
<body class="home">
	<div>
		<%@ include file="header.jsp"%>
	</div>
	<header id="head" class="secondary"></header>
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">View Product</li>
		</ol>
		<div class="row">
			<header class="page-header">
				<h1 class="page-title">View Product</h1>
			</header>
			<c:set var="pid" value="${param.id}"/>
			<div  ng-app="homeDecor" ng-controller="getProduct">
			<div id="custom-search-input">
                <div class="input-group col-md-12">
                    <input ng-model="search.name" type="text" class="form-control input-lg" placeholder="Search" />
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" type="button">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                </div>
            </div>			
				<div class="panel-body" >
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product</th>
								<th>Quantity Available</th>
								<th>Price</th>
								<th>Description</th>
								<th>Action</th>								
								</tr>
						</thead>	
						<c:if test="${pid=='4' }">		
						<tbody>								
									<tr ng-repeat="product in products|filter:search"> 
									
										<td>{{product.name}}</td>
										<td>{{product.quantity }}</td>
										<td>Rs.{{product.price}}</td>
										<td>{{product.description}}</td>	
										
										<td><a href="${pageContext.request.contextPath}/details/{{product.id}}">View</a> &nbsp;<sec:authorize access="hasRole('ROLE_ADMIN')"> |
											
												<a href="${pageContext.request.contextPath}/edit/{{product.id}}">Edit</a>&nbsp;&nbsp; |
											
												<a href="${pageContext.request.contextPath}/delete/{{product.id}}">Delete</a></sec:authorize>
												
											</td>
										</tr>
										</tbody>
										
										</c:if>
					
					<c:if test="${pid=='1' }">		
						<tbody>								
									<tr ng-repeat="product in products|filter:{category:'Living'}|filter:search"> 
									
										<td>{{product.name}}</td>
										<td>{{product.quantity }}</td>
										<td>Rs.{{product.price}}</td>
										<td>{{product.description}}</td>	
										
										<td><a href="${pageContext.request.contextPath}/details/{{product.id}}">View</a> &nbsp;<sec:authorize access="hasRole('ROLE_ADMIN')"> |
											
												<a href="${pageContext.request.contextPath}/edit/{{product.id}}">Edit</a>&nbsp;&nbsp; |
											
												<a href="${pageContext.request.contextPath}/delete/{{product.id}}">Delete</a></sec:authorize>
												
											</td>
										</tr>
										</tbody>
										
										</c:if>
					
					<c:if test="${pid=='3' }">		
						<tbody>								
									<tr ng-repeat="product in products|filter:{category:'Dinning'}|filter:search"> 
									
										<td>{{product.name}}</td>
										<td>{{product.quantity }}</td>
										<td>Rs.{{product.price}}</td>
										<td>{{product.description}}</td>	
										
										<td><a href="${pageContext.request.contextPath}/details/{{product.id}}">View</a> &nbsp;<sec:authorize access="hasRole('ROLE_ADMIN')"> |
											
												<a href="${pageContext.request.contextPath}/edit/{{product.id}}">Edit</a>&nbsp;&nbsp; |
											
												<a href="${pageContext.request.contextPath}/delete/{{product.id}}">Delete</a></sec:authorize>
												
											</td>
										</tr>
										</tbody>
										
										</c:if>
										<c:if test="${pid=='2' }">		
						<tbody>								
									<tr ng-repeat="product in products|filter:{category:'Bedroom'}|filter:search"> 
									
										<td>{{product.name}}</td>
										<td>{{product.quantity }}</td>
										<td>Rs.{{product.price}}</td>
										<td>{{product.description}}</td>	
										
										<td><a href="${pageContext.request.contextPath}/details/{{product.id}}">View</a> &nbsp;<sec:authorize access="hasRole('ROLE_ADMIN')"> |
											
												<a href="${pageContext.request.contextPath}/edit/{{product.id}}">Edit</a>&nbsp;&nbsp; |
											
												<a href="${pageContext.request.contextPath}/delete/{{product.id}}">Delete</a></sec:authorize>
												
											</td>
										</tr>
										</tbody>
										
										</c:if>
					
										
</table></div></div>
			<br> <br>
		</div>
	</div>
	<div class="footer1"><%@ include file="footer.jsp"%></div>
	

</body>
</html>


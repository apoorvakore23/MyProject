<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 --%>
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
	decorApp.controller('getSupplier',function($scope,$http,$location){		
		$scope.supplier = ${sList} ;		
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
			<div class="container" ng-app="homeDecor" ng-controller="getSupplier">

				<%-- <c:set var="supplier_id" value="${sList}"></c:set> --%>
				<div class="panel-body" >


					<table class="table table-hover">

						<thead>
							<tr>
								<th>Supplier Name</th>								
								<th>Address</th>
								<th>EmailID</th>
								<th>Contact No.</th>
								<th>Action</th>
								
								</tr>
						</thead>	
						<c:forEach items="${sList}" var="supplier">							
								<tbody>								
									<tr><!-- ng-repeat="product in product/filter:search" -->
									
										<td>${supplier.name}</td>
										<td>${supplier.address }</td>
										<td>${supplier.emailID }</td>
										<td>${supplier.contactNo }</td>
										
										<td><a href="detailsSupplier/${supplier.id}">View</a> &nbsp; |
											
												<a href="editSupplier/${supplier.id}">Edit</a>&nbsp;&nbsp; |
											
												<a href="deleteSupplier/${supplier.id}">Delete</a>
												
											</td>
										</tr>
								</tbody>
						</c:forEach>
						</table>
				</div>
			</div>
							<%-- <p:if test="${product_id=='1'}">
								<tbody>
									<tr ng-repeat="product in Data|filter:search">
										<td>{{product.id}}</td>
										<td>{{product.name}}</td>
										<td>{{product.price}}</td>
										<td>{{product.description}}</td>
										<td>{{product.product_category}}</td>
										<td><a href="details?id={{product.product_id}}">View</a>|
											<sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="edit?id={{product.product_id}}">Edit</a>
											</sec:authorize>| <sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="delete?id={{product.product_id}}">Delete</a>
											</sec:authorize>
									</tr>
								</tbody>
							</p:if>

							<p:if test="${product_id=='2'}">
								<tbody>
									<tr ng-repeat="product in Data|filter:search">
										<td>{{product.id}}</td>
										<td>{{product.name}}</td>
										<td>{{product.price}}</td>
										<td>{{product.description}}</td>
										<td>{{product.product_category}}</td>
										<td><a href="details?id={{product.product_id}}">View</a>|
											<sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="edit?id={{product.product_id}}">Edit</a>
											</sec:authorize>| <sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="delete?id={{product.product_id}}">Delete</a>
											</sec:authorize></td>

									</tr>
								</tbody>
							</p:if>



							<p:if test="${product_id=='3'}">
								<tbody>
									<tr ng-repeat="product in Data|filter:search">
										<td>{{product.id}}</td>
										<td>{{product.name}}</td>

										<td>{{product.price}}</td>
										<td>{{product.description}}</td>
										<td>{{product.product_category}}</td>
										<td><a href="details?id={{product.product_id}}">View</a>|
											<sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="edit?id={{product.product_id}}">Edit</a>
											</sec:authorize>| <sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="delete?id={{product.product_id}}">Delete</a>
											</sec:authorize>
									</tr>
								</tbody>
							</p:if>

							 --%>
							
							<%-- <p:forEach var="product" items="${product}"  varStatus="status">
							<tbody>
							<tr>
										<td>${product.id}</td>
										<td>${product.name}</td>
										<td>${product.price}</td>
										<td>${product.description}</td>
										</tr>
										</tbody>
										</p:forEach> --%>
					

			<%-- <p:if test="${not empty lists}">

		<ul>
			<p:forEach var="listValue" items="${lists}">
				<table>
					<tr>
						<td>${listValue.toString()}</td>
						<br>

					</tr>
				</table>
			</p:forEach>
		</ul>

	</p:if> --%>

			<br> <br>
		</div>
	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>


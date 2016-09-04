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
	decorApp.controller('getCategory',function($scope,$http,$location){		
		$scope.category = ${cList} ;		
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
			<li class="active">View Category</li>
		</ol>

		<div class="row">
			<header class="page-header">
				<h1 class="page-title">View Category</h1>
			</header>
			<div class="container" ng-app="homeDecor" ng-controller="getSupplier">

				<%-- <c:set var="caterory_id" value="${cList}"></c:set> --%>
				<div class="panel-body" >


					<table class="table table-hover">

						<thead>
							<tr>
								<th>Category Name</th>								
								<th>Description</th>
								
								<th>Action</th>
								
								</tr>
						</thead>	
						<c:forEach items="${cList}" var="category">							
								<tbody>								
									<tr><!-- ng-repeat="Category in Category/filter:search" -->
									
										<td>${category.name}</td>
										<td>${category.description }</td>
																				
										<td><a href="detailsCategory/${category.id}">View</a> &nbsp; |
											
												<a href="editCategory/${category.id}">Edit</a>&nbsp;&nbsp; |
											
												<a href="deleteCategory/${category.id}">Delete</a>
												
											</td>
										</tr>
								</tbody>
						</c:forEach>
						</table>
				</div>
			</div>
							<%-- <p:if test="${Category_id=='1'}">
								<tbody>
									<tr ng-repeat="Category in Data|filter:search">
										<td>{{Category.id}}</td>
										<td>{{Category.name}}</td>
										<td>{{Category.price}}</td>
										<td>{{Category.description}}</td>
										<td>{{Category.Category_category}}</td>
										<td><a href="details?id={{Category.Category_id}}">View</a>|
											<sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="edit?id={{Category.Category_id}}">Edit</a>
											</sec:authorize>| <sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="delete?id={{Category.Category_id}}">Delete</a>
											</sec:authorize>
									</tr>
								</tbody>
							</p:if>

							<p:if test="${Category_id=='2'}">
								<tbody>
									<tr ng-repeat="Category in Data|filter:search">
										<td>{{Category.id}}</td>
										<td>{{Category.name}}</td>
										<td>{{Category.price}}</td>
										<td>{{Category.description}}</td>
										<td>{{Category.Category_category}}</td>
										<td><a href="details?id={{Category.Category_id}}">View</a>|
											<sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="edit?id={{Category.Category_id}}">Edit</a>
											</sec:authorize>| <sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="delete?id={{Category.Category_id}}">Delete</a>
											</sec:authorize></td>

									</tr>
								</tbody>
							</p:if>



							<p:if test="${Category_id=='3'}">
								<tbody>
									<tr ng-repeat="Category in Data|filter:search">
										<td>{{Category.id}}</td>
										<td>{{Category.name}}</td>

										<td>{{Category.price}}</td>
										<td>{{Category.description}}</td>
										<td>{{Category.Category_category}}</td>
										<td><a href="details?id={{Category.Category_id}}">View</a>|
											<sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="edit?id={{Category.Category_id}}">Edit</a>
											</sec:authorize>| <sec:authorize access="hasRole('ROLE_ADMIN')">
												<a href="delete?id={{Category.Category_id}}">Delete</a>
											</sec:authorize>
									</tr>
								</tbody>
							</p:if>

							 --%>
							
							<%-- <p:forEach var="Category" items="${Category}"  varStatus="status">
							<tbody>
							<tr>
										<td>${Category.id}</td>
										<td>${Category.name}</td>
										<td>${Category.price}</td>
										<td>${Category.description}</td>
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


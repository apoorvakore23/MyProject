<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
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
<script src="<c:url value='/assets/js/controller.js' /> "></script>	
	

</head>
<body>


<div>alert('${param.id}');
		<%@ include file="header.jsp"%>
	</div>
	<header id="head" class="secondary"></header>
	<div class="container"  >
		<div class="row">
			
		<div class="list-group" >
		<div class="container"  ng-app="myApp" ng-controller="myCtrl" ng-init="loadDataById('${param.id}')">
		<header class="page-header">			
			<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">View Product</li>
		</ol>
		</header>	
		<h1 class="page-title">View Product</h1>
		<hr><br>
		<div class="col-sm-4" >		
		<img src="<c:url value='/assets/Multipath/{{Data.file}}'/>"  alt="noImage" class="img-thumbnail" >
		</div>
		<div class="col-sm-8" >  
				<table class=" table-hover" >
			
				<tr>
					<th>Name</th>
					<td>{{Data.name}}</td>
				</tr>
							<tr>
					<th>Price</th>
					<td>{{Data.price}}</td>
				</tr>
				<tr>
					<th>Details</th>
					<td>{{Data.description}}</td>
				</tr>
				<tr>
					<th>Category</th>
					<td>    {{Data.category}}</td>
				</tr>
				
			</table>
			
			<table class="table">
		<tr>
		<td>
				<a href="<c:url value="dispProduct?id=4" />" class="btn btn-primary">Back</a>
			</td>
			<td>	
			<sec:authorize access="isAuthenticated()">
			<sec:authorize access="hasRole('ROLE_USER')">
		<a href="#" class="btn btn-primary" ng-click="addToCart('${param.id}')">
		<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
							</a>
							</sec:authorize>
		  </sec:authorize>
		  <sec:authorize access="isAnonymous()">
		  <a href="${pageContext.request.contextPath}/login" class="btn btn-primary">
		<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
							</a>
		  </sec:authorize>
							</td>
							<td>
							<sec:authorize access="isAuthenticated()">
							<sec:authorize access="hasRole('ROLE_USER')">
										<a href="<c:url value='/memberShip'/>"  class="btn btn-warning"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
										</sec:authorize>
										</sec:authorize>
										<sec:authorize access="isAnonymous()">
											<a href="${pageContext.request.contextPath}/login"  class="btn btn-warning"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
										</sec:authorize>
							</td>
			</tr>						
</table>
		
	</div>
	<br>
	<br>
	</div></div>
	</div></div>

	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
		
</body>
<footer id="footer" class="top-space"><%@ include file="/WEB-INF/views/footer.jsp" %>
</footer>	
		

</html>


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
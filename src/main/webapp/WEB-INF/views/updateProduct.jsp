<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link rel="stylesheet" href="assets/css/bootstrap-theme.css"
	media="screen">

</head>
<body class="home">
	<div>
		<%@ include file="header.jsp"%>
	</div>
	<header id="head" class="secondary"></header>
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">Edit Product</li>
		</ol>

		<div class="row">
			<header class="page-header">
				<h1 class="page-title">Edit Product</h1>
			</header>

	<form:form modelAttribute="product" role="form" action="updateProduct" method="post">
		<form:input style="visibility:hidden;" path="id" />
		<table>
			<tr>
			<td><form:label path="name">
						<spring:message text="Product name" />
					</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
						<tr>
				<td><form:label path="price">
						<spring:message text="Product price" />
					</form:label></td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:label path="description">
						<spring:message text="product description " />
					</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select class="form-control" path="category">
					<form:option value="Living">Living</form:option>
					<form:option value="Dinning">Dinning</form:option>
					<form:option value="Bedroom">Bedroom</form:option>
				</form:select>
				<td><form:errors path="category" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" class="btn btn-info" value="Update" /></td>
			</tr>
		</table>
	</form:form></div></div>
<br>
	<br>

<%@ include file="footer.jsp" %>	

</body>
</html>




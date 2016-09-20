<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"   %>  
 <%@ page isELIgnored="false" %> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/WEB-INF/views/header.jsp" %>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="assets/js/angular.js" type="text/javascript" ></script>
</head> 
<body>
<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">Cart View</li>
		</ol>

		<div class="row">	
<div class="container-fluid">
<div class ="row">

<h3>Shopping Cart</h3>
<!-- <div class="table"/> -->

<div class= well>
	<div class="table table-responsive">
	<table class="table table-bordered" >
	<thead>


<tr>
<th>
Product Preview
</th>
  <th>
 Product Name
 </th>
  <th>
 Price
 </th>
 <th>
 Quantity
</th>
 <th>Action</th>

 </tr>
</thead>
<tbody>
<c:forEach items="${cartList}" var="cart">
<tr>
<%-- <td>${cart.cartId}</td> --%>
<td>
<img src="<c:url value='${pageContext.request.contextPath}/assets/Multipath/${cart.productName}.jpg'/>"  class="img-thumbnail" >

</td>
<td>${cart.productName}</td>
<td>${cart.price}</td>
<td>${cart.quantity}

<td><a href="<spring:url value='/cart/delete/${cart.cartId}'/>" class="btn btn-default" onclick="alert('Are you sure you want to delete this Product')">Delete</a></td>
</tr>
</c:forEach>
</tbody>
	</table>
		</div>
</div>
<!-- </table> -->
<p>
		<a href="${pageContext.request.contextPath}/dispProduct?id=4" class="btn btn-warning">Continue Shopping</a> 
		<form:form action="collectbillinginfo?cartId=35" >
	 
	 
<!-- 		<input type="hidden" id="cart" name="cart" value=${cart} /> -->
	
			<input type="submit " class="btn btn-warning" value="Check Out" />
		</form:form>
		
	</p>
	</div>
</div>
</div></div>
<footer id="footer" class="top-space"><%@ include file="/WEB-INF/views/footer.jsp" %>
</footer>	
</body>

 
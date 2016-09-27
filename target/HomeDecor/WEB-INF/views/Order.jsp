<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirmation</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script src="<c:url value='/resources/JS/AngularController.js'/>"></script>
</head>
<body>
<div>
	<%@ include file="header.jsp" %>
</div>
<div class="container"ng-app="myApp" ng-controller = "ProductController" ng-init="clearCartItems()">

<h3>Your Order has been Sucessfully Placed.. You will recieve Item in 7 days</h3>

 <a href="<c:url value='disp?id=4'/>" class="btn btn-primary center">CONTINUE SHOPPING</a>
</div>
<div>
<%@ include file="footer.jsp" %>
</div>

</body>
</html>
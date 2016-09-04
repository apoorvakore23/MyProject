<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Home Decor-it's not place it's feeling.</title>
<link rel="stylesheet" href="/assets/css/bootstrap-theme.css" media="screen" >
 
	<link rel="stylesheet" href="/assets/css/main.css">
	<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<%-- <script src="<c:url value='/assets/js/angularJsController.js'/>"/></script></head> --%>
	
	
	<body class="home">
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse  navbar-fixed-top " >
		<div class="container">
			<!-- <div class="navbar-header">				
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="index"><img src="assets/images/logo.png"  alt="Progressus HTML5 template"></a>
			</div> -->
			<!-- <div ng-app="myApp" ng-controller="myCtrl"> -->
			<div class="navbar-collapse collapse">
							<ul class="nav navbar-nav pull-right">
							<!-- <li><a  href="index"><img src="assets/images/logo.png"  alt="Progressus HTML5 template"></a></li> -->
					<li class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/about">About</a></li>
					<li><a href="${pageContext.request.contextPath}/newarrivals">New Arrivals</a></li>
					
					<li class="dropdown">
					<a  href="${pageContext.request.contextPath}/#" class="dropdown-toggle" data-toggle="dropdown" >Products<span class="caret"></span></a>
					<ul class="dropdown-menu">
			        <li><a href="${pageContext.request.contextPath}/living">Living</a></li>
					<li><a href="${pageContext.request.contextPath}/dinning">Dinning</a></li>
					<li><a href="${pageContext.request.contextPath}/bedroom">Bedroom</a></li>			          
			        </ul>		
					</li>
					
					<li class="dropdown">
					<a  href="${pageContext.request.contextPath}/add" class="dropdown-toggle" data-toggle="dropdown">Product Details<span class="caret"></span></a>
					<ul class="dropdown-menu">
			          <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="${pageContext.request.contextPath}/add">Add Product</a></li>  </sec:authorize>
			          <li><a href="${pageContext.request.contextPath}/dispProduct">View Product</a></li>			          
			        </ul>		
					</li>
			 <sec:authorize access="hasRole('ROLE_ADMIN')">	<li class="dropdown">
					<a  href="${pageContext.request.contextPath}/add" class="dropdown-toggle" data-toggle="dropdown" href="#">Suppliers Details<span class="caret"></span></a>
					<ul class="dropdown-menu">
			          <li><a href="${pageContext.request.contextPath}/addSuppliers">Add Supplier</a></li>
			          <li><a href="${pageContext.request.contextPath}/dispSuppliers">View Suppliers</a></li>			          
			        </ul>		
					</li></sec:authorize>
				 <sec:authorize access="hasRole('ROLE_ADMIN')">	<li class="dropdown">
					<a  href="${pageContext.request.contextPath}/add" class="dropdown-toggle" data-toggle="dropdown" href="#">Categories Details<span class="caret"></span></a>
					<ul class="dropdown-menu">
			          <li><a href="${pageContext.request.contextPath}/addCategorys">Add Supplier</a></li>
			          <li><a href="${pageContext.request.contextPath}/dispCategorys">View Suppliers</a></li>			          
			        </ul>		
					</li>	</sec:authorize>
					<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>											
				<%-- 	<li><a class="btn" href="${pageContext.request.contextPath}/login">SIGN IN / SIGN UP</a></li> --%>
					<sec:authorize access="isAnonymous()">		 
				<li><a  class="btn" href="${pageContext.request.contextPath}/register"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a class="btn" href="${pageContext.request.contextPath}/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</sec:authorize>
				<li><sec:authorize access="isAuthenticated()">
						<li><a  class="btn"href='<c:url value="/logout" />'>
								<span class="glyphicon glyphicon-log-out"></span> Logout
						</a></li>
					</sec:authorize>
				</ul>
			</div><!--/.nav-collapse -->
			</div></div>
		</div>
	<!-- /.navbar -->
<div>
</div>
</body>

</html>
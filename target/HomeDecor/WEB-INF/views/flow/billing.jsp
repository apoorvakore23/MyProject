<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="assets/js/angular.js" type="text/javascript" ></script>
</head>
<body>
<div ><%@ include file="/WEB-INF/views/header.jsp" %>
	</div> 
	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">Billing  View</li>
		</ol>

		
<div class="container-fluid">
	
	<div class="row">
		<div class="col-sm-6">
			<div class="well">
				<form:form role="form" method="post" commandName="cart">
					<div class="form-group">
						<label>Billing Address</label>
						<form:textarea class="form-control" path="address" required="true" />
					</div>
					
					<div class="form-group">
						<label>Phone No</label>
						<form:input class="form-control" path="phoneNo" />
						
					 
					</div>
					 
					<div class="form-group">
						<input type="submit" name="_eventId_submit" class="btn btn-info" value="Proceed" />
							 
						<button type="reset" class="btn btn-info" value="reset">Reset</button>
					</div>
					</form:form>
			</div>
		</div>
		<div class="verticalLine">
		<div class="col-sm-6"></div></div>
	</div></div></div>

<footer id="footer" class="top-space"><%@ include file="/WEB-INF/views/footer.jsp" %>
</footer></body>
</html>

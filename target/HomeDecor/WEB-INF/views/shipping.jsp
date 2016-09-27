<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping Address</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value='/resources/JS/AngularController.js'/>"></script>
</head>
<body>
<div>
<%@ include file="header.jsp"%>
</div>
	<div class="container">
		
<h3>Shipping Details</h3>
		<form:form modelAttribute="ship" role="form">
    <div class="form-group">
				<label for="houseNumber">HOUSE NUMBER: </label>
				<form:input path="houseNumber"  class="form-control" />
				<form:errors path="houseNumber" cssStyle="color: #ff0000"/>
			</div>
			<div class="form-group">
				<label for="add1">ADDRESS LINE 1</label>

				<form:input path="addressLine1" class="form-control" />
				<form:errors path="addressLine1" cssStyle="color: #ff0000"/>
			</div>
			<div class="form-group">
				<label>ADDRESS LINE 2</label>

				<form:input path="addressLine2" class="form-control" />

			</div>


			<div class="form-group">
				<label >CITY</label>

				<form:input path="city"  class="form-control" />
				<form:errors path="city" cssStyle="color: #ff0000"/>
			</div>

			<div class="form-group">
				<label >STATE</label>

				<form:input path="state"  class="form-control" />
				<form:errors path="state" cssStyle="color: #ff0000"/>
			</div>

			<div class="form-group">
				<label >COUNTRY</label>

				<form:input path="country"  class="form-control" />
				<form:errors path="country" cssStyle="color: #ff0000"/>

			</div>
			<div class="form-group">
				<label >ZIPCODE</label>

				<form:input path="zipCode"  class="form-control" />
				<form:errors path="zipCode" cssStyle="color: #ff0000"/>
			</div>

			<div>
									<input type="hidden" name="_flowExecutionKey" /> <input
						type="submit" value="Proceed to Payment" class="btn btn-primary"
						name="_eventId_payment" />
				
			</div>
		</form:form>
	</div>
	<div>
	<%@ include file="footer.jsp"%>
	</div>

</body>
</html>
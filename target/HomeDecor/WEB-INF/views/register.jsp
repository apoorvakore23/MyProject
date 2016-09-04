
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">
	<script src="assets/js/regform.js"></script>  
	

</head>

<body>
	<!-- Fixed navbar -->
	<div><%@ include file="header.jsp" %>
	</div> 
	<!-- /.navbar -->

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">Registration</li>
		</ol>

		<div class="top-margin">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Registration</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Register a new account</h3>
							<p class="text-center text-muted ">Already Registered with Us?  <a href="signin.html" class="glyphicon glyphicon-log-in">  Login</a>  </p>
							<hr>
							<form:form method="post" commandName="adduser"	enctype="/form-data" action="register">
			<table class="table table-hover">
				<tr>
					<td><form:label path="fname" >
							<spring:message text="First Name"  />
						</form:label></td>
					<td><form:input path="fname" class="form-control" /></td>
					<td><form:errors path="fname" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="lname">
							<spring:message text="Last Name" />
						</form:label></td>
					<td><form:input path="lname" class="form-control" /></td>
					<td><form:errors path="lname" cssClass="error" /></td>
				</tr>

				
				<tr>
					<td><form:label path="address">
							<spring:message text="Address" />
						</form:label></td>
				
					<td><form:textarea path="address" rows="3"  cols="20" class="form-control"/></td>
					<td><form:errors path="address" cssClass="error" /></td>
				</tr>
				
				
				<tr>
					<td><form:label path="contact">
							<spring:message text="Contact No" />
						</form:label></td>
					<td><form:input path="contact" class="form-control"/></td>
					<td><form:errors path="contact" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="userName">
							<spring:message text="User Name " />*
						</form:label></td>
					<td><form:input path="userName" class="form-control" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="email">
							<spring:message text="Email" />
						</form:label></td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="password">
							<spring:message text="Password " />*
						</form:label></td>
					<td><form:input type="password" path="password" class="form-control"/></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-info" value="Register" /></td>
				</tr>
			</table>
		</form:form>
							
							
							
							
							
<!-- 
							<form name="registration" onSubmit="return formValidation();"  >
								<div class="top-margin">
									<label>First Name</label>
									<input name="Fname"type="text" class="form-control" />
								</div>
								<div class="top-margin">
									<label>Last Name</label>
									<input name="Lname"type="text" class="form-control" >
								</div>
								<div class="top-margin">
									<label>Address</label>
									<textarea name="address"  class="form-control" ></textarea>
								</div>
								<div class="top-margin">
									<label>Email Address <span class="text-danger">*</span></label>
									<input type="text" name="email" class="form-control"  required/>
								</div>

								<div class="top-margin top-margin">
									<div class="col-sm-6">
										<label>Password <span class="text-danger">*</span></label>
										<input type="text" name="password" class="form-control" required/>
									</div>
									<div class="col-sm-6">
										<label>Confirm Password <span class="text-danger">*</span></label>
										<input type="text" name="password" class="form-control" required/>
									</div>
								</div>

								<hr>

								<div class="top-margin">
									<div class="col-lg-8">
										<label class="checkbox">
											<input type="checkbox"> 
											I've read the <a href="page_terms.html">Terms and Conditions</a>
										</label>                        
									</div>
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">Register</button>
									</div>
								</div>
							</form> -->
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->
	

	<footer id="footer" class="top-space">

		<%@ include file="footer.jsp" %>
	</footer>	

	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
</body>
</html>
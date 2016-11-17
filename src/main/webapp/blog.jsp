<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog</title>
<script src="/resources/js/lib/angular.js"></script>
<script src="/resources/js/lib/angular.min.js"></script>
<script src="/resources/js/app.js"></script>
<script src="/resources/js/blogcontroller.js"></script>
<script src="/resources/js/blogservice.js"></script>
</head>
<body ng-app="myApp" class="ng-click">
	<div class="generic-container" ng-controller="BlogController" as ctrl>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Blog Registration Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.blog.b_id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="b_content">Message</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.blog.b_content" id="blogMsg"
									class="b-content form-control input-sm" />

							</div>
						</div>
					</div>			
			

			<div class="row">
				<div class="form-actions floatRight">

					<input type="submit" value="{{!ctrl.blog.b_id ? 'Add' : 'Update'}}"
						class="btn btn-primary btn-sm">
					<button type="button" ng-click="ctrl.reset()"
						class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
						Form</button>
				</div>
			</div>
			</form>
		</div>
	</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/resources/js/app.js'/>"></script>
	<script src="<c:url value='/resources/js/blogservices.js' />"></script>
	<script src="<c:url value='/resources/js/blogcontroller.js' />"></script>
	<script src="<c:url value='/resources/js/lib/angular.min.js' />"></script>
	<script
		src="<c:url value='resources/js/lib/angular-resource.min.js' />"></script>
</body>

</body>
</html>
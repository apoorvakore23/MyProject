<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
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
<div class="container"   ng-app="myApp" ng-controller = "ProductController" ng-init="retrieveCart()" >

<h3>Payment Details </h3>
<div>
 <form:form role="form" method="post"  modelAttribute="pay">
  <div class="form-group">
					  <label>CARD TYPE:</label>
						
						<form:errors path="cardType" cssStyle="color: #ff0000"/>
						<form:select class="form-control" path="cardType">
			    		<form:option value="" label="----Please Select------" />
						<form:option value="Visa-Debit/Credit" label="Visa-Debit/Credit" />
    					<form:option value="Mastercard" label="Mastercard" />
			    		
						</form:select>
						</div>
						
					  <div class="from-group">
					  <label >CARD NUMBER:</label>
						
						
						<form:input path="cardNumber" id="name" class="form-control"/>
						<form:errors path="cardNumber" cssStyle="color: #ff0000"/>
						</div>
						
						<div class="form-group">
					  <label >EXPIRY DATE:</label>
						<div class="row">
						<div class="col-sm-6">
						
						 <form:select path="expiryMonth" class="form-control" >
				            <form:option value="" label="MM" />					     
							<form:option value="01" label="01" />
    						<form:option value="02" label="02" />
    						<form:option value="03" label="03" />
    						<form:option value="04" label="04" />
    						<form:option value="05" label="05" />
    						<form:option value="06" label="06" />
    						<form:option value="07" label="07" />
    						<form:option value="08" label="08" />
    						<form:option value="09" label="09" />
    						<form:option value="10" label="10" />
    						<form:option value="11" label="11" />
    						<form:option value="12" label="12" />
							</form:select>
						<form:errors path="expiryMonth" cssStyle="color: #ff0000"/>	
							</div>
							<div class="col-sm-6">
							
							<form:select path="expiryYear" class="form-control">
				    		<form:option value="" label="YYYY" />
    						<form:option value="2016" label="2016" />
    						<form:option value="2017" label="2017" />
    						<form:option value="2018" label="2018" />
    						<form:option value="2019" label="2019" />
    						<form:option value="2020" label="2020" />
    						<form:option value="2021" label="2021" />
    						<form:option value="2022" label="2022" />
    						<form:option value="2023" label="2023" />
    						<form:option value="2024" label="2024" />
    						<form:option value="2025" label="2025" />
    						<form:option value="2026" label="2026" />
    						<form:option value="2027" label="2027" />
    						<form:option value="2028" label="2028" />
    						<form:option value="2029" label="2029" />
    						<form:option value="2030" label="2030" />
							</form:select>
							<form:errors path="expiryYear" class="form-control" cssStyle="color: #ff0000"/>
							</div>
							
						</div>
						
						</div>
						
						
						<div class="form-group">
					  <label >CVV  Number:</label>
						
						
						<form:password path="cvNumber" id="cvnumber" class="form-control"/>
						<form:errors path="cvNumber" cssStyle="color: #ff0000"/>
						</div>
						
						<div class="form-group">
					  <label >NAME ON CARD:</label>
						
						
						<form:input path="nameOnCard" id="nameoncard" class="form-control"/>
						<form:errors path="nameOnCard" cssStyle="color: #ff0000"/>
						</div>
						
						<div class="form-group">
					  <label >ATM Pin:</label>
						
						
						<form:password path="atmPin" id="pin" class="form-control"/>
						<form:errors path="atmPin" cssStyle="color: #ff0000"/>
						</div>
						
						<div class="form-group" >
						<label>TOTAL AMOUNT TO BE PAID:</label>
						<form:input disabled="true" path="totalCost"
					  value="{{GrandTotalOfItems()}}" class="form-control" />
					  </div>
					  <div >
					  
						 <input type="hidden" name="_flowExecutionKey" />					
					  <input type="submit"  value="Pay Now" name="_eventId_paynow"  class="btn btn-primary pull-left" />
					
					 	  <input type="submit" value="Cancel" name="_eventId_cancel"  class="btn btn-primary pull-left" />
					    </div>
				
       
        
        </form:form>
       </div>
       </div>
       <div>
        <%@ include file="footer.jsp" %>
</div>

</body>
</html>
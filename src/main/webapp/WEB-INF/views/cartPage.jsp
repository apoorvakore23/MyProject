<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Decor-it's not place it's feeling.</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script src="<c:url value='/assets/js/controller.js' /> "></script>
</head>
<body>

<div>
<%@ include file="header.jsp" %>
</div> 
<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-sm-8 maincontent">
				<header class="page-header">
<div class="container">
<center>
					<h3>ITEMS IN YOUR CART</h3>
</center>

<div  ng-app="myApp">
	 
	 <div  ng-controller = "myCtrl" ng-init="retrieveCart()">
        <table class="table  table-striped fs13" >
		  <thead>
			  <tr>
				
				<th>Preview</th>
				<th class="width110">PRODUCT</th>
				<th >UNIT PRICE</th>
				<th>QUANTITY</th>
				<th>PRICE(in Rs.)</th>
				<th>ACTION</th>
			  </tr>
			</thead>
			<tbody>
				<tr ng-repeat = "items in cart.cartItems">
					 	<td class="span1"><img height="60px" width="60px" class="img-responsive" src="<c:url value="/assets/Multipath/{{items.item.file}}" /> " alt="image"/></td>
						<td>{{items.item.name}}</td>
						<td>{{items.item.price}}</td>
						<td>{{items.quantity}}</td>
						<td>{{items.totalPrice}}</td>
						<td><a href="#"  ng-click="removeItemFromCart(items.item.id)">
							<span class="glyphicon glyphicon-remove"></span>REMOVE</a></td>
					</tr>
			  <tr >
			  <td></td>
			  <td></td>
			  <td></td>
                    
                    <th>GRAND TOTAL(in Rs.)</th>
                    <td>{{GrandTotalOfItems()}}</td>																																																																																																																																																																																																																																																												
                </tr>	  
			</tbody>
		  </table>
		  
		  

          <div class="row">
		  <div class="col-sm-4">
             <a href="<c:url value='/dispProduct?id=4'/>" class="btn btn-primary center">CONTINUE SHOPPING</a>
			</div>	
			<div class="col-sm-4">
			<form:form>
			<input type="hidden" name="_flowExecutionKey"/>
             <input type="submit" name="_eventId_checkout" 
                   class="btn btn-success center" value=" CHECK OUT " />
              </form:form>
			</div>	  
			<div class="col-sm-4">
           <a class="btn btn-danger center" ng-click="clearCartItems()"><span
                        class="glyphicon glyphicon-remove-sign"></span>CLEAR CART</a>
			</div>		  
			
        </div>
		</div>
      </div>   
      </div>
 </header></article></div></div>
<div>
<%@ include file="footer.jsp" %>
</div>

</body>
</html>
var cartApp = angular.module("myApp", []);

cartApp.controller("myCtrl", function($scope, $http) {
	alert("inside");
	$scope.loadData = function (){
		$http.get("data").then(function(response) {
        $scope.Data = response.data;
    });
};
	
	$scope.loadDataById = function(id) {
		$http.get("dataById/" + id).then(function(response) {
			$scope.Data = response.data;
		});
	};
	
	$scope.addToCart = function(itemId) {
		
		$http.put("addToCart/"+itemId).success(function() {	
			alert("success");
		}).error(function() {
			alert("error");
		});

	};
	$scope.refreshCartItems = function() {
		$http.get("refreshCart").success(function(data) {
			$scope.cart = data;
		});
	};
	
	$scope.removeItemFromCart = function(itemId) {
		$http.put("removeItem/"+itemId).success(function(data) {
			alert("Item Removed");
			$scope.refreshCartItems();
		}).error(function() {
			alert("Error");
		});
	};
	
	$scope.refreshCart = function() {
		$http.get('/rest/cart/' + $scope.cartId).success(function(data) {
			$scope.cart = data;
		});
	};

	$scope.clearCart = function() {
		$http.del('/rest/cart/' + $scope.cartId).success($scope.refreshCart());
	};

	$scope.initCartId = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};

	
	
	
	
	$scope.clearCartItems = function() {
		$http['delete']("clearCartItems").success(function(data) {
			alert("cart Emptied");
			$scope.refreshCartItems();

		});
	};
	
	$scope.GrandTotalOfItems = function () {
	    var grandTotal=0;

	    for (var i=0; i<$scope.cart.cartItems.length; i++) {
	        grandTotal+=$scope.cart.cartItems[i].totalPrice;
	   }

	    return grandTotal;
	};
	
/*	$scope.retrieveCart = function() {

		$scope.refreshCartItems();
	};
*/	

	/*$scope.removeFromCart = function(productId) {
		$http.put('/rest/cart/remove/' + productId).success(function(data) {
			$scope.refreshCart();
		});
	};
*/
	
});
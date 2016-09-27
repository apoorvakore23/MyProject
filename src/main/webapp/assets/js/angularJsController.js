 k0-kvar app = angular.module('myApp', []);
app.controller("myCtrl", function($scope, $http) {
	 alert("inside angular");
	$scope.loadData = function (){
		$http.get("data").then(function(response) {
        $scope.Data = response.data;
    });
};
$scope.loadDataById = function (pid){
	$http.get("dataById/"+pid).then(function(response) {
    $scope.Data = response.data;
});
};
$scope.addToCart = function (itemId) {
	
    $http.put("addToCart/"+itemId).success(function () {
        alert("Item added to the cart!");
    }).error(function(){
    	alert("Error");
    });
   
};
$scope.removeItemFromCart = function (itemId) {
    $http.put("removeItem/"+itemId).success(function (data) {
    	alert("Item Removed");
        $scope.refreshCartItems();
    }).error(function(){
    	alert("Error");
    });
};
$scope.GrandTotalOfItems = function () {
    var grandTotal=0;

    for (var i=0; i<$scope.cart.cartItems.length; i++) {
        grandTotal+=$scope.cart.cartItems[i].totalPrice;
   }

    return grandTotal;
};
$scope.refreshCartItems = function () {
    $http.get("refreshCart").success(function (data) {
       $scope.cart=data;
    });
};
$scope.clearCartItems = function () {
	$http['delete']("clearCartItems").success(function (data) {
		alert("cart Emptied");
		$scope.refreshCartItems();
	
	});
};
$scope.retrieveCart = function () {
    $scope.refreshCartItems();
};

});
var cartApp = angular.module ("myApp", []);

cartApp.controller("myCtrl", function($scope, $http){
	 alert('inside angular');
	/* $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";*/
	
	
	 $scope.loadDataById = function (pid){
			$http.get("dataById/"+pid).then(function(response) {
		    $scope.Data = response.data;
		});
		};
    $scope.refreshCart = function(){
       $http.get('/rest/cart/' + $scope.cartId).success(function (data){
           $scope.cart = data;
       });
    };

    $scope.clearCart = function(){
        $http.del('/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
    
    $scope.addToCart = function(id){
    	alert('addtocart method!'+productId);
		$http.put("addToCart/"+id).success(function () {
    alert("Item added to the cart!"+productId);
}).error(function(){
	alert("Error"+productId);
});
//=======================================================================
 /*alert('Product successfully added to the cart!'+productId);
 $location.path('/rest/cart/addToCart/'+ productId);
$http.put('/rest/cart/addToCart/' + productId).success(function (){
   alert('Product successfully');
});*/

};
    

    $scope.removeFromCart = function(productId){
        $http.put('/rest/cart/remove/' + productId).success(function(data){
           $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});
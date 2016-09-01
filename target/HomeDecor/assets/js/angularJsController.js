var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	alert('hello');
	$http.get("data")    
    .then(function(response) {
        $scope.Data = response.data;        
        alert(response);
        alert('response');
    })    
});



/*app.controller('myctrl', function($http){
    this.supplierList = {};
    $http.get("http://some_url_here")
            .success(function(response) {
                 this.supplierList = response.records;
            }.bind(this))*/
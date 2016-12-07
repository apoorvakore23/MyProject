'use strict';
var app = angular.module('myApp', ['ngRoute']);

alert('inside app.js');

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : 'BCORE/view/home.html',
        
    })
    /*.when("/user/create", {
        templateUrl : "view/user.html",
        	controller : 'UserController'
    })*/
    .when("/user", {
    	templateUrl : "BCORE/view/user.html",
    	controller : 'UserController'
    })
    .when("/blog", {
    	templateUrl : "BCORE/view/blog_view.html",
    	controller : 'BlogController'      	
        	
    })
    .when("/placement", {
    	templateUrl : "BCORE/view/placement.html",
    	controller : 'PlacementController'
    })
    .when("/forum", {
    	templateUrl : "BCORE/view/forum.html",
    	controller : 'ForumController'
    })
    .when("/userLogin", {
    	templateUrl : "BCORE/view/login.html",
    	controller : 'UserController',
    	hideMenus: true
        	
        	
    })
      .when("/new_blog", {
    	templateUrl : "BCORE/view/blog_new.html",
    	controller : 'BlogController'
    		
        	
        	
    });
});



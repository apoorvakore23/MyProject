'use strict';
var app = angular.module('myApp', ['ngRoute']);

console.log('inside app.js');

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : 'BCORE/view/login.html',
        controller : 'UserController'
    	
        
    })
    .when("/home", {
        templateUrl : 'BCORE/view/home.html',
        
    })
    
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
        	
    })
     .when("/searchfriend", {
        templateUrl : 'BCORE/view/search_friend.html',
        controller  : 'FriendController'
    })
     .when("/viewfriendrequest", {
        templateUrl : 'BCORE/view/view_friendrequest.html',
        controller  : 'FriendController'
    })
	 .when("/viewfriend", {
        templateUrl : 'BCORE/view/view_friend.html',
        controller  : 'FriendController'
    })
     .when("/chat", {
        templateUrl : 'BCORE/view/chat.html',
        controller  : 'ChatController'
    })
    .otherwise({redirectTo: '/home'});
});



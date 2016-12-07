'use strict';

angular.module('myApp').factory('UserService',['$http','$q',function($http, $q) {
alert('User service');
							var REST_SERVICE_URI = 'http://localhost:8091/CollaborationBackEnd';
							var factory = {
								fetchAllUserPage : fetchAllUserPage,
								createUser : createUser,
								updateUser : updateUser,
								deleteUser : deleteUser,
								authenticate : authenticate
							};

							return factory;

							function fetchAllUserPage() {
								var deferred = $q.defer();
								$http.get(REST_SERVICE_URI + "/users")
										.then(function(response) {
											deferred.resolve(response.data);
												},
												function(errResponse) {
													console.error('Error while fetching all user page');
													deferred.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function createUser(user) {
								
								var deferred = $q.defer();
								$http.post(REST_SERVICE_URI + "/user/create",user)
								
										.then(function(response) {
													deferred.resolve(response.data);
												},
												function(errResponse) {
													console.error('Error while fetching all user page');
													deferred.reject(errResponse);
												});
								return deferred.promise;
							}
							
							   function updateUser(user,userId) {
								   console.log("user in service:" +user.u_name +"id:"+user.userId);								   
							        var deferred = $q.defer();
							        $http.post(REST_SERVICE_URI + "/user/edit",user)
							            .then(
							            function (response) {
							            	console.log('response');
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while updating User');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
							
							
							 function deleteUser(userId) {
							        var deferred = $q.defer();
							        $http.delete(REST_SERVICE_URI+"/user/delete/"+userId)
							            .then(
							            function (response) {
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while deleting User');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
							 
							 function authenticate(user){
									var deferred = $q.defer();
									console.log(' login service',user);
									$http.post(REST_SERVICE_URI + "/user/login",user)
									.then(function(response){
										console.log('resp'+response);
										
										deferred.resolve(response.data);
									},
									function(errResponse){
										console.error('Error in method login');
										deferred.reject(errResponse);
									});
									
									return deferred.promise;
								}
							 function getByUsername(u_username){
									var deferred = $q.defer();
									console.log(' method called getByUsername ' + u_username);
									$http.post(REST_SERVICE_URI + "/user/login",u_username)
									.then(function(response){
										console.log('resp'+response.data);
										deferred.resolve(response.data);
									},
									function(errResponse){
										console.error('Error in method getUserByUsername');
										deferred.reject(errResponse);
									});
									
									return deferred.promise;
								}
							 
							
								
							 
							 
							 
							 
							 
						} ]);

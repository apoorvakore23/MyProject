'use strict';

angular.module('myApp').factory('UserService',['$http','$q',function($http, $q) {
console.log('User service');
							var REST_SERVICE_URI = 'http://localhost:8091/CollaborationBackEnd';
							var factory = {
								fetchAllUserPage : fetchAllUserPage,
								createUser : createUser,
								updateUser : updateUser,
								deleteUser : deleteUser,
								authenticate : authenticate,
								logout:logout
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
							        $http .delete(REST_SERVICE_URI+"/user/delete/"+userId)
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
							 
							 function logout(){
									var deferred = $q.defer();
									console.log(' logout service');
									$http.get(REST_SERVICE_URI + "/logout")
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
							 
							 function getByUserId(userId){
									var deferred = $q.defer();
									console.log(' method called getByUserId ' + userId);
									$http.post(REST_SERVICE_URI + "/user/getMyUserById",userId)
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

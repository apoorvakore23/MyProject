'use strict';

angular.module('myApp').factory('ForumService',['$http','$q',function($http, $q) {

	var REST_SERVICE_URI = 'http://localhost:8091/CollaborationBackEnd/';
							var factory = {
								fetchAllForumPage : fetchAllForumPage,
								createForum : createForum,
								updateForum : updateForum,
								deleteForum : deleteForum
							};

							return factory;

							function fetchAllForumPage() {
								var deferred = $q.defer();
								$http.get(REST_SERVICE_URI + "/forums")
										.then(function(response) {
											deferred.resolve(response.data);
												},
												function(errResponse) {
													console.error('Error while fetching all forum page');
													deferred.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function createForum(forum) {
								console.log("create in forum service:" + forum.forum_name);
								
								var deferred = $q.defer();
								$http.post(REST_SERVICE_URI + "/forum/create",forum)
								
										.then(function(response) {
													deferred.resolve(response.data);
												},
												function(errResponse) {
													console.error('Error while fetching all forum page');
													deferred.reject(errResponse);
												});
								return deferred.promise;
							}
							
							   function updateForum(forum) {
								   console.log("forum in service:" +forum.forum_name +"id:"+forum.forum_id);
								 //  console.log("update forum :"+ f_id);
							        var deferred = $q.defer();
							        $http.post(REST_SERVICE_URI+"/forum/edit",forum)
							            .then(
							            function (response) {
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while updating Forum');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
							
							
							 function deleteForum(f_id) {
								 console.log("in service delete:"+ forum_id);
							        var deferred = $q.defer();
							        $http.delete(REST_SERVICE_URI+"/forum/delete/"+forum_id)
							            .then(
							            function (response) {
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while deleting Forum');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
						} ]);

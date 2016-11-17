'use strict';

angular.module('myApp').factory('EventService',['$http','$q',function($http, $q) {

							var REST_SERVICE_URI = 'http://localhost:8081/CollaborationBackEnd';
							var factory = {
								fetchAllEventPage : fetchAllEventPage,
								createEvent : createEvent,
								updateEvent : updateEvent,
								deleteEvent : deleteEvent
							};

							return factory;

							function fetchAllEventPage() {
								var deferred = $q.defer();
								$http.get(REST_SERVICE_URI + "/events")
										.then(function(response) {
											deferred.resolve(response.data);
												},
												function(errResponse) {
													console.error('Error while fetching all event page');
													deferred.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function createEvent(event) {
								console.log("create in event service:" + event.e_title);
								
								var deferred = $q.defer();
								$http.post(REST_SERVICE_URI + "/event/create",event)
								
										.then(function(response) {
													deferred.resolve(response.data);
												},
												function(errResponse) {
													console.error('Error while fetching all event page');
													deferred.reject(errResponse);
												});
								return deferred.promise;
							}
							
							   function updateEvent(event) {
								   console.log("event in service:" +event.e_title +"id:"+event.e_id);
								 //  console.log("update event :"+ e_id);
							        var deferred = $q.defer();
							        $http.post(REST_SERVICE_URI+"/event/edit",event)
							            .then(
							            function (response) {
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while updating Event');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
							
							
							 function deleteEvent(e_id) {
								 console.log("in service delete:"+ e_id);
							        var deferred = $q.defer();
							        $http.delete(REST_SERVICE_URI+"/event/delete/"+e_id)
							            .then(
							            function (response) {
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while deleting Event');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
						} ]);

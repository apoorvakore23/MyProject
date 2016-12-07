'use strict';

angular.module('myApp').factory('PlacementService',['$http','$q',function($http, $q) {

							var REST_SERVICE_URI = 'http://localhost:8091/CollaborationBackEnd/';
							var factory = {
								fetchAllPlacementPage : fetchAllPlacementPage,
								createPlacement : createPlacement,
								updatePlacement : updatePlacement,
								deletePlacement : deletePlacement
							};

							return factory;

							function fetchAllPlacementPage() {
								var deferred = $q.defer();
								$http.get(REST_SERVICE_URI + "/placements")
										.then(function(response) {
											deferred.resolve(response.data);
												},
												function(errResponse) {
													console.error('Error while fetching all Placement page');
													deferred.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function createPlacement(Placement) {
								console.log("create in Placement Placementice:" + Placement.p_post);
								
								var deferred = $q.defer();
								$http.post(REST_SERVICE_URI + "/placement/create",Placement)
								
										.then(function(response) {
													deferred.resolve(response.data);
												},
												function(errResponse) {
													console.error('Error while fetching all Placement page');
													deferred.reject(errResponse);
												});
								return deferred.promise;
							}
							
							   function updatePlacement(Placement) {
								   console.log("Placement in service:" +Placement.p_post +"id:"+Placement.p_id);
								 //  console.log("update Placement :"+ PlacementId);
							        var deferred = $q.defer();
							        $http.post(REST_SERVICE_URI+"/placement/edit",Placement)
							            .then(
							            function (response) {
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while updating Placement');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
							
							
							 function deletePlacement(p_id) {
								 console.log("in service delete:"+ p_id);
								 
							        var deferred = $q.defer();
							        $http.delete(REST_SERVICE_URI+"/placement/delete/"+p_id)
							            .then(
							            function (response) {
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while deleting Placement');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
						} ]);

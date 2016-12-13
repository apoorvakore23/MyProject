'use strict';
 
app.factory('FriendService',['$http','$q','$rootScope', function($http,$q,$rootScope){
	
	console.log("FriendService...")
	
	var BASE_URL='http://localhost:8091/CollaborationBackEnd/';
    return {
         
		getMyFriends: function() {
                    return $http.get(BASE_URL+'/myFriends')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                   null
                            );
            },
            getMyFriendRequests: function() {
                return $http.get(BASE_URL+'/getMyFriendRequests')
                        .then(
                        		function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while creating friend');
                                    return $q.reject(errResponse);
                                }
                        );
        },
             
            sendFriendRequest: function(friendID){
                    return $http.get(BASE_URL+'/addFriend/'+friendID)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating friend');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateFriendRequest: function(friend,userID){
            	console.log(friend);
                                return $http.put(BASE_URL+'/accepttFriend/'+userID, friend)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating friend');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteFriend: function(id){
                    return $http.delete(BASE_URL+'/friend/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting friend');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
            
           
         
    };
 
}]);
'use strict';
 
app.controller('FriendController', ['UserService','$scope', 'FriendService','$location',
   '$rootScope',function(UserService,$scope, FriendService,$location,$routeParams,$rootScope) {
	console.log("FriendController...")
          var self = this;
          self.friend={id:'',userID:'',friendID:'',status:''};
          self.friends=[];
          
          self.user ={userId:null,u_name:'',u_address:'',u_username:'',u_password:'',u_gender:'',u_contact:'',u_email:'',u_dob:''};
  			self.users = [];
          
         self.sendFriendRequest=sendFriendRequest;
         self.getMyFriendRequests=getMyFriendRequests;
         self.acceptFriendRequest=acceptFriendRequest;
         
         function sendFriendRequest(friendID)
         {

       	  console.log("->sendFriendRequest :"+friendID)
             FriendService.sendFriendRequest(friendID)
                 .then(
                              function(d) {
                                   self.friend = d;
                                  console.log("Friend request sent");
                              },
                               function(errResponse){
                                   console.error('Error while sending friend request');
                               }
                      );
         
        	 
         }
          
             
          self.getMyFriends = function(){
        	  console.log("Getting my friends")
              FriendService.getMyFriends()
                  .then(
                               function(d) {
                                    self.friends = d;
                                    console.log("Got the friends list")
                                     	/* $location.path('/view_friend');*/
                               },
                                function(errResponse){
                                    console.error('Error while fetching Friends');
                                }
                       );
          };
          function getMyFriendRequests() {
        	  console.log("Getting my friends")
              FriendService.getMyFriendRequests()
                  .then(
                               function(d) {
                                    self.friends = d;
                                    console.log("Got the getMyFriendRequests list")
                                     	/* $location.path('/view_friend');*/
                               },
                                function(errResponse){
                                    console.error('Error while fetching getMyFriendRequests');
                                }
                       );
          };
            function acceptFriendRequest(UserID){
            	console.log('accept');
            	
            	updateFriendRequest(self.friend,UserID);
            	
            	
            	
            }
       
            function updateFriendRequest(friend, id){
        	 console.log('friend'+friend+'id'+id);
              FriendService.updateFriendRequest(friend, id)
                      .then(
                              self.fetchAllFriends, 
                              function(errResponse){
                                   console.error('Error while updating Friend.');
                              } 
                  );
          };
 
         self.deleteFriend = function(id){
              FriendService.deleteFriend(id)
                      .then(
                              self.fetchAllFriends, 
                              function(errResponse){
                                   console.error('Error while deleting Friend.');
                              } 
                  );
          };
          
          self.fetchAllUsers = function() {
				UserService.fetchAllUserPage().then(function(d) {
					self.users = d;
				}, function(errResponse) {
					console.error('Error while fetching Users');
				});
			};
            
 /*
          self.fetchAllUsers();
          self.getMyFriends();
 */
     
 
      }]);
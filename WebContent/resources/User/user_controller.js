'use strict';
 

angular.module('myApp').controller('UserController',['$scope','UserService',function($scope,UserService) {
	alert('calling User controller');
    var self = this;
    self.userdata=[{userId:null,u_name:'',u_address:'',u_username:'',u_password:'',u_gender:'',u_contact:'',u_email:'',u_dob:''}];
    $scope.user={userId:null,u_name:'',u_address:'',u_username:'',u_password:'',u_gender:'',u_contact:'',u_email:'',u_dob:'',enabled:''};
    self.users=[]; 
    self.submit = submit;
    self.updateUser = updateUser;
    self.deleteUser = deleteUser;
    self.reset = reset;
    self.edit = edit;
    self.remove = remove;
    self.login = login;
    fetchAllUserPage();
    
    function fetchAllUserPage(){
        UserService.fetchAllUserPage()
            .then(
            function(d) {           	
                self.userdata = d;
                console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching users');
            }
        );
    }
    function createUser(user){
    	console.log('uname ' + user.u_name + 'address ' + user.u_address);
        UserService.createUser(user)
            .then(
            function(u){
            	$scope.user=u;
            	console.log(u);
            	console.log("call create user controller");
            },
            function(errResponse){
                console.error('Error while creating user');
            }
        );
    }
     
    function submit() {
        console.log('Saving New user', $scope.user);
    
        if($scope.user.userId===null){
            console.log('Saving New user', $scope.user);
            createUser($scope.user);
        }else{
             updateUser($scope.user, $scope.user.userId);
            console.log(' UserData updated with id ', $scope.user.userId);
        }
        reset();
    }
    function updateUser(user,userId){
        UserService.updateUser(user,userId)
            .then(
            fetchAllUserPage,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteUser(userId){
        UserService.deleteUser(userId)
            .then(
            	fetchAllUserPage,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function edit(userId){
        console.log('id to be edited',userId);
        console.log('data self.users.length:',self.userdata.length);
        for(var i = 0; i < self.userdata.length; i++){
        	
        console.log("value of i :" +i);
        	console.log('data self.userdata[i].userId:',self.userdata[i].userId);
        	if(self.userdata[i].userId === userId) {
                $scope.user = angular.copy(self.userdata[i]);
                console.log('copied data',$scope.user);
                break;
            }
        }
      //  updateUser(userId);
    }

    function remove(userId){
        console.log('id to be deleted', userId);
        if($scope.user.userId === userId) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(userId);
    }

    function login(){
    	alert("login in controller");
//    	function login() {
//            vm.dataLoading = true;
            AuthenticationService.Login(); 
//            		{
//                if (response.success) {
//                    AuthenticationService.SetCredentials(vm.username, vm.password);
//                    $location.path('/');
//                } else {
//                    FlashService.Error(response.message);
//                    vm.dataLoading = false;
//                }
//            });
//        };
    }
    
   function reset(){
	   self.user={userId:null,u_name:'',u_address:'',u_username:'',u_password:'',u_gender:'',u_contact:'',u_email:'',u_dob:''};
//        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);

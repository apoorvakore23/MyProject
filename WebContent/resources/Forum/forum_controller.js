'use strict';
 

angular.module('myApp').controller('ForumController', ['$scope', 'ForumService', function($scope, ForumService) {
	console.log('calling controller');
    var self = this;
    self.forumdata=[{f_id:null,f_name:'',f_description:'',f_category:'',f_description:'',f_category:''}];
    $scope.forum={f_id:null,f_name:'',f_description:'',f_category:''};
    self.forums=[]; 
    self.submit = submit;
    self.updateForum = updateForum;
    self.deleteForum = deleteForum;
    self.reset = reset;
    self.edit = edit;
    self.remove = remove;
 
    fetchAllForumPage();
    
    function fetchAllForumPage(){
        ForumService.fetchAllForumPage()
            .then(
            function(d) {
                self.forumdata = d;
                console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching forums');
            }
        );
    }
    function createForum(forum){
    	console.log('uname ' + forum.u_name + 'address ' + forum.u_address);
        ForumService.createForum(forum)
            .then(
            function(u){
            	$scope.forum=u;
            	console.log(u);
            	console.log("call create forum controller");
            },
            function(errResponse){
                console.error('Error while creating forum');
            }
        );
    }
     
    function submit() {
    	console.log("call submit 1");
        console.log('Saving New forum', $scope.forum);
    
        if($scope.forum.f_id===null){
        	console.log("forum null -- creating new")
            console.log('Saving New forum', $scope.forum);
            createForum($scope.forum);
        }else{
             updateForum($scope.forum, $scope.forum.f_id);
         	console.log("forum exist -- updating ")
            console.log(' ForumData updated with id ', $scope.forum.f_id);
        }
    	console.log("call submit 2");
        reset();
    }
    function updateForum(forum,f_id){
    	console.log("In uctrl Update Forum :" + f_id )
        ForumService.updateForum(forum,f_id)
            .then(
            fetchAllForumPage,
            function(errResponse){
                console.error('Error while updating Forum');
            }
        );
    }

    function deleteForum(f_id){
    	console.log("In controller delete Forum :" + f_id)
        ForumService.deleteForum(f_id)
            .then(
            	fetchAllForumPage,
            function(errResponse){
                console.error('Error while deleting Forum');
            }
        );
    }

    function edit(f_id){
    	console.log("in uctrl edit function:" + f_id);
        console.log('id to be edited',f_id);
        console.log('data self.forums.length:',self.forumdata.length);
        for(var i = 0; i < self.forumdata.length; i++){
        	
        console.log("value of i :" +i);
        	console.log('data self.forumdata[i].f_id:',self.forumdata[i].f_id);
        	if(self.forumdata[i].f_id === f_id) {
                $scope.forum = angular.copy(self.forumdata[i]);
                console.log('copied data',$scope.forum);
                break;
            }
        }
      //  updateForum(f_id);
    }

    function remove(f_id){
    	console.log("in uctrl remove function:" + f_id);
        console.log('id to be deleted', f_id);
        if($scope.forum.f_id === f_id) {//clean form if the forum to be deleted is shown there.
            reset();
        }
        deleteForum(f_id);
    }

   function reset(){
	   self.forum={f_id:null,f_name:'',f_description:'',f_category:''};
//        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);

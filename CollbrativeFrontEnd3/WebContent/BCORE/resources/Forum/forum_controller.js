'use strict';
 

angular.module('myApp').controller('ForumController', ['$scope', 'ForumService', function($scope, ForumService) {
	console.log('calling controller');
    var self = this;
    self.forumdata=[{forum_id:null,forum_name:'',forum_description:'',forum_category:''}];
    $scope.forum={forum_id:null,forum_name:'',forum_description:'',forum_category:''};
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
    	console.log('forum create');
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
    
        if($scope.forum.forum_id===null){
        	console.log("forum null -- creating new")
            console.log('Saving New forum', $scope.forum);
            createForum($scope.forum);
        }else{
             updateForum($scope.forum, $scope.forum.forum_id);
         	console.log("forum exist -- updating ")
            console.log(' ForumData updated with id ', $scope.forum.forum_id);
        }
    	console.log("call submit 2");
        reset();
    }
    function updateForum(forum,forum_id){
    	console.log("In uctrl Update Forum :" + forum_id )
        ForumService.updateForum(forum,forum_id)
            .then(
            fetchAllForumPage,
            function(errResponse){
                console.error('Error while updating Forum');
            }
        );
    }

    function deleteForum(forum_id){
    	console.log("In controller delete Forum :" + forum_id)
        ForumService.deleteForum(forum_id)
            .then(
            	fetchAllForumPage,
            function(errResponse){
                console.error('Error while deleting Forum');
            }
        );
    }

    function edit(forum_id){
    	console.log("in fctrl edit function:" + forum_id);
        console.log('id to be edited',forum_id);
        console.log('data self.forums.length:',self.forumdata.length);
        for(var i = 0; i < self.forumdata.length; i++){
        	
        console.log("value of i :" +i);
        	console.log('data self.forumdata[i].f_id:',self.forumdata[i].forum_id);
        	if(self.forumdata[i].forum_id === forum_id) {
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
	   self.forum={forum_id:null,forum_name:'',forum_description:'',forum_category:''};
//        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);

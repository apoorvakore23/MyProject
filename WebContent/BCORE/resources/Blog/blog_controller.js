'use strict';
 

angular.module('myApp').controller('BlogController', ['$scope', 'BlogService', function($scope, BlogService) {
	console.log('inside blog controller');
    var self = this;
    self.blogdata=[{blog_id:null,blog_title:'',blog_content:'',blog_date:'',blog_time:'',userId:''}];
    $scope.blog={blog_id:null,blog_title:'',blog_content:'',blog_date:'',blog_time:'',userId:''};
    self.blogs=[]; 
    self.submit = submit;
    self.updateBlog = updateBlog;
    self.deleteBlog = deleteBlog;
    self.reset = reset;
    self.edit = edit;
    self.remove = remove;
 
    fetchAllBlogPage();
    
    function fetchAllBlogPage(){
        BlogService.fetchAllBlogPage()
            .then(
            function(b) {
                self.blogdata = b;
                console.log(b);
            },
            function(errResponse){
                console.error('Error while fetching blogs');
            }
        );
    }
    function createBlog(blog){
    	console.log('blog title ' + blog.blog_content);
        BlogService.createBlog(blog)
            .then(
            function(b){
            	$scope.blog=b;
            	console.log(b);
            	console.log("call create blog in controller");
            },
            function(errResponse){
                console.error('Error while creating blog');
            }
        );
    }
     
    function submit() {
        console.log('Saving New blog', $scope.blog);
    
        if($scope.blog.blog_id===null){
            console.log('Saving New blog', $scope.blog);
            createBlog($scope.blog);
        }else{
             updateBlog($scope.blog, $scope.blog.blog_id);
         	
            console.log(' BlogData updated with id ', $scope.blog.blog_id);
        }
    	
        reset();
    }
    function updateBlog(blog,blog_id){
    	console.log("In uctrl Update Blog :" + blog_id );
        BlogService.updateBlog(blog,blog_id)
            .then(
            fetchAllBlogPage,
            function(errResponse){
                console.error('Error while updating Blog');
            }
        );
    }

    function deleteBlog(blog_Id){
    	console.log("In controller delete Blog :" + blog_id);
        BlogService.deleteBlog(blog_id)
            .then(
            	fetchAllBlogPage,
            function(errResponse){
                console.error('Error while deleting Blog');
            }
        );
    }

    function edit(blog_id){
    	
        console.log('id to be edited',blog_id);
        console.log('data self.blogs.length:',self.blogdata.length);
        for(var i = 0; i < self.blogdata.length; i++){
        	
        console.log("value of i :" +i);
        	console.log('data self.blogdata[i].blogId:',self.blogdata[i].blog_id);
        	if(self.blogdata[i].blog_id === blog_id) {
                $scope.blog = angular.copy(self.blogdata[i]);
                console.log('copied data',$scope.blog);
                break;
            }
        }
      //  updateBlog(blogId);
    }

    function remove(blog_id){
    	
        console.log('id to be deleted', blog_id);
        if($scope.blog.blog_id === blog_id) {//clean form if the blog to be deleted is shown there.
            reset();
        }
        deleteBlog(b_id);
    }

   function reset(){
	   self.blog={blog_id:null,blog_title:'',blog_content:'',blog_date:'',blog_time:''};
//        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);

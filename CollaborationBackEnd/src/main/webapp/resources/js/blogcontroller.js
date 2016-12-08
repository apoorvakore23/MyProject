'use script';
angular.module('myApp').controller('BlogController',['$Scope','BlogService',function($Scope, BlogService){
var self = this;
self.blog = {b_id:null ,b_content:''}
self.blogs=[];
self.submit= submit;
self.edit=edit;
self.remove=remove;
self.reset=reset;

fetchAllBlogs();
function fetchAllBlogs(){
	BlogService.fetchBlogs()
	.then(
			function(d){
				self.blog=d;
			},
			function(errResponse){
				console.error('Error in fetching blog');
			});
}

function createBlog(blog){
	BlogService.createBlog(blog)
	.then(fetchAllBlogs,function(errResponse){
		console.error('Error in create Blog function');
	})
}

function updateBlog(blog,b_id){
	BlogService.updateBlog(blog,id)
	.then(fetchAllBlogs,function(errResponse){
		console.error('Error in updating Blog function');
	})
}

function deleteBlog(b_id){
	BlogService.deleteBlog(b_id)
	.then(
			fetchAllBlogs,function(errResponse){
				console.error('Error in delete Blog function');
			})
}

function submit(){
	alert("Call submit function")
	if(self.blog.b_id===null){
		console.log('New Blog Saved',self.blog);
		createBlog(self.blog);
	}
	else{
		updateBlog(self.blog, self.blog.b_id);
		console.log('Blog updated :' , self.blog.b_id);
	}
}

function reset(){
	self.blog={b_id:null , b_content:''};
	$scope.myForm.$setPristine();
}
}]);
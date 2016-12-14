/**
 * 
 */

angular.module("myApp").controller("ChatController",function($scope,ChatService)
{
	$scope.messages=[];
	$scope.message="";
	$scope.max=70;
	
	console.log('chatting....');
	$scope.addMessage = function(){
		ChatService.send($scope.message);
		$scope.message="";
	alert($scope.message + " sent");
		
	};
	
	ChatService.receive().then(null,null,function(message){
		console.log("receiving msg...");
		$scope.messages.push(message);
	});
});
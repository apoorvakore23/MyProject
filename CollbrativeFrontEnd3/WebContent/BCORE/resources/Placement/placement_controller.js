'use strict';
 

angular.module('myApp').controller('PlacementController', ['$scope', 'PlacementService', function($scope, PlacementService) {
	console.log('calling controller');
    var self = this;
    self.placementdata=[{p_id:null,p_company:'',p_post:'',p_location:'',p_description:'',p_skill_set:'',p_date:'',p_salary:''}];
    $scope.placement={p_id:null,p_company:'',p_post:'',p_location:'',p_description:'',p_skill_set:'',p_date:'',p_salary:''};
    self.placements=[]; 
    self.submit = submit;
    self.updatePlacement = updatePlacement;
    self.deletePlacement = deletePlacement;
    self.reset = reset;
    self.edit = edit;
    self.remove = remove;
 
    fetchAllPlacementPage();
    
    function fetchAllPlacementPage(){
        PlacementService.fetchAllPlacementPage()
            .then(
            function(d) {
                self.placementdata = d;
                console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching placementdata');
            }
        );
    }
    function createPlacement(placement){
    	console.log('post ' + placement.p_post + 'location ' + placement.p_location);
        PlacementService.createPlacement(placement)
            .then(
            function(u){
            	$scope.placement=u;
            	console.log(u);
            	console.log("call create placement controller");
            },
            function(errResponse){
                console.error('Error while creating placement');
            }
        );
    }
     
    function submit() {
    	console.log("call submit 1");
        console.log('Saving New placement', $scope.placement);
    
        if($scope.placement.p_id===null){
        	console.log("placement null -- creating new")
            console.log('Saving New placement', $scope.placement);
        	createPlacement($scope.placement);
        }else{
        	updatePlacement($scope.placement, $scope.placement.p_d);
         	console.log("placement exist -- updating ")
            console.log(' placementData updated with id ', $scope.placement.p_id);
        }
    	console.log("call submit 2");
        reset();
    }
    function updatePlacement(placement,p_id){
    	console.log("In pctrl Update placement :" + p_id )
        PlacementService.updatePlacement(placement,p_id)
            .then(
            fetchAllPlacementPage,
            function(errResponse){
                console.error('Error while updating placement');
            }
        );
    }

    function deletePlacement(p_id){
    	console.log("In controller delete Placement :" + p_id)
        PlacementService.deletePlacement(p_id)
            .then(
            	fetchAllPlacementPage,
            function(errResponse){
                console.error('Error while deleting placement');
            }
        );
    }

    function edit(p_id){
    	console.log("in uctrl edit function:" + p_id);
        console.log('id to be edited',p_id);
        console.log('data self.placements.length:',self.placementdata.length);
        for(var i = 0; i < self.placementdata.length; i++){
        	
        console.log("value of i :" +i);
        	console.log('data self.placementdata[i].p_id:',self.placementdata[i].p_id);
        	if(self.placementdata[i].p_id === p_id) {
        
                $scope.placement = angular.copy(self.placementdata[i]);
                console.log('copied data',$scope.placement);
                break;
            }
        }
      //  updateUser(userId);
    }

    function remove(p_id){
    	console.log("in uctrl remove function:" + p_id);
        console.log('id to be deleted', p_id);
        if($scope.placement.p_id === p_id) {//clean form if the Placement to be deleted is shown there.
            reset();
        }
        deletePlacement(p_id);
    }

   function reset(){
	   self.placement={p_id:null,p_company:'',p_post:'',p_location:'',p_description:'',p_skill_set:'',p_date:'',p_salary:''};
//        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);

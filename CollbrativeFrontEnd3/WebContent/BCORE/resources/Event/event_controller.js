'use strict';
 

angular.module('myApp').controller('EventController', ['$scope', 'EventService', function($scope, EventService) {
	console.log('calling controller');
    var self = this;
    self.eventdata=[{e_id:null,e_title:'',e_place:'',e_date:'',e_time:'',e_description:'' ,userId:''}];
    $scope.event={e_id:null,e_title:'',e_place:'',e_date:'',e_time:'',e_description:'',userId:''};
    self.events=[]; 
    self.submit = submit;
    self.updateEvent = updateEvent;
    self.deleteEvent = deleteEvent;
    self.reset = reset;
    self.edit = edit;
    self.remove = remove;
 
    fetchAllEventPage();
    
    function fetchAllEventPage(){
        EventService.fetchAllEventPage()
            .then(
            function(d) {
                self.eventdata = d;
                console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching events');
            }
        );
    }
    function createEvent(event){
    	console.log('uname ' + event.e_title + 'address ' + event.e_place);
        EventService.createEvent(event)
            .then(
            function(u){
            	$scope.event=e;
            	console.log(e);
            	console.log("call create event controller");
            },
            function(errResponse){
                console.error('Error while creating event');
            }
        );
    }
     
    function submit() {
    	console.log("call submit 1");
        console.log('Saving New event', $scope.event);
    
        if($scope.event.e_id===null){
        	console.log("event null -- creating new")
            console.log('Saving New event', $scope.event);
            createEvent($scope.event);
        }else{
             updateEvent($scope.event, $scope.event.e_id);
         	console.log("event exist -- updating ")
            console.log(' EventData updated with id ', $scope.event.e_id);
        }
    	console.log("call submit 2");
        reset();
    }
    function updateEvent(event,e_id){
    	console.log("In uctrl Update Event :" + e_id )
        EventService.updateEvent(event,e_id)
            .then(
            fetchAllEventPage,
            function(errResponse){
                console.error('Error while updating Event');
            }
        );
    }

    function deleteEvent(e_id){
    	console.log("In controller delete Event :" + e_id)
        EventService.deleteEvent(e_id)
            .then(
            	fetchAllEventPage,
            function(errResponse){
                console.error('Error while deleting Event');
            }
        );
    }

    function edit(e_id){
    	console.log("in uctrl edit function:" + e_id);
        console.log('id to be edited',e_id);
        console.log('data self.events.length:',self.eventdata.length);
        for(var i = 0; i < self.eventdata.length; i++){
        	
        console.log("value of i :" +i);
        	console.log('data self.eventdata[i].e_id:',self.eventdata[i].e_id);
        	if(self.eventdata[i].e_id === e_id) {
                $scope.event = angular.copy(self.eventdata[i]);
                console.log('copied data',$scope.event);
                break;
            }
        }
      //  updateEvent(e_id);
    }

    function remove(e_id){
    	console.log("in uctrl remove function:" + e_id);
        console.log('id to be deleted', e_id);
        if($scope.event.e_id === e_id) {//clean form if the event to be deleted is shown there.
            reset();
        }
        deleteEvent(e_id);
    }

   function reset(){
	   self.event={e_id:null,e_title:'',e_place:'',e_date:'',e_time:'',e_description:'' };
//        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);

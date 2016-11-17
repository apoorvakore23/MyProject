package com.niit.collaborationbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.EventDAO;
import com.niit.collaborationbackend.model.Event;

@RestController
public class EventController {
@Autowired
private EventDAO eventDAO;


@GetMapping("events")
public ResponseEntity<List<Event>> getEvents()
{
	System.out.println(eventDAO.getAllEvents());
return new ResponseEntity(eventDAO.getAllEvents(),HttpStatus.OK);	
}


@GetMapping("event/{id}")
public ResponseEntity<?> getEvent(@PathVariable("id") int id)
{	
Event event = eventDAO.getEventByEventId(id);


if (event == null)
{
	return new ResponseEntity("No event found for id " + id, HttpStatus.NOT_FOUND);
}
System.out.println(event);
return new ResponseEntity(event.toString(), HttpStatus.OK);
}



@RequestMapping(value="event/create", method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> createEvent(@RequestBody  Event event)
{
eventDAO.addEvent(event);
System.out.println("event added : " + event);
return new ResponseEntity("hi", HttpStatus.OK);
}




@RequestMapping(value="event/delete/{e_id}",method=RequestMethod.DELETE)
public ResponseEntity<?> deleteEvent(@PathVariable int e_id)
{
	Event event = eventDAO.getEventByEventId(e_id);
	System.out.println("delete mapping with id :" + e_id);
	eventDAO.deleteEvent(event);
	System.out.println("event deleted : " + event );
	return new ResponseEntity("DELETED", HttpStatus.OK);
}


@RequestMapping(value="event/edit" ,method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> updateEvent(@RequestBody Event event)
{
	System.out.println("in event edit rest controller with event object :" + event);
	if ( event == null)
	{
		return new ResponseEntity("No event found for this id :" + event.getE_id(),HttpStatus.NOT_FOUND);
	}
	event = eventDAO.updateEvent(event.getE_id(), event);
return new ResponseEntity(event , HttpStatus.OK);	
}
}
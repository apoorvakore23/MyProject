package com.niit.collaborationbackend.dao;
import java.util.List;

import com.niit.collaborationbackend.model.Event;
public interface EventDAO {
	
		public void addEvent(Event u);
		public Event getEventByEventId(int id);
		 public List<Event> getAllEvents();
		 public Event getEventByEventname (String title);
		 public void deleteEvent(Event event);
		 public Event updateEvent(int id , Event event);
	}

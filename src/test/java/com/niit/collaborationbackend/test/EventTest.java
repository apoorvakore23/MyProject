package com.niit.collaborationbackend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaborationbackend.dao.EventDAO;
import com.niit.collaborationbackend.model.Event;

public class EventTest {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext mycontext = new AnnotationConfigApplicationContext();
		mycontext.scan("com.niit.collaborationbackend");
		mycontext.refresh();
		EventDAO eventdao = (EventDAO) mycontext.getBean("eventDAO");
		Event event = (Event) mycontext.getBean("event");
	event.setE_venue("borivali");
	event.setE_title("Convocation 2016");
	
	event.setE_description("The convocation is for 2016 passout students.");
	event.setE_start_date("01/10/2016");
	event.setE_contact("022 0154856");
	event.setE_email("convocation@niit.com");
	event.setE_start_time("11:00:00");
		eventdao.addEvent(event);
		System.out.println(eventdao.getAllEvents());
	}

}

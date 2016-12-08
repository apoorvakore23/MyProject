package com.niit.collaborationbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Event;

@Repository("eventDAOImpl")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addEvent(Event e) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
//		session.close();
	}

	@Transactional
	public Event getEventByEventId(int id) {
		Session session = sessionFactory.getCurrentSession();
		// System.out.print(id);
		Event e = (Event) session.load(Event.class, new Integer(id));
		System.out.println("get event by id :" + e);
		// session.close();
		return e;
	}

	@Transactional
	public List<Event> getAllEvents() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Event");
		@SuppressWarnings("unchecked")
		List<Event> eventsDetail = query.list();

		return eventsDetail;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public Event getEventByEventname(String e_title) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Event where e_title = ?");
		query.setString(0, e_title);

		return (Event) query.uniqueResult();
	}

	@Transactional
	public void deleteEvent(Event event) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (null != event) {
			session.delete(event);
		}
		// logger.info("Product deleted successfully, product details="+p);
		tx.commit();
//		session.close();
	}

	@Transactional
	public Event updateEvent(int id , Event event) {
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.update(event);
		tx.commit();
		Event e = (Event) session.load(Event.class, new Integer(id));
//		session.close();
		// logger.info("Product updated successfully, Product Details="+p);
		return e;
	}
	// public void storeFile(Event event) {
	//
	// MultipartFile file= event.getFile();
	//
	// if (!file.isEmpty()) {
	//
	// try{
	// byte[] bytes =file.getBytes();
	// System.out.println(file.getOriginalFilename());
	//
	// String BASE_PATH="E:/";
	// File serverFile = new
	// File(BASE_PATH+p.getProduct_category()+"/"+event.getImage());
	// serverFile.createNewFile();
	// BufferedOutputStream stream = new BufferedOutputStream(
	// new FileOutputStream(serverFile));
	// stream.write(bytes);
	// stream.close();
	// System.out.println("img stored");
	// }
	// catch(Exception ex)
	// {
	// System.out.println(ex);
	// }
	//
	// }
	// }

}

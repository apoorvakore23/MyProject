package com.niit.collaborationbackend.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.model.Friend;
import com.niit.collaborationbackend.model.User;


@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO{

	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error(" Unable to connect to db");
			e.printStackTrace();
		}
	}

	
	private Integer getMaxId()
	{
		log.debug("->->Starting of the method getMaxId");
		
		String hql = "select max(id) from Friend";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {
			maxID = (Integer) query.uniqueResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}
		log.debug("Max id :"+maxID);
		return maxID;

	}

	@Transactional
	public boolean save(Friend friend) {

		try {
		//	log.debug("*********************88Previous id "+getMaxId());
		//	friend.setF_id(getMaxId()+1);
			//log.debug("***********************generated id:"+getMaxId());
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	@Transactional
	public boolean update(Friend friend) {

		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(friend);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	/*@Transactional
	public Friend update(int id , Friend friend) {
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.update(friend);
		tx.commit();
		Friend u = (Friend) session.load(Friend.class, new Integer(id));
//		session.close();
		// logger.info("Product updated successfully, Product Details="+p);
		return u;
	}*/
	
	@Transactional
	public void delete(int userID, int friendID) {
		Friend friend = new Friend();
		friend.setFriendID(friendID);
		friend.setUserID(userID);
		sessionFactory.openSession().delete(friend);
	}

	@Transactional
	public List<Friend> getMyFriends(int userID) {
		String hql = "from Friend where userID=" + "'" + userID + "' and status ='"+ "A'";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<Friend> list = (List<Friend>) query.list();

		
		return list;

	}
	
	@Transactional
	public List<Friend> getNewFriendRequests(int userID) {
		String hql = "from Friend where friendID=" + "'" + userID + "' and status ='"+ "N'";
		Query query = sessionFactory.openSession().createQuery(hql);

		List<Friend> list = (List<Friend>) query.list();

		
		return list;

	}
	
	
	
	@Transactional
	public Friend get(int userID, int friendID) {
	    String hql = "from Friend where userID=" + "'" + userID + "' and friendID= '" + friendID + "'" ;
	    
	    log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		
		
		return (Friend) query.uniqueResult();
		

	}
	
	//We can use update method also.
	//isOnline need to set in controller and the ncal update
	
	
	
	/**
	 * Instead of writing the below two methods, you can use update method
	 */
	

	@Transactional
	public void setOnline(int userID) {
		log.debug("Starting of the metnod setOnline");
		String hql =" UPDATE Friend	SET isOnline = 'Y' where friendID='" +  userID + "'" ;
		  log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		query.executeUpdate();
		log.debug("Ending of the metnod setOnline");
		
	}
	
	@Transactional
	public void setOffLine(int userID) {
		log.debug("Starting of the metnod setOffLine");
		String hql =" UPDATE Friend	SET isOnline = 'N' where friendID='" +  userID + "'" ;
		  log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		query.executeUpdate();
		log.debug("Ending of the metnod setOffLine");
		
	}
	
	

}

package com.ecom.homedecorfrontend.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.models.UserDetails;



@Repository(value="userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired // inject automatically inside the object
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional    				//Automatically commit & rollback the transcation
	public boolean save(UserDetails userDetails) {
		try { // just right click -surrounded with-try catch block to handle
				// exception
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public void addUser(UserDetails u) {
		/*Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserRoles ur = new UserRoles();
		System.out.println("ur object created");
		session.save(u);
		ur.setAuthority("ROLE_USER");
		ur.getId()(u.getId());
		session.save(u);
		tx.commit();
		session.close();
		// logger.info("User saved successfully, User Details="+p);
*/	}		
	

	@Transactional
	public boolean update(UserDetails userDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public boolean delete(UserDetails userDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Transactional
	public UserDetails get(String id) {
		// provide domain object name
		String hql = "from UserDetails where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);// to convert query into db specific query

		@SuppressWarnings("unchecked")
		List<UserDetails> list = query.list();
		if (list == null)
			return null;
		else
			return list.get(0);

	}

	@SuppressWarnings("unchecked")	
	@Transactional
	public List<UserDetails> list() {
		// TODO Auto-generated method stub
		String hql = "from UserDetails";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@Transactional
	public UserDetails isValidUser(String id,String password){
		//select * from UserDetails where id='101' and password='niit'
		String hql="from UserDetails where id='"+id+"'and password='"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails>list=query.list();
		return (UserDetails) list;
	}

}

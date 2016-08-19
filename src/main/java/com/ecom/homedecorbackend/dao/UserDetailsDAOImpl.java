package com.ecom.homedecorbackend.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorbackend.model.UserDetails;
@Repository(value="userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired // inject automatically inside the object
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
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

	
	@Override
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

	@Override
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

	@Override
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
	@Override
	@Transactional
	public List<UserDetails> list() {
		// TODO Auto-generated method stub
		String hql = "from UserDetails";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}

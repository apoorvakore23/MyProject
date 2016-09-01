package com.ecom.homedecorfrontend.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.models.Category;


@Repository(value="categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired // inject automatically inside the object
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}


	@Transactional     				//Automatically commit & rollback the transcation
	public boolean save(Category category) {
		try { // just right click -surrounded with-try catch block to handle
				// exception
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	

	@Transactional
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Transactional
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Transactional
	public Category get(String id) {
		// provide domain object name
		String hql = "from Category where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);// to convert query into db specific query

		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		if (list == null)
			return null;
		else
			return list.get(0);

	}

	@SuppressWarnings("unchecked")

	@Transactional
	public List<Category> list() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}

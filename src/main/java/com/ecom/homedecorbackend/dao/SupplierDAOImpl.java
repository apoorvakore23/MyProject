package com.ecom.homedecorbackend.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorbackend.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired // inject automatically inside the object
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional      				//Automatically commit & rollback the transcation
	public boolean save(Supplier Supplier) {
		try { // just right click -surrounded with-try catch block to handle
				// exception
			sessionFactory.getCurrentSession().save(Supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	@Override
	@Transactional
	public boolean update(Supplier Supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(Supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean delete(Supplier Supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(Supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public Supplier get(String id) {
		// provide domain object name
		String hql = "from Supplier where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);// to convert query into db specific query

		@SuppressWarnings("unchecked")
		List<Supplier> list = query.list();
		if (list == null || list.isEmpty())
			return null;
		else
			return list.get(0);

	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
}

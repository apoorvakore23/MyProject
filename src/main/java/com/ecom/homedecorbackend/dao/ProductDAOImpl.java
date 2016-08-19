package com.ecom.homedecorbackend.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorbackend.model.Product;
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired // inject automatically inside the object
	private SessionFactory sessionFactory;
	private static final  Logger log =LoggerFactory.getLogger(ProductDAOImpl.class);
	//or 
	//private static final  Logger log =LoggerFactory.getLogger("com.ecom.homedecorbackend.dao.ProductDAOImpl");

	public ProductDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional      				//Automatically commit & rollback the transcation
	public boolean save(Product product) {
		try { // just right click -surrounded with-try catch block to handle
				// exception
			log.debug("starting of the method save");
			sessionFactory.getCurrentSession().save(product);
			log.debug("Ending of the method save");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Exception occurred in save method"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	
	@Override
	@Transactional
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {

			log.debug("starting of the method update");
			sessionFactory.getCurrentSession().update(product);
			log.debug("ending of the method update");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Exception occurred in update method"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try {
			log.debug("ending of the method delete");
			sessionFactory.getCurrentSession().delete(product);
			log.debug("ending of the method delete");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Exception occurred in delete method"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public Product get(String id) {
		// provide domain object name
		log.debug("starting of the method get `	");
		log.info("trying to get product based on id="+id);
		String hql = "from Product where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);// to convert query into db specific query
		log.info("the hsql query is:"+hql);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		if (list == null || list.isEmpty()){
			log.info("no product are available with this id:"+id);
			return null;}
		else{
			return list.get(0);
		}
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> list() {
		// TODO Auto-generated method stub
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list= query.list();	
		
		if (list == null || list.isEmpty()){
			log.info("no product are available");
			}
		
			return list;
		
	}

}

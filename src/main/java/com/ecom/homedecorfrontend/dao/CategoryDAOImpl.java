package com.ecom.homedecorfrontend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.models.Category;
@EnableTransactionManagement
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{	// private static final Logger logger =
	// LoggerFactory.getLogger(CategoryDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	private static final  Logger log =LoggerFactory.getLogger(CategoryDAOImpl.class);
	/*
	 * public void setSessionFactory(SessionFactory sf){ this.sessionFactory =
	 * sf; }
	 */

	@Transactional
	public void addCategory(Category p) {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
		// logger.info("Category saved successfully, Category Details="+p);
	}

	@Transactional
	public void updateCategory(Category p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(p);
		tx.commit();
		session.close();
		// logger.info("Category updated successfully, Category Details="+p);
	}
	
	public Category getCategoryByCategory_Id(int id) {
		Session session = this.sessionFactory.openSession();
		Category p = (Category) session.load(Category.class, new Integer(id));
		// logger.info("Category loaded successfully, Category details="+p);
		return p;
	}

	@Transactional
	public void removeCategory(int id) {
		Session session =sessionFactory.openSession();
		Category p = (Category) session.load(Category.class, new Integer(id));
		Transaction tx = session.beginTransaction();
		if (null != p) {
			session.delete(p);
		}
		// logger.info("Category deleted successfully, Category details="+p);
		tx.commit();
		session.close();
	}

	
	@SuppressWarnings("unchecked")
	public List<Category> listCategorys() {
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		List<Category> cList = session.createQuery("from Category").list();
		
		System.out.println(cList);
		return cList;
	}

	/*@Transactional
	@SuppressWarnings("unchecked")
	public List<Category> listCategorys() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list= query.list();	
		System.out.println("in dao");
		System.out.println(list);
		if (list == null || list.isEmpty()){
			System.out.println("no Category are available");
			log.info("no Category are available");
			}
		
			return list;
		
	}*/

	}
















































































/*import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.models.Category;
@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired // inject automatically inside the object
	private SessionFactory sessionFactory;
	private static final  Logger log =LoggerFactory.getLogger(CategoryDAOImpl.class);
	//or 
	//private static final  Logger log =LoggerFactory.getLogger("com.ecom.homedecorbackend.dao.CategoryDAOImpl");

	public CategoryDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional      				//Automatically commit & rollback the transcation
	public void save(Category p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}

	
	
	@Transactional
	public boolean update(Category Category) {
		// TODO Auto-generated method stub
		try {

			log.debug("starting of the method update");
			sessionFactory.getCurrentSession().update(Category);
			log.debug("ending of the method update");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Exception occurred in update method"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public boolean delete(Category Category) {
		// TODO Auto-generated method stub
		try {
			log.debug("ending of the method delete");
			sessionFactory.getCurrentSession().delete(Category);
			log.debug("ending of the method delete");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Exception occurred in delete method"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public Category get(int id) {
		// provide domain object name
		log.debug("starting of the method get `	");
		log.info("trying to get Category based on id="+id);
		String hql = "from Category where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);// to convert query into db specific query
		log.info("the hsql query is:"+hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		if (list == null || list.isEmpty()){
			log.info("no Category are available with this id:"+id);
			return null;}
		else{
			return list.get(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> list() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list= query.list();	
		
		if (list == null || list.isEmpty()){
			log.info("no Category are available");
			}
		
			return list;
		
	}
	@SuppressWarnings("unchecked")
	public List<Category> listAllCategory() {
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		List<Category> pList = session.createQuery("from Category").list();
		session.close();
		System.out.println(pList);
		return pList;
	}


}
*/
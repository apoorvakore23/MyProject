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

import com.ecom.homedecorfrontend.models.Supplier;
@EnableTransactionManagement
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{	// private static final Logger logger =
	// LoggerFactory.getLogger(SupplierDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	private static final  Logger log =LoggerFactory.getLogger(SupplierDAOImpl.class);
	/*
	 * public void setSessionFactory(SessionFactory sf){ this.sessionFactory =
	 * sf; }
	 */

	@Transactional
	public void addSupplier(Supplier s) {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
		// logger.info("Supplier saved successfully, Supplier Details="+p);
	}

	@Transactional
	public void updateSupplier(Supplier s) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(s);
		tx.commit();
		session.close();
		// logger.info("Supplier updated successfully, Supplier Details="+p);
	}
	
	public Supplier getSupplierBySupplier_Id(int id) {
		Session session = this.sessionFactory.openSession();
		Supplier s = (Supplier) session.load(Supplier.class, new Integer(id));
		// logger.info("Supplier loaded successfully, Supplier details="+p);
		return s;
	}

	@Transactional
	public void removeSupplier(int id) {
		Session session =sessionFactory.openSession();
		Supplier s = (Supplier) session.load(Supplier.class, new Integer(id));
		Transaction tx = session.beginTransaction();
		if (null != s) {
			session.delete(s);
		}
		// logger.info("Supplier deleted successfully, Supplier details="+p);
		tx.commit();
		session.close();
	}

	
	@SuppressWarnings("unchecked")
	public List<Supplier> listSuppliers() {
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		List<Supplier> sList = session.createQuery("from Supplier").list();
		
		System.out.println(sList);
		return sList;
	}

	/*@Transactional
	@SuppressWarnings("unchecked")
	public List<Supplier> listSuppliers() {
		// TODO Auto-generated method stub
		String hql = "from Supplier";
		Query<Supplier> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list= query.list();	
		System.out.println("in dao");
		System.out.println(list);
		if (list == null || list.isEmpty()){
			System.out.println("no Supplier are available");
			log.info("no Supplier are available");
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

import com.ecom.homedecorfrontend.models.Supplier;
@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired // inject automatically inside the object
	private SessionFactory sessionFactory;
	private static final  Logger log =LoggerFactory.getLogger(SupplierDAOImpl.class);
	//or 
	//private static final  Logger log =LoggerFactory.getLogger("com.ecom.homedecorbackend.dao.SupplierDAOImpl");

	public SupplierDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional      				//Automatically commit & rollback the transcation
	public void save(Supplier p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}

	
	
	@Transactional
	public boolean update(Supplier Supplier) {
		// TODO Auto-generated method stub
		try {

			log.debug("starting of the method update");
			sessionFactory.getCurrentSession().update(Supplier);
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
	public boolean delete(Supplier Supplier) {
		// TODO Auto-generated method stub
		try {
			log.debug("ending of the method delete");
			sessionFactory.getCurrentSession().delete(Supplier);
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
	public Supplier get(int id) {
		// provide domain object name
		log.debug("starting of the method get `	");
		log.info("trying to get Supplier based on id="+id);
		String hql = "from Supplier where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);// to convert query into db specific query
		log.info("the hsql query is:"+hql);
		@SuppressWarnings("unchecked")
		List<Supplier> list = query.list();
		if (list == null || list.isEmpty()){
			log.info("no Supplier are available with this id:"+id);
			return null;}
		else{
			return list.get(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list= query.list();	
		
		if (list == null || list.isEmpty()){
			log.info("no Supplier are available");
			}
		
			return list;
		
	}
	@SuppressWarnings("unchecked")
	public List<Supplier> listAllSupplier() {
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		List<Supplier> pList = session.createQuery("from Supplier").list();
		session.close();
		System.out.println(pList);
		return pList;
	}


}
*/
package com.ecom.homedecorfrontend.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.ecom.homedecorfrontend.models.Product;
@EnableTransactionManagement
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{	// private static final Logger logger =
	// LoggerFactory.getLogger(ProductDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	/*private static final  Logger log =LoggerFactory.getLogger(ProductDAOImpl.class);*/
	/*
	 * public void setSessionFactory(SessionFactory sf){ this.sessionFactory =
	 * sf; }
	 */

	@Transactional
	public void addProduct(Product p) {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
		// logger.info("Product saved successfully, Product Details="+p);
	}

	@Transactional
	public void updateProduct(Product p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(p);
		tx.commit();
		session.close();
		// logger.info("Product updated successfully, Product Details="+p);
	}
	
	public Product getProductByProduct_Id(int id) {
		Session session = this.sessionFactory.openSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		// logger.info("Product loaded successfully, Product details="+p);
		return p;
	}

	@Transactional
	public void removeProduct(int id) {
		Session session =sessionFactory.openSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		Transaction tx = session.beginTransaction();
		if (null != p) {
			session.delete(p);
		}
		// logger.info("Product deleted successfully, product details="+p);
		tx.commit();
		session.close();
	}

	
	@Transactional
	public List<Product> listProducts() {
		String hql="from Product";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
		/*
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		List<Product> pList = session.createQuery("from Product").list();
		
		System.out.println(pList);
		return pList;
	*/}
	public void storeFile(Product p) 	{
		 
		/*MultipartFile file= p.getFile();
	
		if (!file.isEmpty()) {
			
		try{
		byte[] bytes =file.getBytes();
		System.out.println("DAO in"+file.getOriginalFilename());		
		File serverFile = new File("E:/HomeDecor/HomeDecor/src/main/webapp/assets/images/"+p.getImage());
		serverFile.createNewFile();
		BufferedOutputStream stream = new BufferedOutputStream(	new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
			
	}	*/}

	/*@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		String hql = "from Product";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list= query.list();	
		System.out.println("in dao");
		System.out.println(list);
		if (list == null || list.isEmpty()){
			System.out.println("no product are available");
			log.info("no product are available");
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

import com.ecom.homedecorfrontend.models.Product;
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

	@Transactional      				//Automatically commit & rollback the transcation
	public void save(Product p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}

	
	
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

	
	@Transactional
	public Product get(int id) {
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
	@SuppressWarnings("unchecked")
	public List<Product> listAllProduct() {
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		List<Product> pList = session.createQuery("from Product").list();
		session.close();
		System.out.println(pList);
		return pList;
	}


}
*/
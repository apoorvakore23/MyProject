package com.niit.collaborationbackend.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Blog;
import com.niit.collaborationbackend.model.User;

//@Repository("blogDAOImpl")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addBlog(Blog b) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		session.save(b);
		
		tx.commit();
//		session.close();
	}

	@Transactional
	public Blog getBlogByBlogId(int id) {
		Session session = sessionFactory.getCurrentSession();
		// System.out.print(id);
		Blog b = (Blog) session.load(Blog.class, new Integer(id));
		System.out.println("get blog by id :" + b);
		// session.close();
		return b;
	}

	@Transactional
	public List<Blog> getAllBlogs() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Blog");
		@SuppressWarnings("unchecked")
		List<Blog> blogsDetail = query.list();

		return blogsDetail;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public Blog getBlogByBlogname(String Title) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Blog where blogname = ?");
		query.setString(0, Title);

		return (Blog) query.uniqueResult();
	}

	@Transactional
	public void deleteBlog(Blog blog) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (null != blog) {
			session.delete(blog);
		}
		// logger.info("Product deleted successfully, product details="+p);
		tx.commit();
//		session.close();
	}

	@Transactional
	public Blog updateBlog(int id , Blog blog) {
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.update(blog);
		tx.commit();
		Blog b = (Blog) session.load(Blog.class, new Integer(id));
//		session.close();
		// logger.info("Product updated successfully, Product Details="+p);
		return b;
	}
	// public void storeFile(Blog blog) {
	//
	// MultipartFile file= blog.getFile();
	//
	// if (!file.isEmpty()) {
	//
	// try{
	// byte[] bytes =file.getBytes();
	// System.out.println(file.getOriginalFilename());
	//
	// String BASE_PATH="E:/";
	// File serverFile = new
	// File(BASE_PATH+p.getProduct_category()+"/"+blog.getImage());
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

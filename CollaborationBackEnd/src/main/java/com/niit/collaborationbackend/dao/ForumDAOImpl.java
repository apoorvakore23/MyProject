package com.niit.collaborationbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Forum;

@Repository("forumDAOImpl")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addForum(Forum f) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(f);
		tx.commit();
//		session.close();
	}

	@Transactional
	public Forum getForumByForumId(int id) {
		Session session = sessionFactory.getCurrentSession();
		// System.out.print(id);
		Forum f = (Forum) session.load(Forum.class, new Integer(id));
		System.out.println("get forum by id :" + f);
		// session.close();
		return f;
	}

	@Transactional
	public List<Forum> getAllForums() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Forum");
		@SuppressWarnings("unchecked")
		List<Forum> forumsDetail = query.list();

		return forumsDetail;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public Forum getForumByForumname(String f_title) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Forum where f_title = ?");
		query.setString(0, f_title);

		return (Forum) query.uniqueResult();
	}

	@Transactional
	public void deleteForum(Forum forum) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (null != forum) {
			session.delete(forum);
		}
		// logger.info("Product deleted successfully, product details="+p);
		tx.commit();
//		session.close();
	}

	@Transactional
	public Forum updateForum(int id , Forum forum) {
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.update(forum);
		tx.commit();
		Forum f = (Forum) session.load(Forum.class, new Integer(id));
//		session.close();
		// logger.info("Product updated successfully, Product Details="+p);
		return f;
	}
	}

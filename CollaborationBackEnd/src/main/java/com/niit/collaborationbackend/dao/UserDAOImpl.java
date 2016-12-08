package com.niit.collaborationbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collaborationbackend.model.User;

//@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addUser(User u) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
//		session.close();
	}

	@Transactional
	public User getUserByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		// System.out.print(id);
		User u = (User) session.load(User.class, new Integer(id));
		System.out.println("get user by id :" + u);
		// session.close();
		return u;
	}

	@Transactional
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> usersDetail = query.list();

		return usersDetail;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public User getUserByUsername(String username) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from User where username = ?");
		query.setString(0, username);

		return (User) query.uniqueResult();
	}
	
	@Transactional
	public User Login(String username,String password) {
		System.out.println("DAO");
		String hql="from User where u_username=" + "'" + username + "'and  "+" u_password='" +password+ "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listOfUser=query.getResultList();
		if(listOfUser !=null  && !listOfUser.isEmpty()){
			System.out.println(listOfUser.get(0));
			return listOfUser.get(0);
			
			
		}
		return null;
		
	}

	@Transactional
	public void deleteUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (null != user) {
			session.delete(user);
		}
		// logger.info("Product deleted successfully, product details="+p);
		tx.commit();
//		session.close();
	}

	@Transactional
	public User updateUser(int id , User user) {
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		User u = (User) session.load(User.class, new Integer(id));
//		session.close();
		// logger.info("Product updated successfully, Product Details="+p);
		return u;
	}
	// public void storeFile(User user) {
	//
	// MultipartFile file= user.getFile();
	//
	// if (!file.isEmpty()) {
	//
	// try{
	// byte[] bytes =file.getBytes();
	// System.out.println(file.getOriginalFilename());
	//
	// String BASE_PATH="E:/";
	// File serverFile = new
	// File(BASE_PATH+p.getProduct_category()+"/"+user.getImage());
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

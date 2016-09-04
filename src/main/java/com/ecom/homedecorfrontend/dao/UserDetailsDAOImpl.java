package com.ecom.homedecorfrontend.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.models.UserDetails;
import com.ecom.homedecorfrontend.models.UserRoles;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
	

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addUser(UserDetails u) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserRoles ur = new UserRoles();
		System.out.println("UserRole object created");
		session.save(u);
		ur.setAuthority("ROLE_USER");
		ur.setId(u.getId());
		session.save(ur);
		tx.commit();
		session.close();
		
	}

			
		}

package com.ecom.homedecorfrontend.dao;

import java.io.Serializable;
import java.security.Principal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.homedecorfrontend.models.Customer;
import com.ecom.homedecorfrontend.models.ShippingAddress;


@Repository
public class ShippingDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addShippingAddress(ShippingAddress add, Principal p)
	{
	  Session	session =sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();	  
	  Query query = session.createQuery("from Customer where username = ?");
      query.setString(0, p.getName());
      Customer c= (Customer) query.uniqueResult();     
      c.setShippingAddress(add);
      add.setUsersDetail(c);
      session.save(add);
      session.update(c);
      tx.commit();
      session.close();

	}

}

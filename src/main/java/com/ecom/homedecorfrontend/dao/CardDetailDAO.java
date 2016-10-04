package com.ecom.homedecorfrontend.dao;

import java.io.Serializable;
import java.security.Principal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.homedecorfrontend.models.CardDetails;
import com.ecom.homedecorfrontend.models.Customer;
import com.ecom.homedecorfrontend.models.CustomerOrder;





@Repository
public class CardDetailDAO implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	    private SessionFactory sessionFactory;

	    @SuppressWarnings("deprecation")
		public void addCardDetail(CardDetails cardDetail, Principal p) {
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	       System.out.println("checkingout...");
	        Query query = session.createQuery("from Customer where username = ?");
	        query.setString(0, p.getName());
	        Customer c= (Customer) query.uniqueResult();
	        cardDetail.setUsersDetail(c);
	        cardDetail.setCart(c.getCart());
	        session.saveOrUpdate(cardDetail);
	        System.out.println("carddetails"+cardDetail);
	        CustomerOrder co = new CustomerOrder();
	        co.setUsersDetail(c);
	        co.setShippingAddress(c.getShippingAddress());
	        co.setCart(c.getCart());
	        session.save(co);
	        System.out.println("customer details"+co);
	        tx.commit();
	        session.flush();
	        session.close();
	    }
}

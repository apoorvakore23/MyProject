package com.ecom.homedecorfrontend.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.models.Cart;
import com.ecom.homedecorfrontend.models.Product;



@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory mySessionFactory;
	@Transactional
	public void addToCart(Cart cart) {
		Session session = mySessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int productId = cart.getProductId();
		Product product = (Product)session.get(Product.class, productId);
		double price = product.getPrice();
		cart.setPrice(price);
		cart.setProductName(product.getName());
		session.save(cart);
		tx.commit();
		System.out.println("Item isbeing added to the cart");
		
	}
	
	@Transactional
	public List<Cart> getCart() {
		Session session = mySessionFactory.openSession();
		Criteria criteria=session.createCriteria(Cart.class);
		List<Cart> cartList = criteria.list();
		session.close();
		return cartList;
		
	}
	
	
	@Transactional
	public void delete(int id) {
		System.out.println("Delete Cart Item");
		Session session = mySessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Cart cart =(Cart)session.load(Cart.class,id);
		
		session.delete(cart);
		tx.commit();
		session.close();
		
	}
	
	
	@Transactional
	public Cart findById(int cartId) {
		Session session=mySessionFactory.openSession();
		Cart cart = (Cart)session.get(Cart.class, cartId);
		if(cart!=null)
			return cart;
		else
		return null;
	}
	
	@Transactional
	public void updateCart(Cart cart) {
		System.out.println("Updating Cart");
		Session session=mySessionFactory.openSession();
		
		Criteria c = session.createCriteria(Cart.class);
	//	c.add(Restrictions.eq("userId", cart.getUserId()));
		List<Cart> cartUser = c.list();
		System.out.println(cartUser);
		for(Cart user : cartUser)
		{
			user.setAddress(cart.getAddress());
 
			 
			user.setPhoneNo(cart.getPhoneNo());
			session.update(user);
		}
		//session.saveOrUpdate(cart);
		session.flush();
		
	}
}

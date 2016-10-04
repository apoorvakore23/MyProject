package com.ecom.homedecorfrontend.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.models.Cart;
import com.ecom.homedecorfrontend.models.CartItem;
import com.ecom.homedecorfrontend.models.Product;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("DAO");
        session.saveOrUpdate(cartItem);
        tx.commit();
        session.flush();       
        session.close();
    }

    public void removeCartItem(CartItem cartItem){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(cartItem);
        tx.commit();
        session.flush();
        session.close();
        
    }

    public void removeAllCartItems(Cart cart){
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            removeCartItem(item);
        }
    }

    @Transactional
	public CartItem getCartItemByProductId(int productId){
		String hql="from CartItem where item="+ "'"+ productId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> list=query.list();
		if(list==null)
			return null;
		else
			return list.get(0);
	}
		
		
		/*
    	
		Session session = this.sessionFactory.openSession();
		CartItem p = (CartItem) session.load(CartItem.class, new Integer(productId));
		// logger.info("Product loaded successfully, Product details="+p);
		return p;
	
        Session session = sessionFactory.openSession();
       
		Query query = session.createQuery("from CartItem where itemId = ?");
        query.setInteger(0, productId);
        session.flush();

        return (CartItem) query.uniqueResult();*/
    

} // The End of Class;

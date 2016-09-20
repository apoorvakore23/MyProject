package com.ecom.homedecorfrontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.homedecorfrontend.dao.CartDAO;
import com.ecom.homedecorfrontend.models.Cart;

@Service
public class CartServices {
	@Autowired
	private CartDAO cartDAO;
	public void addToCart(Cart cart) {
		cartDAO.addToCart(cart);
	}
	
	
		public Cart findById(int cartId) {
			return cartDAO.findById(cartId);
		}
	
			
			public List<Cart> getCart() {
				return cartDAO.getCart();
			}
	
	
				public void delete(int id) {
					cartDAO.delete(id);
				}
}

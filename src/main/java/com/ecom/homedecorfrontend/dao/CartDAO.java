package com.ecom.homedecorfrontend.dao;



import java.util.List;

import com.ecom.homedecorfrontend.models.Cart;



public interface CartDAO {
	public void addToCart(Cart cart);
	public List<Cart> getCart();
	public void delete(int id);
	public Cart findById(int cartId);
	public void updateCart(Cart cart);
}
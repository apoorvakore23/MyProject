package com.ecom.homedecorfrontend.dao;

import com.ecom.homedecorfrontend.models.Cart;
import com.ecom.homedecorfrontend.models.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}

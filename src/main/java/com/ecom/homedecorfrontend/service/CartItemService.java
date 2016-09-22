package com.ecom.homedecorfrontend.service;

import com.ecom.homedecorfrontend.models.Cart;
import com.ecom.homedecorfrontend.models.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);

}

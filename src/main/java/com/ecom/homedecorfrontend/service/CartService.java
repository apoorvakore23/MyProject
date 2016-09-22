package com.ecom.homedecorfrontend.service;

import com.ecom.homedecorfrontend.models.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}

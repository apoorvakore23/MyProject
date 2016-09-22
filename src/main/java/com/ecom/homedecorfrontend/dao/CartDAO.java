package com.ecom.homedecorfrontend.dao;




import java.io.IOException;

import com.ecom.homedecorfrontend.models.Cart;

public interface CartDao {

    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);

}


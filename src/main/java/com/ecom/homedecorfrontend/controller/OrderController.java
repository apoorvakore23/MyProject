package com.ecom.homedecorfrontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.homedecorfrontend.models.Cart;
import com.ecom.homedecorfrontend.models.Customer;
import com.ecom.homedecorfrontend.models.CustomerOrder;
import com.ecom.homedecorfrontend.service.CartService;
import com.ecom.homedecorfrontend.service.CustmerOrderServiceImpl;


@Controller
public class OrderController {
	  @Autowired
	    private CartService cartService;

	    @Autowired
	    private CustmerOrderServiceImpl orderService;
	    
	    /* * createOrder method is used to insert user order into the database.*/
	     
	    @RequestMapping("/order/{cartId}")
	    public String createOrder(@PathVariable("cartId") int cartId) {
	    	CustomerOrder userOrder = new CustomerOrder();
	        Cart cart=cartService.getCartById(cartId);
	        userOrder.setCart(cart);

	        Customer usersDetail = cart.getUsersDetail();
	        userOrder.setUsersDetail(usersDetail);
	  //      userOrder.setShippingAddress();

	        orderService.addCustomerOrder(userOrder);

	        return "redirect:/checkout?cartId="+cartId;
	    }

}

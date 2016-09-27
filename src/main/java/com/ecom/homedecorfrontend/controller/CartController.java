package com.ecom.homedecorfrontend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.homedecorfrontend.models.Cart;
import com.ecom.homedecorfrontend.models.CartItem;
import com.ecom.homedecorfrontend.models.Customer;
import com.ecom.homedecorfrontend.models.Product;
import com.ecom.homedecorfrontend.service.CartItemService;
import com.ecom.homedecorfrontend.service.CustomerServiceImpl;
import com.ecom.homedecorfrontend.service.ProductServices;
@RestController
public class CartController {
	

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerServiceImpl usersDetailService;

    @Autowired
    private ProductServices itemService;
        

    @RequestMapping(value = "/addToCart/{itemId}", method = RequestMethod.PUT)
   @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addToCart (@PathVariable("itemId") int itemId, Principal principal) { 	 
    	Customer usersDetail = usersDetailService.getCustomerByUsername(principal.getName());    	
    	Cart cart = usersDetail.getCart();
    	System.out.println("add to cart"+ itemId);
        System.out.println("cart id:"+ cart.getCartId());
        Product item = itemService.getProductByProduct_Id(itemId);
        System.out.println("Product:"+ item.getName());
        List<CartItem> cartItems = cart.getCartItems();
        System.out.println("cart item size:"+ cartItems.size());
        for (int i=0; i<cartItems.size(); i++) {
            if(item.getId()==cartItems.get(i).getItem().getId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(item.getPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(item.getPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }
    @RequestMapping("/refreshCart")
    public Cart getCartById (Principal principal) {
    	Customer usersDetail = usersDetailService.getCustomerByUsername(principal.getName());
    	System.out.println("cart id:"+ usersDetail.getCustomerName());
        Cart cart = usersDetail.getCart();
        System.out.println(cart);
        return cart;
    }

    /* * removeItem method is used to remove a item from user cart.*/
     
    @RequestMapping(value = "/removeItem/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem (@PathVariable("itemId") int itemId) {
    	System.out.println("Deleting item Id: "+itemId);
        CartItem cartItem = cartItemService.getCartItemByProductId(itemId);
        cartItemService.removeCartItem(cartItem);

    }
    
   
    
     /** clearCartItems method is used to remove all items from user cart.*/
     
    @RequestMapping(value = "/clearCartItems", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCartItems(Principal principal) {
    	
    	Customer usersDetail = usersDetailService.getCustomerByUsername(principal.getName());
    	System.out.println("cart id:"+ usersDetail.getCustomerName());
        Cart cart = usersDetail.getCart();
        
        cartItemService.removeAllCartItems(cart);
    }
    
    /* * ExceptionHandler for client errors.*/
     
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}
    
    /* * ExceptionHandler for server errors.*/
     
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors (Exception e) {}
	

}

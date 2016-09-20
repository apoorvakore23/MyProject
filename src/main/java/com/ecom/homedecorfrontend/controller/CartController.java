package com.ecom.homedecorfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.ecom.homedecorfrontend.models.Cart;
import com.ecom.homedecorfrontend.service.CartServices;
@Controller
public class CartController {
	@Autowired
	CartServices  services;
	@RequestMapping(value="/addtocart",method=RequestMethod.POST)
	public ModelAndView addToCart(@ModelAttribute("cart") Cart cart,@RequestParam("productId")int productId/*,@RequestParam("quantity")int quantity*/,BindingResult result)
	{
		System.out.println("Adding to cart");
		cart.setProductId(productId);		
 		services.addToCart(cart);
 	 	List<Cart> cartList = services.getCart();
		ModelAndView model = new ModelAndView("/flow/cart");
		System.out.println("cartList"+cartList);
 		model.addObject("cartList",cartList);
		model.addObject("cartId",cart.getCartId());
		return model;
	}
	
	@RequestMapping(value="/user/viewcart")
	public ModelAndView viewCart(@ModelAttribute Cart cart)
	{
		List<Cart> cartList = services.getCart();
		ModelAndView model = new ModelAndView("/flow/cart");
 		model.addObject("cartList",cartList);
		model.addObject("cartId",cart.getCartId());
		return model;
	}
	
	@RequestMapping(value={"/collectbillinginfo","/user/collectbillinginfo"})
	public String collectBilling(@RequestParam("cartId") int cartId, @ModelAttribute("cart") Cart cart)
	{
		Cart mycart = services.findById(cartId); 
		
		System.out.println(mycart + " : "  + cartId);
		return "redirect:/cart?cartId="+cartId;
	}
	
	@RequestMapping(value="cart/delete/{cartId}", method = RequestMethod.GET)
	public String deleteCart(@PathVariable("cartId") int id, @ModelAttribute("cart")Cart cart)
	{
		System.out.println("Deleting Cart......");
		services.delete(id);
		return "redirect:/user/viewcart";
	}

}

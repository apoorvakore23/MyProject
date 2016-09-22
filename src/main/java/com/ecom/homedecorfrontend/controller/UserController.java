package com.ecom.homedecorfrontend.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.homedecorfrontend.models.BillingAddress;
import com.ecom.homedecorfrontend.models.Customer;
import com.ecom.homedecorfrontend.models.ShippingAddress;
import com.ecom.homedecorfrontend.models.UserDetails;
import com.ecom.homedecorfrontend.service.CategoryServices;
import com.ecom.homedecorfrontend.service.CustomerService;
import com.ecom.homedecorfrontend.service.SupplierServices;





@Controller
public class UserController {
	
	@Autowired
    private CustomerService customerService;

	@Autowired
	private SupplierServices supplierservices;
	
	@Autowired
	private CategoryServices categoryDetails;
	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView addData() {
		System.out.println("adduser page display");
		return new ModelAndView("register", "adduser", new UserDetails());
	}

	
	@RequestMapping(value="/register" , method=RequestMethod.POST)
	public ModelAndView addData(@Valid @ModelAttribute("adduser") UserDetails u,BindingResult result, Model model) {

		//List<User> list =  pmd.getAllUser();
	System.out.println("post method adduser");
if (result.hasErrors()) {
		
	return new ModelAndView( "register");
	}
		else{
	
	userService.addUser(u);
	Customer customer = new Customer();
    BillingAddress billingAddress = new BillingAddress();
    ShippingAddress shippingAddress = new ShippingAddress();
    customer.setBillingAddress(billingAddress);
    customer.setShippingAddress(shippingAddress);

    model.addAttribute("customer", customer);

	
	return new ModelAndView("login","login",true);
		
	}
		
}
	*/
	 @RequestMapping("/register")
	    public String registerCustomer(Model model){
	        Customer customer = new Customer();
	        BillingAddress billingAddress = new BillingAddress();
	        ShippingAddress shippingAddress = new ShippingAddress();
	        customer.setBillingAddress(billingAddress);
	        customer.setShippingAddress(shippingAddress);

	        model.addAttribute("customer", customer);

	        return "register";
	    }


	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){

	        if(result.hasErrors()){
	            return "register";
	        }

	        List<Customer> customerList = customerService.getAllCustomers();

	        for (int i=0; i< customerList.size(); i++){
	            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())){
	                model.addAttribute("emailMsg", "Email already exists");

	                return "register";
	            }

	            if(customer.getUsername().equals(customerList.get(i).getUsername())){
	                model.addAttribute("usernameMsg", "Username already exists");

	                return "register";
	            }
	        }

	        customer.setEnabled(true);
	        customerService.addCustomer(customer);
	        return "login";
	    }

	
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	 public String login(HttpSession session) {
	 System.out.println("login page");
	  return "login";
	 
	 }
	 
	 @RequestMapping(value="/fail2login", method = RequestMethod.GET)
	 public ModelAndView loginerror(ModelMap model) {
		 System.out.println("fail to login page");
	
	  return new ModelAndView("login","error",true);
	 
	 }	
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public ModelAndView logout(HttpServletRequest request,HttpServletResponse response)
	 {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if (auth != null) {
		 new SecurityContextLogoutHandler().logout(request, response, auth);
		 }
	 
	  return new ModelAndView("login","logoutmsg", "Logged Out Successfully");
	 
	 }
	 
	 
	 @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	    public ModelAndView printWelcome(ModelMap model, Principal principal,HttpSession session) {
		 String name=principal.getName();	
				 
		 ModelAndView mv=new ModelAndView("index");
		 session.setAttribute("userDetails",name);
		/* mv.addObject("userDetails",name);*/
		
		 session.setAttribute("supplierDetails",supplierservices.listSupplier());
		 session.setAttribute("CategoryDetails",categoryDetails.listCategory());
		 return mv;

	    }
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
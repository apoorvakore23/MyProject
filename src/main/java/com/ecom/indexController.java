package com.ecom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	   public String index()
	{
		   return "index";
	}
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	   public String about()
	{
		   return "about";
	}
	@RequestMapping(value = "/newarrivals", method = RequestMethod.GET)
	   public String newarrivals()
	{
		   return "newarrivals";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	   public String signin()
	{
		   return "signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	   public String signup()
	{
		   return "signup";
	}
	
	@RequestMapping(value = "/living", method = RequestMethod.GET)
	   public String living()
	{
		   return "living";
	}
	@RequestMapping(value = "/bedroom", method = RequestMethod.GET)
	   public String bedroom()
	{
		   return "bedroom";
	}
	@RequestMapping(value = "/dinning", method = RequestMethod.GET)
	   public String dinning()
	{
		   return "dinning";
	}
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	   public String contact()
	{
		   return "contact";
	}
	}
	
package com.ecom.homedecorfrontend.controller;
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
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	   public String index2()
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
	
package com.ecom.homedecorfrontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.homedecorfrontend.dao.ProductDAO;
import com.ecom.homedecorfrontend.models.Product;
import com.ecom.homedecorfrontend.service.ProductServices;



@Controller

public class indexController{
	
	@Autowired
	ProductServices services;
	
	
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
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	   public String login()
	{
		   return "login";
	}*/
	
	
	
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
	
	@RequestMapping(value="/add", method=RequestMethod.GET )
	public ModelAndView AddPage()
	{
		return new ModelAndView("addproduct","product",new Product());
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST )
	public String AddActionPage(@ModelAttribute("product")  Product p,BindingResult result, Model model)
	{
		
		
		System.out.println("post method addproduct");
		
		if (result.hasErrors()) {
					
					return "addproduct";
				}
				else{
					
					services.addProduct(p);
					
				return "index";
				}
				
			}
		
	
	@RequestMapping(value="/dispProduct", method=RequestMethod.GET )	
	public ModelAndView addProduct(){
	List<Product> pList=services.listProduct();
	ModelAndView model=new ModelAndView("viewproduct");
	model.addObject("pList",pList);
	System.out.println(pList);
	return model;		
	}
	
	
	/*@RequestMapping(value="/editProduct", method=RequestMethod.GET )	
	public ModelAndView editProduct(){
	List<Product> pList=services.listProduct();
	ModelAndView model=new ModelAndView("viewproduct");
	model.addObject("pList",pList);
	System.out.println(pList);
	return model;		
	}*/
	
	@RequestMapping(value="/edit/{productId}", method = RequestMethod.GET)
	public ModelAndView EditPage(@PathVariable("productId") int id)
	{
		System.out.println("coming to edit controller and return model and view update product");
		Product p = services.getProductByProduct_Id(id);
			
		return new ModelAndView("updateProduct","product",p);
	}
	
	
	@RequestMapping(value="/edit/updateProduct", method=RequestMethod.POST )
	public String EditActionPage(@Valid @ModelAttribute("product") Product p, BindingResult result, Model model)
	{
		System.out.println(result);
		
		System.out.println("post method addproduct");
        if (result.hasErrors()) {
        	return "updateProduct";
		}
		else{		
			services.updateProduct(p);
			return "viewproduct";
		}		
	}
	@ModelAttribute("product") 
	@RequestMapping(value="/details/{productId}", method = RequestMethod.GET)
	public ModelAndView DetailsPage(@PathVariable("productId") int id)
	{
		System.out.println("coming to view controller and return model and view update product");
		Product p = services.getProductByProduct_Id(id);
			System.out.println(p);
		return new ModelAndView("productDetails","product",p);
	}
	
	@ModelAttribute("product") 
	@RequestMapping(value="/delete/{productId}", method=RequestMethod.GET )	
	public ModelAndView  DeletePage(@PathVariable("productId") int id)
	{
		System.out.println("coming to controller and return delete page");
		
	Product p = services.getProductByProduct_Id(id);
		System.out.println(p);
	return new ModelAndView("deleteProduct","product", p);
		
	}
	
	@RequestMapping(value="delete/deleteProducttrue/{productId}", method=RequestMethod.POST)
	public String  DeleteActionPage(@PathVariable("productId") int id)
	{
		
		System.out.println("coming to controller and call remove product return allproduct");
		services.removeProduct(id);
		return "viewproduct";
	}
	
	
	/*@RequestMapping(value="/disp", method=RequestMethod.GET )
	public String ViewAllPage()
	{
		System.out.println("in disp controller");
		return "viewproduct";
	}
	@RequestMapping(value="/data", method=RequestMethod.GET )
	public @ResponseBody List<Product> Data()
	{
		System.out.println("in data controller");			 
		 System.out.println(services.listProduct());
		 return  services.listProduct();
	}*/
	
/*@RequestMapping(value="/data", method=RequestMethod.GET)
	public ModelAndView Data()
	{
		List<Product> list=productDAO.listProducts();
		ModelAndView mv=new ModelAndView("viewproduct");
		mv.addObject("data",list.toString());
		System.out.println("controller");
		System.out.println(list.toString());
		System.out.println("in data controller");
		System.out.println("mv"+mv);
		return mv;
		
		
	}*/
	
	/*@RequestMapping(value="/details", method=RequestMethod.GET )
	public String DetailsPage(@PathVariable("productId") int id)
	{
		System.out.println("coming to controller and returnproduct details");
		return "productDetails";
	}*/
	
	
	
	
	
	
	}
	
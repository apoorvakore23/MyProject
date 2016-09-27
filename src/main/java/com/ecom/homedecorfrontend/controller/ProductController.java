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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.homedecorfrontend.models.Product;
import com.ecom.homedecorfrontend.service.ProductServices;
import com.ecom.homedecorfrontend.util.FileUtil;
@Controller
public class ProductController {
	
	@Autowired
	ProductServices services;
	private String path="E:\\apoorva\\HomeDecor\\src\\main\\webapp\\assets\\Multipath\\";
	@RequestMapping(value="/add", method=RequestMethod.GET )
	public ModelAndView AddPage()
	{
		return new ModelAndView("addproduct","product",new Product());
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST )
	public ModelAndView AddActionPage(@Valid @ModelAttribute("product")  Product p,BindingResult result,@RequestParam(value = "image", required = false) MultipartFile image, Model model)
	{	
		if (result.hasErrors()) {
			System.out.println("post method addproduct"+result);	
			 	ModelAndView mv=new ModelAndView("addproduct","product",new Product());
			 	return mv;
				}
				else{
					System.out.println(p);
					
					FileUtil.upload(path, image, p.getName()+".jpg");
					p.setFile(p.getName()+".jpg");
					services.addProduct(p);
					List<Product> pList=services.listProduct();
					ModelAndView mv=new ModelAndView("viewproduct");
					mv.addObject("pList",pList);
					System.out.println(pList);
					return mv;
				}
				
			}
		
	
	@RequestMapping(value="/dispProduct" )	
	public ModelAndView addProduct(){
	List<Product> pList=services.listProduct();
	ModelAndView model=new ModelAndView("viewproduct");
	model.addObject("pList",pList);
	System.out.println(pList);
	return model;		
	}
	
	@RequestMapping(value="/details", method=RequestMethod.GET )
	public String ViewAllPage()
	{
		System.out.println("in disp controller");
		return "productDetails";
	}
	@RequestMapping(value="/data", method=RequestMethod.GET )
	public @ResponseBody List<Product> Data()
	{
		System.out.println("in data controller");			 
		 System.out.println(services.listProduct());
		 return  services.listProduct();
	}
	
	@RequestMapping(value="/edit/{productId}", method = RequestMethod.GET)
	public ModelAndView EditPage(@PathVariable("productId") int id)
	{
		System.out.println("coming to edit controller and return model and view update product");
		Product p = services.getProductByProduct_Id(id);
			
		return new ModelAndView("updateProduct","product",p);
	}
	
	
	@RequestMapping(value="/edit/updateProduct", method=RequestMethod.POST )
	public ModelAndView EditActionPage(@Valid @ModelAttribute("product") Product p, BindingResult result, Model model)
	{
		System.out.println(result);
		
		System.out.println("post method addproduct");
        if (result.hasErrors()) {
        	return new ModelAndView("updateProduct","product",p);
        	
		}
		else{	
			
			services.updateProduct(p);
			List<Product> pList=services.listProduct();
			ModelAndView mv=new ModelAndView("viewproduct");
			mv.addObject("pList",pList);
			System.out.println(pList);
			return mv;	
			
		}		
	}
	/*@ModelAttribute("product") 
	@RequestMapping(value="/details/{productId}", method = RequestMethod.GET)
	public ModelAndView DetailsPage(@PathVariable("productId") int id)
	{
		System.out.println("coming to view controller and return model and view update product");
		Product p = services.getProductByProduct_Id(id);
			System.out.println(p);
		return new ModelAndView("productDetails","product",p);
	}*/
	
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
	public ModelAndView  DeleteActionPage(@PathVariable("productId") int id)
	{
		
		System.out.println("coming to controller and call remove product return allproduct");
		services.removeProduct(id);
		List<Product> pList=services.listProduct();
		ModelAndView model=new ModelAndView("viewproduct");
		model.addObject("pList",pList);
		System.out.println(pList);
		return model;	
	}
	
	
	@RequestMapping(value = "/dataById/{id}", method = RequestMethod.GET)
	public @ResponseBody Product dataById(@PathVariable("id") int id) {
System.out.println("product controller"+services.getProductByProduct_Id(id));
		return services.getProductByProduct_Id(id);

	}
	
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

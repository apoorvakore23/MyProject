

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
import org.springframework.web.servlet.ModelAndView;

import com.ecom.homedecorfrontend.dao.CategoryDAO;

import com.ecom.homedecorfrontend.models.Category;
import com.ecom.homedecorfrontend.service.CategoryServices;
@Controller
public class CategoryController {
	@Autowired
	CategoryServices services;
	
	
	@RequestMapping(value="/addCategorys", method=RequestMethod.GET )
	public ModelAndView AddPage()
	{
		return new ModelAndView("addCategory","category",new Category());
	}
	
	@RequestMapping(value="/addCategorys", method=RequestMethod.POST )
	public String AddActionPage(@ModelAttribute("category")  Category c, Model model)
	{
		services.addCategory(c);
		return "index";	
		
	}
	@RequestMapping(value="/dispCategorys", method=RequestMethod.GET )	
	public ModelAndView addCategory(){
	List<Category> cList=services.listCategory();
	ModelAndView model=new ModelAndView("viewCategory");
	model.addObject("cList",cList);
	System.out.println(cList);
	return model;		
	}
	
	
	
	@RequestMapping(value="/editCategory/{categoryId}", method = RequestMethod.GET)
	public ModelAndView EditPage(@PathVariable("categoryId") int id)
	{
		System.out.println("coming to edit controller and return model and view update Category");
		Category p = services.getCategoryByCategory_Id(id);
			
		return new ModelAndView("updateCategory","category",p);
	}
	
	
	@RequestMapping(value="/editCategory/updateCategory", method=RequestMethod.POST )
	public String EditActionPage(@Valid @ModelAttribute("category") Category s, BindingResult result, Model model)
	{
		System.out.println(result);
		
		System.out.println("post method addCategory");
        if (result.hasErrors()) {
        	return "updateCategory";
		}
		else{		
			services.updateCategory(s);
			return "viewCategory";
		}		
	}
	@ModelAttribute("Category") 
	@RequestMapping(value="/detailsCategory/{categoryId}", method = RequestMethod.GET)
	public ModelAndView DetailsPage(@PathVariable("categoryId") int id)
	{
		System.out.println("coming to view controller and return model and view update Category");
		Category p = services.getCategoryByCategory_Id(id);
			System.out.println(p);
		return new ModelAndView("categoryDetails","category",p);
	}
	
	@ModelAttribute("Category") 
	@RequestMapping(value="/deleteCategory/{categoryId}", method=RequestMethod.GET )	
	public ModelAndView  DeletePage(@PathVariable("categoryId") int id)
	{
		System.out.println("coming to controller and return delete page");
		
	Category p = services.getCategoryByCategory_Id(id);
		System.out.println(p);
	return new ModelAndView("deleteCategory","Category", p);
		
	}
	
	@RequestMapping(value="deleteCategory/deleteCategorytrue/{categoryId}", method=RequestMethod.POST)
	public String  DeleteActionPage(@PathVariable("categoryId") int id)
	{
		
		System.out.println("coming to controller and call remove Category return allCategory");
		services.removeCategory(id);
		return "viewCategory";
	}
	
	
	}
	
	
	

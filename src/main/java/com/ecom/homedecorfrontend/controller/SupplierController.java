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

import com.ecom.homedecorfrontend.dao.SupplierDAO;

import com.ecom.homedecorfrontend.models.Supplier;
import com.ecom.homedecorfrontend.service.SupplierServices;
@Controller
public class SupplierController {
	@Autowired
	SupplierServices services;
	
	
	@RequestMapping(value="/addSuppliers", method=RequestMethod.GET )
	public ModelAndView AddPage()
	{
		return new ModelAndView("addSupplier","supplier",new Supplier());
	}
	
	@RequestMapping(value="/addSuppliers", method=RequestMethod.POST )
	public String AddActionPage(@ModelAttribute("supplier")  Supplier s, Model model)
	{
		services.addSupplier(s);
		return "index";	
		
	}
	@RequestMapping(value="/dispSuppliers", method=RequestMethod.GET )	
	public ModelAndView addSupplier(){
	List<Supplier> sList=services.listSupplier();
	ModelAndView model=new ModelAndView("viewSupplier");
	model.addObject("sList",sList);
	System.out.println(sList);
	return model;		
	}
	
	
	
	@RequestMapping(value="/editSupplier/{supplierId}", method = RequestMethod.GET)
	public ModelAndView EditPage(@PathVariable("supplierId") int id)
	{
		System.out.println("coming to edit controller and return model and view update Supplier");
		Supplier p = services.getSupplierBySupplier_Id(id);
			
		return new ModelAndView("updateSupplier","supplier",p);
	}
	
	
	@RequestMapping(value="/editSupplier/updateSupplier", method=RequestMethod.POST )
	public String EditActionPage(@Valid @ModelAttribute("supplier") Supplier s, BindingResult result, Model model)
	{
		System.out.println(result);
		
		System.out.println("post method addSupplier");
        if (result.hasErrors()) {
        	return "updateSupplier";
		}
		else{		
			services.updateSupplier(s);
			return "viewSupplier";
		}		
	}
	@ModelAttribute("Supplier") 
	@RequestMapping(value="/detailsSupplier/{supplierId}", method = RequestMethod.GET)
	public ModelAndView DetailsPage(@PathVariable("supplierId") int id)
	{
		System.out.println("coming to view controller and return model and view update Supplier");
		Supplier p = services.getSupplierBySupplier_Id(id);
			System.out.println(p);
		return new ModelAndView("supplierDetails","supplier",p);
	}
	
	@ModelAttribute("Supplier") 
	@RequestMapping(value="/deleteSupplier/{supplierId}", method=RequestMethod.GET )	
	public ModelAndView  DeletePage(@PathVariable("supplierId") int id)
	{
		System.out.println("coming to controller and return delete page");
		
	Supplier p = services.getSupplierBySupplier_Id(id);
		System.out.println(p);
	return new ModelAndView("deleteSupplier","supplier", p);
		
	}
	
	@RequestMapping(value="deleteSupplier/deleteSuppliertrue/{supplierId}", method=RequestMethod.POST)
	public String  DeleteActionPage(@PathVariable("supplierId") int id)
	{
		
		System.out.println("coming to controller and call remove Supplier return allSupplier");
		services.removeSupplier(id);
		return "viewSupplier";
	}
	
	
	}
	
	
	

package com.ecom.homedecorbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecom.homedecorbackend.dao.ProductDAO;

import com.ecom.homedecorbackend.model.Product;

public class TestCaseProduct {

	//to write test case for Product,we need productDAO and Product object
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	//you can write a method to initialize the objects
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom.homedecorbackend");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		product=(Product)context.getBean("product");	
		
		
	}
	@Test
	public void categoryTestCase()
	{
		List<Product> list=productDAO.list();		//returning list of record
		int rowCount=list.size();
	assertEquals("Product List Test case",rowCount,0);     
	
	}
	@Test
	public void deleteProductTestCase(){
		product.setId("P10");
	boolean flag=productDAO.delete(product);
	assertEquals("delete product test caes",flag, false);
	}
	
	@Test
	public void addProductTestCase(){
		product.setId("P106");
		product.setName("living");
		product.setDesc("Sofa cum Beds");
		boolean flag=productDAO.save(product);
		assertEquals(flag,true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

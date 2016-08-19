package com.ecom.homedecorbackend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.homedecorbackend.dao.CategoryDAO;
import com.ecom.homedecorbackend.model.Category;




public class TestCaseCategory {

	//to write test case for Product,we need productDAO and Product object
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	//you can write a method to initialize the objects
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom.homedecorbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category=(Category)context.getBean("category");	
		
		
	}
	@Test
	public void categoryTestCase()
	{
		List<Category> list=categoryDAO.list();		//returning list of record
		int rowCount=list.size();
	assertEquals("category List Test case",rowCount,0);     
	
	}
	@Test
	public void deletecategoryTestCase(){
		category.setId("P10");
	boolean flag=categoryDAO.delete(category);
	assertEquals("delete category test caes",flag, false);
	}
	
	@Test
	public void addCategoryTestCase(){
		category.setId("C101");
		category.setName("living");
		category.setDescription("Sofa_cum_Beds");
		boolean flag=categoryDAO.save(category);
		assertEquals(flag,true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

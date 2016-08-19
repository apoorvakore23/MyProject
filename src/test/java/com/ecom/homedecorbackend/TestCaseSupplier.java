package com.ecom.homedecorbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.homedecorbackend.dao.SupplierDAO;
import com.ecom.homedecorbackend.model.Supplier;

public class TestCaseSupplier {

	//to write test case for Supplier,we need SupplierDAO and Supplier object
		@Autowired
		SupplierDAO supplierDAO;
		@Autowired
		Supplier supplier;
		AnnotationConfigApplicationContext context;
		//you can write a method to initialize the objects
		@Before
		public void init()
		{
			context=new AnnotationConfigApplicationContext();
			context.scan("com.ecom.homedecorbackend");
			context.refresh();
			supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
			supplier=(Supplier)context.getBean("supplier");	
			
			
		}
		@Test
		public void categoryTestCase()
		{
			List<Supplier> list=supplierDAO.list();		//returning list of record
			int rowCount=list.size();
		assertEquals("Supplier List Test case",rowCount,0);     
		
		}
		@Test
		public void deleteSupplierTestCase(){
			supplier.setId("S10");
		boolean flag=supplierDAO.delete(supplier);
		assertEquals("delete Supplier test caes",flag, false);
		}
		
		@Test
		public void addSupplierTestCase(){
			supplier.setId("S101");
			supplier.setName("Vora");
			supplier.setAddress("Mumbai");
			boolean flag=supplierDAO.save(supplier);
			assertEquals(flag,true);
			
		}
		

}

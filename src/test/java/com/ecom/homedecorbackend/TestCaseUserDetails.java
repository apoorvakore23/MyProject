package com.ecom.homedecorbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.homedecorbackend.dao.UserDetailsDAO;
import com.ecom.homedecorbackend.model.UserDetails;

public class TestCaseUserDetails {

	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails userDetails;
	AnnotationConfigApplicationContext context;
	//you can write a method to initialize the objects
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom.homedecorbackend");
		context.refresh();
		userDetailsDAO=(UserDetailsDAO)context.getBean("userDetailsDAO");
		userDetails=(UserDetails)context.getBean("userDetails");	
		
		
	}
	@Test
	public void categoryTestCase()
	{
		List<UserDetails> list=userDetailsDAO.list();		//returning list of record
		int rowCount=list.size();
	assertEquals("userDetails List Test case",rowCount,0);     
	
	}
	@Test
	public void deleteuserDetailsTestCase(){
		userDetails.setId("s101");
	boolean flag=userDetailsDAO.delete(userDetails);
	assertEquals("delete userDetails test caes",flag, false);
	}
	
	@Test
	public void adduserDetailsTestCase(){
		userDetails.setId("U104");
		userDetails.setName("Priyanka ");
			userDetails.setAddress("Mumbai");
		boolean flag=userDetailsDAO.save(userDetails);
		assertEquals(flag,true);
		
	}
}

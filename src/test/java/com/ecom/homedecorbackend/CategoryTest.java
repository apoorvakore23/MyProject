package com.ecom.homedecorbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.homedecorbackend.dao.CategoryDAO;
import com.ecom.homedecorbackend.model.Category;

public class CategoryTest {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext();
	context1.scan("com.ecom.homedecorbackend");
	context1.refresh();
CategoryDAO categoryDAO=(CategoryDAO) context1.getBean("categoryDAO");
Category category =(Category)context1.getBean("category");
category.setId("CG001");
category.setName("Fabric_sofa");
category.setDescription("fabric sofa");

if(categoryDAO.save(category)==true)
{
	System.out.println("category created successfullly....");}
else{
	System.out.println("error");
}
if(categoryDAO.delete(category)==true)
{
	System.out.println("category deleted successfullly....");}
else{
	System.out.println("error");
}	
	
}
	
}

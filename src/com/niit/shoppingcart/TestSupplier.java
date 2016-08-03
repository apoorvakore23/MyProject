package com.niit.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class TestSupplier {
	public static void main(String[] args) {
		Product p1=new Product(101,"iphone",50000);
		Product p2=new Product(102,"macboook",400000);
		Supplier s1=new Supplier("sup001", "Reliance", "Mumbai");
		/*
		 * one to one relation
		 s1.setProduct(p1);
		s1.setProduct(p2);*/
		
		
		
		System.out.println("Details of supplier for 1 to 1 relationship...=>");
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getAddress());
		/*System.out.println(s1.getProduct().getId());
		System.out.println(s1.getProduct().getName());*/
			
		
		System.out.println("list explanation");
		List<Product> productList=new ArrayList<Product>();		
		productList.add(p1);
		productList.add(p2);
		s1.setProducts(productList);
		
		
		List<Product> Products=s1.getProducts();
		for(Product p:Products){
			if(p.getPrice()<0){
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getPrice());}
            System.out.println("....");	
            }
		
		
		
		
		
	}

}

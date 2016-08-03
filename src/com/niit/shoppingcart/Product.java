package com.niit.shoppingcart;

import java.util.List;

//Domain Object /POJO(plain old java object)/ VLO(value object)/JavaBean 
//these class should contain & setter/getter method --nothing else {no main method}

class Product {
       //add the properties:id,name,price
	private int id;
	private String name;
	private int price;
	
	
	private List<Supplier> suppliers;
	
	//generate Constructor
	
	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	//to access the properties write the public  methods
	
		//these methods are called setter/getter methods
		
	//to generate just right click-source-generate .
	
		
	public Product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	
	/*public void setId(int id) {
		this.id = id;
	}*/
	
	public String getName() {
		return name;
	}
	
	/*public void setName(String name) {
		this.name = name;
	}*/
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price<0){
			price =50000;
			System.out.println("should not be -ve & default its 50000");
		}
		this.price = price;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	
	
	
	
	
	
	
}

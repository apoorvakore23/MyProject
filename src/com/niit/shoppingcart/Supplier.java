package com.niit.shoppingcart;

import java.util.List;

public class Supplier {
	
private String id;
private String name;
private String address;

private List<Product> products;


public Supplier(String id, String name, String address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

/* this is for one to one relations
 public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}
*/
public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}


}

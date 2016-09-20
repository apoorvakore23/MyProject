package com.ecom.homedecorfrontend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.homedecorfrontend.models.Product;



@Repository
public interface ProductDAO {
// Declare all CRUD operation
	
	
	public void addProduct(Product p);
	public void updateProduct(Product p);
	public List<Product> listProducts();
	
	public void removeProduct(int product_id);
	
	public Product getProductByProduct_Id(int id);
	
	public void storeFile(Product p);
	
	
}

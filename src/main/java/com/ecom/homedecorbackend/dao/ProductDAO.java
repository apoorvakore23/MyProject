package com.ecom.homedecorbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.homedecorbackend.model.Product;

@Repository
public interface ProductDAO {
// Declare all CRUD operation
	public boolean save(Product product);
    public boolean update(Product product);
    public boolean delete(Product product);
    public Product get(String id);
    public List <Product> list();
	
	
}

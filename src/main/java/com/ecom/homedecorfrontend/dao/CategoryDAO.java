package com.ecom.homedecorfrontend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.homedecorfrontend.models.Category;



@Repository
public interface CategoryDAO {
// Declare all CRUD operation
	public boolean save(Category category);
    public boolean update(Category category);
    public  boolean delete(Category category);
    public Category get(String id);
    public List <Category> list();
	
	
}

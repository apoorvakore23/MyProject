package com.ecom.homedecorfrontend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.homedecorfrontend.models.Category;




@Repository
public interface CategoryDAO {
// Declare all CRUD operation

	public void addCategory(Category p);
	public void updateCategory(Category p);
	public List<Category> listCategorys();
	
	public void removeCategory(int Category_id);
	
	public Category getCategoryByCategory_Id(int id);
	
}

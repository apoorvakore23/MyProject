
package com.ecom.homedecorfrontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.dao.CategoryDAO;

import com.ecom.homedecorfrontend.models.Category;

@Service
@Transactional
public class CategoryServices {
	@Autowired
	private CategoryDAO categoryDAO;
	public void addCategory(Category p) {
		
		categoryDAO.addCategory(p);
		
	}
	public void updateCategory(Category p) {
		categoryDAO.updateCategory(p);
	}
	public List<Category> listCategory() {
		System.out.println("in service");
		return categoryDAO.listCategorys();
	}
	@Transactional
	public Category getCategoryByCategory_Id(int Category_id) {
		// TODO Auto-generated method stub
		return categoryDAO.getCategoryByCategory_Id(Category_id);
	}
	@Transactional
	public void removeCategory(int Category_id) {
		categoryDAO.removeCategory(Category_id);
	}
}

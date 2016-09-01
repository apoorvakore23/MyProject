package com.ecom.homedecorfrontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.dao.ProductDAO;
import com.ecom.homedecorfrontend.models.Product;


@Service
@Transactional
public class ProductServices {
	
	@Autowired
	private ProductDAO productDAO;
	public void addProduct(Product p) {
		
		productDAO.addProduct(p);
		
	}
	public void updateProduct(Product p) {
		productDAO.updateProduct(p);
	}
	public List<Product> listProduct() {
		System.out.println("in service");
		return productDAO.listProducts();
	}
	@Transactional
	public Product getProductByProduct_Id(int product_id) {
		// TODO Auto-generated method stub
		return productDAO.getProductByProduct_Id(product_id);
	}
	@Transactional
	public void removeProduct(int product_id) {
		productDAO.removeProduct(product_id);
	}
}


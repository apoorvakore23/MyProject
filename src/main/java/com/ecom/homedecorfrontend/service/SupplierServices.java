package com.ecom.homedecorfrontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.dao.SupplierDAO;
import com.ecom.homedecorfrontend.models.Supplier;
@Service
@Transactional
public class SupplierServices {
	@Autowired
	private SupplierDAO supplierDAO;
	public void addSupplier(Supplier p) {
		
		supplierDAO.addSupplier(p);
		
	}
	public void updateSupplier(Supplier p) {
		supplierDAO.updateSupplier(p);
	}
	public List<Supplier> listSupplier() {
		System.out.println("in service");
		return supplierDAO.listSuppliers();
	}
	@Transactional
	public Supplier getSupplierBySupplier_Id(int supplier_id) {
		// TODO Auto-generated method stub
		return supplierDAO.getSupplierBySupplier_Id(supplier_id);
	}
	@Transactional
	public void removeSupplier(int supplier_id) {
		supplierDAO.removeSupplier(supplier_id);
	}
}

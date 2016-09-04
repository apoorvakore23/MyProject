package com.ecom.homedecorfrontend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.homedecorfrontend.models.Supplier;




@Repository
public interface SupplierDAO {
	public void addSupplier(Supplier p);
	public void updateSupplier(Supplier p);
	public List<Supplier> listSuppliers();
	
	public void removeSupplier(int Supplier_id);
	
	public Supplier getSupplierBySupplier_Id(int id);
}
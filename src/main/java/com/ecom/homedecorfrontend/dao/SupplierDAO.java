package com.ecom.homedecorfrontend.dao;

import java.util.List;

import com.ecom.homedecorfrontend.models.Supplier;




public interface SupplierDAO {
	public boolean save(Supplier supplier);
    public boolean update(Supplier supplier);
    public boolean delete(Supplier supplier);
    public Supplier get(String id);
    public List <Supplier> list();
}
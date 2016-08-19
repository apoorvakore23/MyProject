package com.ecom.homedecorbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.homedecorbackend.model.UserDetails;

@Repository
public interface UserDetailsDAO {
// Declare all CRUD operation
	public boolean save(UserDetails userDetails);
    public boolean update(UserDetails userDetails);
    public boolean delete(UserDetails userDetails);
    public UserDetails get(String id);
    public List <UserDetails> list();
	
	
}

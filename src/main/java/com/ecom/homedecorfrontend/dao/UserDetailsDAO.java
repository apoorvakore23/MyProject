package com.ecom.homedecorfrontend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.homedecorfrontend.models.UserDetails;



@Repository
public interface UserDetailsDAO {
// Declare all CRUD operation
	public boolean save(UserDetails userDetails);
    public boolean update(UserDetails userDetails);
    public boolean delete(UserDetails userDetails);
    public UserDetails get(String id);
    public List <UserDetails> list();
    public UserDetails isValidUser(String id,String password);
	
	
}

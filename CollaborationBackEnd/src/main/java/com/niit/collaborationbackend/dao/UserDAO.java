package com.niit.collaborationbackend.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.User;
@Repository("userDAO")
public interface UserDAO {
	
		public void addUser(User u);
		public User getUserByUserId(int id);
		 public List<User> getAllUsers();
		 public User getUserByUsername (String username);
		 public void deleteUser(User user);
		 public User Login(String username,String password);
		 public User updateUser(int id ,User user);
}

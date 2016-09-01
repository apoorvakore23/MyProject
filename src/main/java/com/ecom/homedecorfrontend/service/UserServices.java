package com.ecom.homedecorfrontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.homedecorfrontend.dao.UserDetailsDAOImpl;
import com.ecom.homedecorfrontend.models.UserDetails;


@Service
@Transactional
public class UserServices {
	@Autowired
	private UserDetailsDAOImpl userDao;

	/*public void setUserDAO(User user) {
		this.userDao = user;
	}*/

	@Transactional
	public void addUser(UserDetails u) {
		this.userDao.addUser(u);
	}


}
	
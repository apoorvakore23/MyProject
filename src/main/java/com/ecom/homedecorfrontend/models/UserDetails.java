package com.ecom.homedecorfrontend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class UserDetails {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@NotEmpty(message = "Name should not be empty")
	private String fname;
	private String lname;
	@NotEmpty(message = "User name should not be empty")
	private String userName;
	@NotEmpty(message = "password should not be empty")
	@Size(min = 6, max = 15)
	private String password;
	@NotEmpty(message = "Email address should not be empty")
	@Email(message = "Enter Valid Email address")
	private String email;
	private String contact;
	private String address;	
	
	private boolean enabled =true;
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "{UserId:'"+id+"',fname:'"+fname+"',lname:'"+lname+"',address:'"+address+"',username:'"+userName+"',email:'"+email+"',password:'"+password+"'}";
	}

	
}

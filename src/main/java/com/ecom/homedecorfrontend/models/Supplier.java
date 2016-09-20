package com.ecom.homedecorfrontend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier 
{
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@NotEmpty(message = "Name should not be empty")
	private String name;
	@NotEmpty(message = "address should not be empty")
	private String address;
	@NotEmpty(message = "Email address should not be empty")
	@Email(message = "Enter Valid Email address")
	private String emailID;
	@NotNull
	
	private int contactNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "{SupplierId:'"+id+"',Address:'"+address+"',EmailId:'"+emailID+"',Contact_No:'"+contactNo+"'}";
	}

}


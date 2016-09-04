package com.ecom.homedecorfrontend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class UserRoles {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int role_id;
private String authority;
private int uid;
public int getRole_id() {
	return role_id;
}
public void setRole_id(int role_id) {
	this.role_id = role_id;
}
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}
public int getId() {
	return uid;
}
public void setId(int uid) {
	this.uid = uid;
}


}

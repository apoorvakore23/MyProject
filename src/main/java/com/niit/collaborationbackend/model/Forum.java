package com.niit.collaborationbackend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="c_forum")
public class Forum {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int f_id;
	@NotEmpty
private String f_name;
	@NotEmpty
private String f_description;
	@NotEmpty
private String f_category;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name ="userId")
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public void setF_topic(String f_name) {
	this.f_name = f_name;
}
public int getF_id() {
	return f_id;
}
public void setF_id(int id) {
	this.f_id = id;
}
public String getF_name() {
	return f_name;
}
public void setTopic(String f_name) {
	this.f_name = f_name;
}
public String toString() {
	return String.format("{f_id:%s,f_name:%s,f_description:%s,f_category:%s,user:%s}",f_id,f_name,f_description,f_category,user);	
}
}

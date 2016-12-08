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
@Table(name="col_forum")
public class Forum {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int forum_id;
	@NotEmpty
private String forum_name;
@NotEmpty
private String forum_description;
	@NotEmpty
private String forum_category;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name ="userId")
private User user;

public int getForum_id() {
	return forum_id;
}


public void setForum_id(int forum_id) {
	this.forum_id = forum_id;
}


public String getForum_name() {
	return forum_name;
}


public void setForum_name(String forum_name) {
	this.forum_name = forum_name;
}


public String getForum_description() {
	return forum_description;
}


public void setForum_description(String forum_description) {
	this.forum_description = forum_description;
}


public String getForum_category() {
	return forum_category;
}


public void setForum_category(String forum_category) {
	this.forum_category = forum_category;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public String toString() {
	return String.format("{f_id:%s,f_name:%s,f_description:%s,f_category:%s,user:%s}",forum_id,forum_name,forum_description,forum_category,user);	
}
}

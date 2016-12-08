package com.niit.collaborationbackend.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Component
@Table(name="collab_Blog")
public class Blog {
@Id

@GeneratedValue(strategy=GenerationType.AUTO)
private int blog_id;

@NotEmpty(message="Enter valid Title")
private String blog_title;

@NotEmpty(message="write blog")
private String blog_content;

private String blog_date;

private String blog_time;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name ="userId")
private User user;
@Transient
private MultipartFile b_image;


public int getBlog_id() {
	return blog_id;
}


public void setBlog_id(int blog_id) {
	this.blog_id = blog_id;
}


public String getBlog_title() {
	return blog_title;
}


public void setBlog_title(String blog_title) {
	this.blog_title = blog_title;
}


public String getBlog_content() {
	return blog_content;
}


public void setBlog_content(String blog_content) {
	this.blog_content = blog_content;
}


public String getBlog_date() {
	return blog_date;
}


public void setBlog_date(String blog_date) {
	this.blog_date = blog_date;
}


public String getBlog_time() {
	return blog_time;
}


public void setBlog_time(String blog_time) {
	this.blog_time = blog_time;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public MultipartFile getB_image() {
	return b_image;
}


public void setB_image(MultipartFile b_image) {
	this.b_image = b_image;
}


public String toString() {
	return String.format("{blog_id:%s,blog_title:%s,blog_content:%s,blog_date:%s,blog_time:%s,blog_image:%s}",blog_id,blog_title,blog_content,blog_date,blog_time,b_image);	
}
}

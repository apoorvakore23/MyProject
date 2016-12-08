package com.niit.collaborationbackend.model;

import java.util.Date;

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
@Table(name="c_placement")
public class Placement {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int p_id;
@NotEmpty
private String p_company;
@NotEmpty
private String p_post;
@NotEmpty
private String p_location;
@NotEmpty
private String p_description;
@NotEmpty
private String p_skill_set;
private Date p_date;
//private String p_time;
private int p_salary;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name ="userId")
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
}
public String getP_company() {
	return p_company;
}
public void setP_company(String p_company) {
	this.p_company = p_company;
}
public String getP_post() {
	return p_post;
}
public void setP_post(String p_post) {
	this.p_post = p_post;
}
public String getP_location() {
	return p_location;
}
public void setP_location(String p_location) {
	this.p_location = p_location;
}
public String getP_description() {
	return p_description;
}
public void setP_description(String p_description) {
	this.p_description = p_description;
}
public String getP_skil_set() {
	return p_skill_set;
}
public void setP_skil_set(String p_skil_set) {
	this.p_skill_set = p_skil_set;
}

//public String getP_time() {
//	return p_time;
//}
//public void setP_time(String p_time) {
//	this.p_time = p_time;
//}
public int getP_salary() {
	return p_salary;
}
public String getP_skill_set() {
	return p_skill_set;
}
public void setP_skill_set(String p_skill_set) {
	this.p_skill_set = p_skill_set;
}
public Date getP_date() {
	return p_date;
}
public void setP_date(Date p_date) {
	this.p_date = p_date;
}
public void setP_salary(int p_salary) {
	this.p_salary = p_salary;
}
public String toString() {
	return String.format("{p_id:%s,p_company:%s,p_post:%s,p_location:%s,p_description:%s,p_skill_set:%s,p_date:%s,p_salary:%s}",p_id,p_company,p_post,p_location,p_description,p_skill_set,p_date,p_salary);	
}

}

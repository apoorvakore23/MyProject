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
@Table(name="c_event")
public class Event {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int e_id;
@NotEmpty(message="Please provide event title")
private String e_title;
@NotEmpty(message="Where is this event?")

private String e_venue;
@NotEmpty(message="date??")

private String e_start_date;
@NotEmpty(message="what is time?")
private String e_start_time;

@NotEmpty(message="Please describe !!")
private String e_description;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name ="userId")
private User user;

private String e_end_date;
private String e_end_time;
//@ManyToMany
//private User user;
public int getE_id() {
	return e_id;
}
//public User getUser() {
//	return user;
//}
//public void setUser(User user) {
//	this.user = user;
//}
public void setE_id(int e_id) {
	this.e_id = e_id;
}
public String getE_title() {
	return e_title;
}
public void setE_title(String e_title) {
	this.e_title = e_title;
}
public String getE_venue() {
	return e_venue;
}
public void setE_venue(String e_venue) {
	this.e_venue = e_venue;
}
public String getE_start_date() {
	return e_start_date;
}
public void setE_start_date(String e_start_date) {
	this.e_start_date = e_start_date;
}
public String getE_start_time() {
	return e_start_time;
}
public void setE_start_time(String e_start_time) {
	this.e_start_time = e_start_time;
}
public String getE_description() {
	return e_description;
}
public void setE_description(String e_description) {
	this.e_description = e_description;
}
public String getE_contact() {
	return e_contact;
}
public void setE_contact(String e_contact) {
	this.e_contact = e_contact;
}
public String getE_email() {
	return e_email;
}
public void setE_email(String e_email) {
	this.e_email = e_email;
}
public String getE_end_date() {
	return e_end_date;
}
public void setE_end_date(String e_end_date) {
	this.e_end_date = e_end_date;
}
public String getE_end_time() {
	return e_end_time;
}
public void setE_end_time(String e_end_time) {
	this.e_end_time = e_end_time;
}
@NotEmpty(message="Please provide contact")
private String e_contact;
@NotEmpty(message="Please provide email")

private String e_email;

}

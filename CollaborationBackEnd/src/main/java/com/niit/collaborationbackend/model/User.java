package com.niit.collaborationbackend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

@Entity
@Component
@Table(name="Users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
//	@OneToOne(mappedBy="UserId" , fetch=FetchType.EAGER)
	private int userId;
	
	@NotEmpty(message = "Name should not be empty")
	@Column(name = "u_name")
	private String u_name;
	
	@NotEmpty(message = "User name should not be empty")
	@Column(name = "u_username")
	private String u_username;

	@NotEmpty(message = "password should not be empty")
	//@Size(min = 6, max = 15)
	@Column(name = "u_password")
	private String u_password;
	
	@NotEmpty(message = "address should not be empty")
	@Column(name = "u_address")
	private String u_address;
	
	@Column(name = "u_gender")
	private String u_gender;
	
	@Column(name = "u_email" ,unique=true)
	@NotEmpty(message = "Email address should not be empty")
	@Email(message = "Enter Valid Email address")
	private String u_email;
	
	@Column(name = "u_contact")
	@NotEmpty
	private String u_contact;
	private String isOnline;


	@Column(name = "ImagePath")
	private String file;
	@Transient
	private MultipartFile image;

	
	@Column(name="u_DOB")	
	private String u_dob;
	public String getU_dob() {
		return u_dob;
	}

	public void setU_dob(String u_dob) {
		this.u_dob = u_dob;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	/*@Column(name="Enabled")
	boolean enabled =true;*/
	
/*@OneToMany(fetch = FetchType.EAGER ,cascade=CascadeType.ALL , mappedBy = "user")
private List<Blog> blog;
	
	public void setBlog(List<Blog> blog) {
		this.blog = blog;
	}*/

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	


	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_username() {
		return u_username;
	}

	public void setU_username(String u_username) {
		this.u_username = u_username;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_contact() {
		return u_contact;
	}

	public void setU_contact(String u_contact) {
		this.u_contact = u_contact;
	}

	

	/*public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}*/

	public String toString() {
		return String.format("{userId:%s,u_name:%s,u_username:%s,u_password:%s, u_address:%s,u_gender:%s,u_email:%s,u_contact:%s,file:%s,image:%s}",userId,u_name,u_username,u_password,u_address,u_gender,u_email,u_contact,file,image);	
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	}
// 
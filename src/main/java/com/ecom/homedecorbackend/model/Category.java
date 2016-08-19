package com.ecom.homedecorbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table  // (name="CATEGORY")  //IF TABLENAME AND DOMAIN CLASS NAME IS SAME NO NEED TO SPECIFY NAME HERE
@Component
public class Category {
	
	//id,name,description are fiels in the table
	@Id
private String id;
	@Column(name="name")//if the name of column is different from table then only specify 
	
private String name;
	@NotEmpty
	@Column(name="desc")
private String description;
@Transient
private String createdBy; //if any field is not available in table then use transient
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}

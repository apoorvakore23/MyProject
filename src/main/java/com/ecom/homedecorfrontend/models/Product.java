package com.ecom.homedecorfrontend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Product")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message = "Name should not be empty")
	private String name;
		
	@Min(1)
	@NotNull(message = "Price should not be empty")
	private int price; 
	
	@NotNull(message = "quantity should not be empty")
	private int quantity;
	
	@NotEmpty(message = "Category should not be empty")
	private String category;
	
	private String description;	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Column(name = "ImagePath")
	private String file;
	@Transient
	private MultipartFile image;
/*@Transient
	private MultipartFile storeFile;	*/
	public Product() {
	}
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
	


	public int getPrice() {
		return price;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "{id:'"+id+"',name:'"+name+"',price:'"+price+"',description:'"+description+"',quantity:'"+quantity+"',category:'"+category+"',image:'"+image+"',file:'"+file+"'}";
	}

}

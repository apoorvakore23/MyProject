package com.ecom.homedecorfrontend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	@NotEmpty(message = "Name should not be empty")
	private String name;
	@Column	
	@Min(1)
	@NotNull(message = "Price should not be empty")
	private int price; 
	@Column
	@NotNull(message = "quantity should not be empty")
	private int quantity;
	@Column
	@NotEmpty(message = "Category should not be empty")
	private String category;
	@Column
	private String description;	
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
		return "{ProductID:'"+id+"',name:'"+name+"',Price:'"+price+"',Product_Description:'"+description+"',Product_Category:'"+category+"'}";
	}

}

package com.project.Productservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document
public class ProductModel {

	@Id
	@NonNull
	private String name;
	@NonNull
	private String price;
	@NonNull
	private String description;
	@NonNull
	private String quantity;
	
	public ProductModel() {
		
	}
	public ProductModel(String name, String price, String description, String quantity) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductModel [name=" + name + ", price=" + price + ", description=" + description + ", quantity="
				+ quantity + "]";
	}
	
	
	
}

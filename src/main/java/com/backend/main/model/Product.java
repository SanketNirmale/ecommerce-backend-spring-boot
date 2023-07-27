package com.backend.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private Long id;
	
	@Column(name = "p_name")
	private String name;
	
	@Column(name = "p_desc")
	private String description;

	@Column(name = "p_brand")
	private String brand;

	@Column(name = "p_img")
	private String image;

	@Column(name="color")
	private String color;
	@Column(name = "p_price")
	private double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product( String name, String description, String brand, String image, String color, double price) {
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.image = image;
		this.color = color;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", brand=" + brand + ", image="
				+ image + ", color=" + color + ", price=" + price + "]";
	}
}
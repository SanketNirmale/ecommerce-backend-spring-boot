package com.backend.main.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id",referencedColumnName = "userId")
	private User user;

	private String addr;
	
	@Column(name="total")
	private double total;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;

	// Constructors, getters, and setters
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order( User user, double total, List<OrderItem> orderItems, String addr) {
		this.user = user;
		this.total = total;
		this.orderItems = orderItems;
		this.addr = addr;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
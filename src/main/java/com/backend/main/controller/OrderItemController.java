package com.backend.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.backend.main.model.OrderItem;
import com.backend.main.repo.OrderItemRepository;

import java.util.List;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

	@Autowired
	private OrderItemRepository repo;

	// Get all order items
	@GetMapping("/get")
	public List<OrderItem> getAllOrderItems() {
		return repo.findAll();
	}

	// Get a specific order item by ID
	@GetMapping("/get/{id}")
	public OrderItem getOrderItemById(@PathVariable("id") Long id) {
		return repo.findById(id).orElse(null);
	}

	// Create a new order item
	@PostMapping("/add")
	public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
		return repo.save(orderItem);
	}
}

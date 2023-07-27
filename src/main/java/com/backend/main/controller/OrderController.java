package com.backend.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.main.model.Order;
import com.backend.main.repo.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    // Get all orders
    @GetMapping("/get")
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    // Get a specific order by ID
    @GetMapping("/get/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return repo.findById(id).orElse(null);
    }

    // Create a new order
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return repo.save(order);
    }

    // Update an existing order
    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable("id") Long id, @RequestBody Order updatedOrder) {
        Order order = repo.findById(id).orElse(null);
        if (order != null) {
            order.setUser(updatedOrder.getUser());
            order.setAddr(updatedOrder.getAddr());
            order.setTotal(updatedOrder.getTotal());
            return repo.save(order);
        }
        return null;
    }

    // Delete an order
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        Order order = repo.findById(id).orElse(null);
        if (order != null) {
            repo.delete(order);
        }
    }
}
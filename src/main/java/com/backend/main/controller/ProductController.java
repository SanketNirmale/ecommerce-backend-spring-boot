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

import com.backend.main.model.Product;
import com.backend.main.repo.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Get all products
    @GetMapping("/get")
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // Get a specific product by ID
    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return repo.findById(id).orElse(null);
    }

    // Create a new product
    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return repo.save(product);
    }
    @PostMapping("/addMany")
	public List<Product> createProducts(@RequestBody List<Product> product) {
		return repo.saveAll(product);
	}
    // Update an existing product
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
        Product product = repo.findById(id).orElse(null);
        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setImage(updatedProduct.getImage());
            product.setPrice(updatedProduct.getPrice());
            return repo.save(product);
        }
        return null;
    }

    // Delete a product
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        Product product = repo.findById(id).orElse(null);
        if (product != null) {
            repo.delete(product);
        }
    }
}


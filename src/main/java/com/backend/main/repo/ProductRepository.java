package com.backend.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.main.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

package com.backend.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.main.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}

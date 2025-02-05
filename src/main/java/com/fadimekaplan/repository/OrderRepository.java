package com.fadimekaplan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fadimekaplan.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
    List<Order> findByCustomerId(Integer customerId);
    
	Optional<Order> findByordercode(String ordercode);
    
    
}
package com.fadimekaplan.repository;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fadimekaplan.entities.Cart; 

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	  Cart findByCustomerId(Integer customerId);
}
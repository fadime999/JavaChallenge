package com.fadimekaplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fadimekaplan.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
}

package com.fadimekaplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fadimekaplan.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
}

package com.fadimekaplan.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderItem", schema = "enocajava")
public class OrderItem extends BaseEntity {
	
    @ManyToOne
	@JsonBackReference("orderReference")  
    @JoinColumn(name = "order_id")
    private Order order;
    
    @OneToOne
	@JsonBackReference("orderItemReference")  
    @JoinColumn(name = "product_id")
    private Product product;
    
    private Integer quantity;
    private Integer priceAtPurchase;
    
    public OrderItem(Product product, Integer priceAtPurchase, Integer quantity) {
        this.product = product;
        this.priceAtPurchase = priceAtPurchase;
        this.quantity = quantity;
    }
}

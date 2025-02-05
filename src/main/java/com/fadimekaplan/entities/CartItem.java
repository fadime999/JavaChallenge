package com.fadimekaplan.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CartItem", schema = "enocajava")
public class CartItem extends BaseEntity {

	  @ManyToOne
	  @JoinColumn(name = "product_id")
	  private Product product;
	  
	  @JsonManagedReference("cartItemReference")
	  @ManyToOne
	  @JoinColumn(name = "cart_id")
	  private Cart cart;
	  
	  @Column(name="Quantity")
	  private Integer Quantity;

}

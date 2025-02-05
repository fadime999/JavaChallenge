package com.fadimekaplan.entities;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product", schema = "enocajava")
public class Product extends BaseEntity{

	@Column(name="ProductName")
	private String productName;
	
	@Column(name="Price")
    private Integer price;
    
	@Column(name="StockQuantity")
    private Integer stockQuantity;
	
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference("orderItemReference")
    private OrderItem orderItem;
     
	
}

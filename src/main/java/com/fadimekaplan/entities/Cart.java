package com.fadimekaplan.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name = "Cart", schema = "enocajava")
public class Cart extends BaseEntity{

	@Column(name="TotalPrice")
    private double TotalPrice;
	
	@JsonBackReference("cartReference")  
    @OneToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;
	
	@JsonBackReference("cartItemReference")  
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;
    
}

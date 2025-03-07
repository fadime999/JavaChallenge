package com.fadimekaplan.entities;
 
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Order", schema = "enocajava")
public class Order extends BaseEntity{
	
	@Column(name="ordercode")
    private String ordercode;
	
	@Column(name="TotalPrice")
    private double TotalPrice;
    
    @ManyToOne
	@JsonBackReference("customerReference")  
    @JoinColumn(name = "CustomerId")
    private Customer customer;
    
	@JsonManagedReference("orderReference")  
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}

package com.fadimekaplan.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer", schema = "enocajava")
public class Customer extends BaseEntity{
	
	@Column(name="UserName")
	private String UserName;
	
	@Column(name="Mail")
	private String Mail;
	
	@JsonManagedReference("cartReference")
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
	private Cart cart;
	
	@JsonBackReference("customerReference")  
    @OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
	
	
}

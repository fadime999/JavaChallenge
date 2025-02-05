package com.fadimekaplan.dto;

import java.util.List;

import com.fadimekaplan.entities.BaseEntity;
import com.fadimekaplan.entities.Cart;
import com.fadimekaplan.entities.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
@Getter
@Setter
public class DTOCustomer extends BaseEntity{
	
	private String UserName;
	
	private String Mail;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
	private Cart cart;
	
    @OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
	
	
}

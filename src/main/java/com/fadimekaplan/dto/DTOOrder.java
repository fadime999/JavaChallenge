package com.fadimekaplan.dto;

import java.util.List;

import com.fadimekaplan.entities.BaseEntity;
import com.fadimekaplan.entities.Customer;
import com.fadimekaplan.entities.OrderItem;

 
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
@Getter
@Setter
public class DTOOrder extends BaseEntity{

    private String ordercode;
	
    private double TotalPrice;
 
    private Customer customer;
    
    private List<OrderItem> orderItems;
	
}

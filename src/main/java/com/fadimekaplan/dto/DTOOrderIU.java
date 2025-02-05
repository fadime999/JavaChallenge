package com.fadimekaplan.dto;

import com.fadimekaplan.entities.BaseEntity;
import com.fadimekaplan.entities.Customer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
@Getter
@Setter
public class DTOOrderIU extends BaseEntity{

    private String ordercode;

    private double TotalPrice;

    private Customer customer;
}

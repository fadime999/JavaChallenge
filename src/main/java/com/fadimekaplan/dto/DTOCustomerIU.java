package com.fadimekaplan.dto;

import com.fadimekaplan.entities.BaseEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
@Getter
@Setter
public class DTOCustomerIU extends BaseEntity{
	
	private String UserName;
	
	private String Mail;
}

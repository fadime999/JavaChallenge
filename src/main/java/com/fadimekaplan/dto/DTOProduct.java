package com.fadimekaplan.dto;


import com.fadimekaplan.entities.BaseEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
@Getter
@Setter
public class DTOProduct extends BaseEntity {
	
	private String productName;
	
    private Integer price;
    
    
}

package com.fadimekaplan.services;

import com.fadimekaplan.dto.DTOCustomer;
import com.fadimekaplan.dto.DTOCustomerIU;
 

public interface ICustomerService {
	
	DTOCustomer addCustomer(DTOCustomerIU customer);
	
}

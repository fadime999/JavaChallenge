package com.fadimekaplan.services;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fadimekaplan.dto.DTOCustomer;
import com.fadimekaplan.dto.DTOCustomerIU;
import com.fadimekaplan.entities.Customer;
import com.fadimekaplan.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService{
	
	 @Autowired
	 private CustomerRepository customerRepository;
	 
	 public DTOCustomer addCustomer(DTOCustomerIU dtoCustomer) {
		 Customer customer = new Customer();
		 DTOCustomer responseCust = new DTOCustomer();
		 BeanUtils.copyProperties(dtoCustomer, customer);
		 
		 Customer dbcustomer = customerRepository.save(customer);
		 BeanUtils.copyProperties(dbcustomer, responseCust);
	      return responseCust;
	 }
	 
	 
}

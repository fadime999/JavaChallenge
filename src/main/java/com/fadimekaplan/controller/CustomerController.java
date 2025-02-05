package com.fadimekaplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fadimekaplan.dto.DTOCustomer;
import com.fadimekaplan.dto.DTOCustomerIU;
import com.fadimekaplan.entities.Customer;
import com.fadimekaplan.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	 
	@Autowired
	 private CustomerService customerService;
	
    @PostMapping
    public DTOCustomer addCustomer(@RequestBody DTOCustomerIU dtoCustomer) {
        return customerService.addCustomer(dtoCustomer);
    }
}

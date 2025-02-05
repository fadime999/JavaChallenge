package com.fadimekaplan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fadimekaplan.dto.DTOOrder;
import com.fadimekaplan.entities.Order;
import com.fadimekaplan.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/place/{customerId}")
    public DTOOrder placeOrder(@PathVariable Integer customerId) {
        return orderService.placeOrder(customerId);
    }
    
    @GetMapping("/{orderCode}")
    public DTOOrder getOrderForCode(@PathVariable String orderCode) {
        return orderService.getOrderForCode(orderCode);
    }

    @GetMapping("/customer/{customerId}")
    public List<DTOOrder> E(@PathVariable Integer customerId) {
        return orderService.getAllOrdersForCustomer(customerId);
    }
}

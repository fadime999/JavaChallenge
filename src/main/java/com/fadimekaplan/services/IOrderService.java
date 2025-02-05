package com.fadimekaplan.services;

import java.util.List;

import com.fadimekaplan.dto.DTOOrder;

public interface IOrderService {
	
    DTOOrder placeOrder(Integer customerId);
	DTOOrder getOrderForCode(String orderCode);
	List<DTOOrder> getAllOrdersForCustomer(Integer CustomerId);
	
}

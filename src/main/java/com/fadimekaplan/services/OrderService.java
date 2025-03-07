package com.fadimekaplan.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fadimekaplan.dto.DTOOrder;
import com.fadimekaplan.entities.Cart;
import com.fadimekaplan.entities.CartItem;
import com.fadimekaplan.entities.Order;
import com.fadimekaplan.entities.OrderItem;
import com.fadimekaplan.entities.Product;
import com.fadimekaplan.repository.CartRepository;
import com.fadimekaplan.repository.OrderRepository;
 
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;
 
    
    public DTOOrder placeOrder(Integer customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
      
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new RuntimeException("Not enough stock for product " + product.getProductName());
            }
            orderItems.add(new OrderItem(product, product.getPrice(), item.getQuantity()));
        }
        
        String orderCode = "ORD-" + System.currentTimeMillis();
        Order order = new Order();
        order.setCreatedDate(LocalDateTime.now());
        order.setUpdatedDate(LocalDateTime.now());

        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrice());
        order.setOrdercode(orderCode);
        order.setOrderItems(orderItems.stream()
                .map(item -> new OrderItem(item.getProduct(), item.getPriceAtPurchase(), item.getQuantity()))
                .collect(Collectors.toList())); 
        
        orderRepository.save(order);
        
        // DTO'ya dönüştürme
        DTOOrder dtoOrder = new DTOOrder();
        BeanUtils.copyProperties(order, dtoOrder);
        
        return dtoOrder;

    }
    
    public DTOOrder getOrderForCode(String ordercode) {
    	DTOOrder dto_order = new DTOOrder();
        Order order = orderRepository.findByordercode(ordercode)
                .orElseThrow(() -> new RuntimeException("Order not found")); 
        BeanUtils.copyProperties(order, dto_order);
        return dto_order;
    }
    
    public List<DTOOrder> getAllOrdersForCustomer(Integer CustomerId) {
    	 List<DTOOrder> dtoOrderList = new ArrayList<>();
    	 
    	 List<Order> orders = orderRepository.findByCustomerId(CustomerId); 

    	 for (Order order : orders) {
			DTOOrder dto_Order = new DTOOrder();
			BeanUtils.copyProperties(order, dto_Order);
			dtoOrderList.add(dto_Order);
		}
        return dtoOrderList;
    }
}

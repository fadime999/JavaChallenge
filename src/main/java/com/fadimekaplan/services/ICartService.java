package com.fadimekaplan.services;

import com.fadimekaplan.entities.Cart;

public interface ICartService {
	
	Cart getCart(Integer customerId); 
	Cart updateCart(Integer customerId, Cart cart);
	void emptyCart(Integer customerId);
	Cart  addProductToCart(Integer customerId, Integer productId, Integer quantity);
	Cart removeProductFromCart(Integer customerId, Integer productId);
	Cart getCartByCustomerId(Integer customerId);
}

package com.fadimekaplan.services;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fadimekaplan.entities.Cart;
import com.fadimekaplan.entities.CartItem;
 
import com.fadimekaplan.entities.Product;
import com.fadimekaplan.repository.CartRepository;
import com.fadimekaplan.repository.ProductRepository;

@Service
public class CartService implements ICartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	public Cart getCart(Integer customerId) {
		return cartRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cart not found"));
	}

	public Cart updateCart(Integer customerId, Cart cart) {
		Cart existingCart = cartRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Cart not found"));
		existingCart.setTotalPrice(cart.getTotalPrice());
		existingCart.setCartItems(cart.getCartItems());
		return cartRepository.save(existingCart);
	}

	public void emptyCart(Integer customerId) {
		Cart cart = cartRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cart not found"));

		cart.getCartItems().clear();
		cartRepository.save(cart);
	}

	public Cart  addProductToCart(Integer customerId, Integer productId, Integer quantity) {
		Cart cart = cartRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cart not found"));

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product not found"));

		cart.getCartItems().add(new CartItem(product, cart, quantity));
		return cartRepository.save(cart);
	}

	public Cart removeProductFromCart(Integer customerId, Integer productId) {
		Cart cart = cartRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cart not found"));

		boolean productFound = cart.getCartItems().removeIf(item -> item.getProduct().getId().equals(productId));

		if (!productFound) {
			throw new IllegalArgumentException("Product with ID " + productId + " not found in the cart.");
		}
		return cartRepository.save(cart);
	}

    public Cart getCartByCustomerId(Integer customerId) {
	    return cartRepository.findByCustomerId(customerId);
    }
}

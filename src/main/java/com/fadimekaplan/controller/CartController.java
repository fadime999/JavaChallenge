package com.fadimekaplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fadimekaplan.entities.Cart;
import com.fadimekaplan.services.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	   @Autowired
	   private CartService cartService;
	   
	    @PostMapping("/{cartId}/add/{productId}")
	    public ResponseEntity<Cart> addProductToCart(@PathVariable Integer cartId, @PathVariable Integer productId, @RequestBody Integer quantity) {
	    	  Cart updatedCart = cartService.addProductToCart(cartId, productId, quantity);
	    	  return ResponseEntity.ok(updatedCart); 
	    }
 
	    @DeleteMapping("/{customerId}/remove/{productId}")
	    public Cart removeProductFromCart(@PathVariable Integer customerId, @PathVariable Integer productId) {
	        return cartService.removeProductFromCart(customerId, productId);
	    }

	    @GetMapping("/{customerId}")
	    public Cart getCart(@PathVariable Integer customerId) {
	        return cartService.getCartByCustomerId(customerId);
	    }

	    @PutMapping("/update/{customerId}")
	    public ResponseEntity<Cart> updateCart(@PathVariable Integer customerId, @RequestBody Cart cart) {
	    	Cart updatedCart = cartService.updateCart(customerId, cart);
	    	return ResponseEntity.ok(updatedCart);  
	    }


	    @DeleteMapping("delete/{customerId}")
	    public void emptyCart(@PathVariable Integer customerId) {
	        cartService.emptyCart(customerId);
	    }
}

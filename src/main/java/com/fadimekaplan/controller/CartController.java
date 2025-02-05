package com.fadimekaplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	   
	    @PostMapping("/{customerId}/add/{productId}")
	    public Cart addProductToCart(@PathVariable Integer customerId, @PathVariable Integer productId, @RequestParam Integer quantity) {
	        return cartService.addProductToCart(customerId, productId, quantity);
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
	    public Cart updateCart(@PathVariable Integer customerId, @RequestBody Cart cart) {
	        return cartService.updateCart(customerId, cart);
	    }


	    @DeleteMapping("delete/{customerId}")
	    public void emptyCart(@PathVariable Integer customerId) {
	        cartService.emptyCart(customerId);
	    }
}

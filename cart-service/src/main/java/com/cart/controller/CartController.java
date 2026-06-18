package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.entity.Cart;
import com.cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<Cart> getCartByUserId(@PathVariable("userId") String userId)
	{
		return ResponseEntity.ok(cartService.getCartByUserId(userId));
	}
	
	@PostMapping
	public ResponseEntity<Cart> createCarts(@RequestBody Cart cart)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.createCart(cart));
	}
	
	@GetMapping
	public ResponseEntity<Cart> getCartByCartId(String cartId)
	{
		return ResponseEntity.ok(cartService.getCartById(cartId));
	}

}

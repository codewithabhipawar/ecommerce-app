package com.cart.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.entity.Cart;
import com.cart.entity.Product;
import com.cart.exceptions.ResourceNotFoundException;
import com.cart.externalservices.ProductService;
import com.cart.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductService productService;
	
	
	//cartId
	public Cart getCartById(String cartId)throws ResourceNotFoundException
	{
		return cartRepository
				.findById(cartId)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found for this id: "+cartId));
	}
	
	//userId;
	public Cart getCartByUserId(String userId)
	{
		Cart cart = cartRepository.findByUserId(userId);
		List<Product> products = productService.getProductByUserId(userId);
		cart.setProducts(products);
		return cart;
	}
	
	//create cart
	public Cart createCart(Cart cart)
	{
		return cartRepository.save(cart);
	}
}

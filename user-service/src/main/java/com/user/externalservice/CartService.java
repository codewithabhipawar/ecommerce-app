package com.user.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.entity.Cart;

@FeignClient(name = "CART-SERVER", path = "/cart")
public interface CartService {
	
	@GetMapping("/user/{userId}")
	Cart getCartByUserId(@PathVariable("userId") String userId);

}

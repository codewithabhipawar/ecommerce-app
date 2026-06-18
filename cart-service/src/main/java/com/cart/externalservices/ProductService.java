package com.cart.externalservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cart.entity.Product;

@FeignClient(name = "PRODUCT-SERVICE",path = "/product")
public interface ProductService {
	
	@GetMapping("/users/{userId}")
	List<Product> getProductByUserId(@PathVariable("userId") String userId);
	
}

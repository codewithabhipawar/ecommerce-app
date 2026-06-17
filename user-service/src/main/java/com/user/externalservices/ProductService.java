package com.user.externalservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.entity.Product;

@FeignClient(name = "PRODUCT-SERVICE",path = "/product")
public interface ProductService {
	
	@GetMapping("/users/{userId}")
	List<Product> getProducts(@PathVariable("userId") String userId);

}

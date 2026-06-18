package com.user.externalservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.entity.Order;

@FeignClient(name = "ORDER-SERVICE",path = "/orders")
public interface OrderService {
	
	@GetMapping("/users/{userId}")
	List<Order> getOrder(@PathVariable("userId") String userId);

}

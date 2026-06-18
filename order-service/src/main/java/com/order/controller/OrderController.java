package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//create
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
	}
	
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable("orderId") int orderId)
	{
		Order deleteOrder = orderService.deleteOrder(orderId);
		System.out.println(deleteOrder);
		return ResponseEntity.ok("user deleted successfully");
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getListOfOrders()
	{
		return ResponseEntity.ok(orderService.getOrders());
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderByOrderId(@PathVariable("orderId") int orderId)
	{
		return ResponseEntity.ok(orderService.getSingleOrder(orderId));
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Order>> getListOfUsersByUserId(@PathVariable("userId") String userId)
	{
		return ResponseEntity.ok(orderService.getOrderListByUserId(userId));
	}
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<Order> orderByCartId(@PathVariable("cartId") String cartId)
	{
		return ResponseEntity.ok(orderService.getOrderByCartId(cartId));
	}

}

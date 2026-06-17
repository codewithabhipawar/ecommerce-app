package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.exception.ResourceNotFoundException;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	//single order by id
	public Order getSingleOrder(int orderId)throws ResourceNotFoundException
	{
		return orderRepository
				.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found in this for given id: "+orderId));
	}
	
	//find by cart id
	public Order getOrderByCartId(String cartId)
	{
		return orderRepository.findByCartId(cartId);
	}
	
	//find orders by user id
	public List<Order> getOrderListByUserId(String userId)
	{
		return orderRepository.findByUserId(userId);
	}
	
	
	//create order
	public Order createOrder(Order order)
	{
		return orderRepository.save(order);
	}
	
	//delete order
	public Order deleteOrder(int orderId)
	{
		Order order = orderRepository.findById(orderId).get();
		orderRepository.delete(order);
		return order;
	}
}

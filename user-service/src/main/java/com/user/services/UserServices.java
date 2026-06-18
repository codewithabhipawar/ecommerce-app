package com.user.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Cart;
import com.user.entity.Order;
import com.user.entity.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.externalservice.CartService;
import com.user.externalservice.OrderService;
import com.user.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<User> getAllUser()
	{
		return userRepo.findAll();
	}
	
	public User createUser(User user)
	{
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		return userRepo.save(user);
	}
	
	public User getById(String userId) throws ResourceNotFoundException
	{
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
//		Cart cart = cartService.getCartByUserId(userId);
		List<Order> orders = orderService.getOrder(userId);
		
//		user.setCart(cart);
		user.setOrders(orders);
		return user;
	}
	
	public User updateUser(User user)
	{
		User user2 = userRepo.findById(user.getUserId()).get();
		user2.setEmail(user.getEmail());
		user2.setName(user.getName());
		user2.setAbout(user.getAbout());
		userRepo.save(user2);
		
		return user2;	
	}
	
	public User deleteUser(String userId)
	{
		User user = userRepo.findById(userId).get();
		userRepo.delete(user);
		
		return user;
	}

}

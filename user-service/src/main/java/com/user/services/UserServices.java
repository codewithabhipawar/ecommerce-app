package com.user.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Product;
import com.user.entity.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.externalservices.ProductService;
import com.user.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductService productService;
	
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
		//
		
//		Order order = restTemplate.getForObject("", Order.class);
//		user.setOrders(order);
//		Product[] products = restTemplate.getForObject("http://localhost:8082/product/users/"+user.getUserId(), Product[].class);
//		List<Product> collect = Arrays.stream(products).collect(Collectors.toList());
//		user.setProducts(collect);
		
		List<Product> products = productService.getProducts(userId);
		user.setProducts(products);
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

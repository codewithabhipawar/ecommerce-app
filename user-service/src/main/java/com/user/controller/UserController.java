package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices service;
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return service.getAllUser();
	}
	
	@GetMapping("/user/{userId}")
	public User usersGetById(@PathVariable("userId") String userId)
	{
		return service.getById(userId);
	}
	
	@PostMapping("/user")
	public User saveUser(User user)
	{
		return service.createUser(user);
	}
	
	@PutMapping("/user/update")
	public User userUpdate(User user)
	{
		return service.updateUser(user);
	}
	
	@DeleteMapping("/user/{userId}")
	public User deleteUser(@PathVariable("userId") String userId)
	{
		return service.deleteUser(userId);
	}

}

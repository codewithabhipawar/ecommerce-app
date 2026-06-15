package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices service;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		return ResponseEntity.ok(service.getAllUser());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> usersGetById(@PathVariable("userId") String userId)
	{
		return ResponseEntity.ok(service.getById(userId));
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<User> userUpdate(User user)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(user));
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") String userId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.deleteUser(userId));
	}

}

package com.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUser()
	{
		return userRepo.findAll();
	}
	
	public User createUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User getById(String userId) throws ResourceNotFoundException
	{
		return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
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

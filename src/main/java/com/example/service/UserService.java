package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepo;

@Service
public class UserService {

	
	@Autowired
	UserRepo userRepo;
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public User loginUser(User user) {
		
		return userRepo.login(user.getUserName(), user.getPassword());
	}
}

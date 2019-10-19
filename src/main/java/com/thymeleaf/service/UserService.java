package com.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleaf.domain.User;
import com.thymeleaf.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

}

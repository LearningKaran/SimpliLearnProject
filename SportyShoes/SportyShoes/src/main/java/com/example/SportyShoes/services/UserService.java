package com.example.SportyShoes.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportyShoes.entities.User;
import com.example.SportyShoes.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Iterable<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User getUserByName(String name)
	{
		User user=userRepository.findByName(name);
		
		if(user==null)
		{
			throw new RuntimeException("User Not Found!!");
		}
		
		return user;
	}
	
	public boolean confirmUserPassword(User user, String password)
	{
		if(user.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	
}

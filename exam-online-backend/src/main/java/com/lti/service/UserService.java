/*package com.lti.service;

import java.util.Base64;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.User;
import com.lti.exception.UserServiceException;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int register(User user) {
		if(userRepository.isUserPresent(user.getEmail()))
			throw new UserServiceException("User already registered");
		else {
			user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
			user.setPassword(user.getPassword());
			User newUser = (User) userRepository.save(user);
			//EmailIntegration
			return newUser.getId();
		}
	}
	
	public User login(String email, String password) {
		try {
			password = Base64.getEncoder().encodeToString(password.getBytes());
			int id = userRepository.fetchIdByEmailAndPassword(email, password);
			User user = userRepository.fetch(User.class, id);
			return user;
		}
		catch(EmptyResultDataAccessException e) {
			throw new UserServiceException("Invalid email id and password");
		}
	} 
}*/

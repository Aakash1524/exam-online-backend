package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.RegisterStatus;
import com.lti.entity.User;
import com.lti.exception.UserServiceException;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public RegisterStatus register(@RequestBody User user) {
		try {
			int id = userService.register(user);
			RegisterStatus status = new RegisterStatus();
			status.setMessage("Registration successful");
			status.setStatus(true);
			status.setRegisteredUserId(id);
			return status;
		}
		catch(UserServiceException e){
			RegisterStatus status = new RegisterStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;	
		}
	}
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		try {
			User user = userService.login(login.getEmail(), login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(true);
			status.setMessage("Login Successful");
			status.setName(user.getFirstName()+" "+user.getLastName());
			status.setUserId(user.getId());
			return status;
		}
		catch(UserServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}

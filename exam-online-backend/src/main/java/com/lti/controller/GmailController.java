package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GmailController {
	
	@Autowired
	private MailSender mailSender;
	
	@RequestMapping("/gmail")
	public String gmail() {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("");
		message.setTo("");
		message.setSubject("Test Mail");
		message.setText("Hi Hi Hi");
		mailSender.send(message);
		
		return "Welcome to Spring REST";
	}
	
}

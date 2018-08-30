package com.cg.SendMail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.SendMail.model.User;
import com.cg.SendMail.service.NotificationService;

@RestController
public class SimpleEmailController {
    
	@Autowired
    private NotificationService service;
	
	@RequestMapping("/signup")
    public String signup() {
        return "PLease sign up for out service";
    }
    
    @RequestMapping("/signup-success")
    public String signupSuccess() {
    	
    	User user = new User();
    	user.setFirstName("Deepraj");
    	user.setLastName("Adhikary");
    	user.setEmailAddress("demomailspringboot@gmail.com");
    	
    	try {
    		service.sendNotification(user);
    	}catch(MailException e) {
    		System.err.println(e.getMessage());
    	}
    	
    	return "Thank you for signing up with our service";
    }
    
    
}
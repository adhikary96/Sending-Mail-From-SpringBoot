package com.cg.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mail.bean.User;
import com.cg.mail.service.emailService;

@RestController
public class EmailController {
	@Autowired
	private emailService emailService;
@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signUp()
	
	{
		return "sigup first";
	}
@RequestMapping("/signup-success")
public String signUpSuccess()
{
	User user=new User();
	user.setFirstName("nirupama");
	user.setLastName("bhupathi");
	user.setEmailaddress("nirupamabhupathi19@gmail.com");
	try
	{
		emailService.sendNotification(user);
	}catch(MailException e)
	{
		//
	}
	return "success";
}
}

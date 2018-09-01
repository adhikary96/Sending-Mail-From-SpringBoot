package com.cg.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cg.mail.bean.User;

@Service
public class emailService {
	private JavaMailSender javaMailSender;
	@Autowired
	public emailService(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
		
	}
	public void sendNotification(User user)
	{
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setTo(user.getEmailaddress());
		simpleMailMessage.setFrom("shyamkishan.1996@gmail.com");
		simpleMailMessage.setSubject("proj email");
		simpleMailMessage.setText("parallel proj email test");
		
		javaMailSender.send(simpleMailMessage);
	}

}

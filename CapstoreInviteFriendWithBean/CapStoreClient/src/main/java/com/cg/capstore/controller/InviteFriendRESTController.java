package com.cg.capstore.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;



@RestController
public class InviteFriendRESTController {
	
	@RequestMapping(value="/")
	public String testController() {
		return "<<< REST CONTROLLER OF JSP IS RUNNING <br/> PORT NO 5500>>>";
	}
	
	/*@RequestMapping(value="/sendMail", method=RequestMethod.GET)
	public String sendInvitation(String customerName, String password, String friendEmail, ModelMap map) throws MessagingException {
		RestTemplate template = new RestTemplate();
		String customerEmail = service.inviteFriend(customerName);
		
		sendEmail(friendEmail, customerEmail);
		
		return "Success!! Sent to "+friendEmail;
	}*/
	
	@RequestMapping(value="/sendMail", method=RequestMethod.GET)
	public ModelMap sendInvitation(String customerMail, String password, String friendEmail, ModelMap map) throws MessagingException {
		System.err.println("IN JSP REST CONTROLLER");
		System.err.println(customerMail+"  "+password +"  "+friendEmail);
		RestTemplate template = new RestTemplate();
		StoreTempData data = new StoreTempData();
		data.setCustomerMail(customerMail);
		data.setPassword(password);
		data.setFriendEmail(friendEmail);
		System.err.println("Sent Data..."+data);
		StoreTempData reply = template.postForObject("http://localhost:5501/mailNow", data, StoreTempData.class); 
		String result="Success!!! <br/>Invitation Has been sent to your friend "+reply.getFriendEmail();
		map.put("message", result);
		return map;
	}
	
	/*private void sendEmail(String friendEmail, String customerEmail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
						
		//helper.setFrom(customerEmail);
		helper.setTo(friendEmail);
		helper.setSubject("Test Mail Dynamic");
		helper.setText("Test Text...");
		
		sender.send(message);
	}*/
	
	
	
}

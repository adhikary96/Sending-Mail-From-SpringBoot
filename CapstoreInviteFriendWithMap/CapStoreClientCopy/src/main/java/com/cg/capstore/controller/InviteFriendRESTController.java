package com.cg.capstore.controller;

import java.util.HashMap;
import java.util.Map;

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
		
	@RequestMapping(value="/sendMail", method=RequestMethod.GET)
	public ModelMap sendInvitation(String customerMail, String password, String friendEmail, ModelMap map) throws MessagingException {
		System.err.println("IN JSP REST CONTROLLER");
		System.err.println(customerMail+"  "+password +"  "+friendEmail);
		
		RestTemplate template = new RestTemplate();
		
		/*StoreTempData data = new StoreTempData();
		data.setCustomerMail(customerMail);
		data.setPassword(password);
		data.setFriendEmail(friendEmail);*/
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("customerEmail", customerMail);
		data.put("password", password);
		data.put("friendEmail", friendEmail);
		
		System.err.println("Sent Data..."+data);
		Map<String, String> reply = template.postForObject("http://localhost:5501/mailNow", data, Map.class); 
		String result="Success!!! Invitation Has been sent to your friend "+reply.get("friendEmail");
		map.put("message", result);
		return map;
	}
	
	
	
}

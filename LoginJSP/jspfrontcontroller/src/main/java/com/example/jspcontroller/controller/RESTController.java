package com.example.jspcontroller.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.jspcontroller.beans.LoginData;

@RestController
public class RESTController {
	
	@RequestMapping(value="/")
	public String testController() {
		return "<<< REST CONTROLLER OF JSP IS RUNNING >>>";
	}
	
	
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public ModelMap fromLoginPage(String username, String password, ModelMap map) {
		System.err.println("IN JSP-REST-CONTROLLER Prot:5501");
		RestTemplate restTemplate = new RestTemplate();
		LoginData data = new LoginData();
		data.setUsername(username);
		data.setPassword(password);
		System.out.println("Login Data:"+data);
		LoginData d = restTemplate.postForObject("http://localhost:5500/saveData",data,LoginData.class);
		System.err.println("IN JSP-REST-CONTROLLER Prot:5501 RECEIVED DATA OBJECT...");
		map.put("LoginData", d);
		System.err.println("IN JSP-REST-CONTROLLER Prot:5501 PUT INTO MAP MODELMAP AND RETURNING MODELMAP");
		return map;
	}

}

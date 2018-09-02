package com.example.backcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.backcontroller.beans.LoginData;
import com.example.backcontroller.repo.BackRepo;
import com.example.backcontroller.service.BackService;

@RestController
public class BackController {
	
	@Autowired
	private BackService service = new BackService();
	
	@RequestMapping(value="/")
	public String testController() {
		return "<<< BACK REST CONTROLLER IS RUNNING >>>";
	}
	
	@RequestMapping(value="/saveData", method=RequestMethod.POST)
	public LoginData saveData(@RequestBody LoginData data) {
		System.err.println("IN BACKEND-REST-CONTROLLER Prot:5500");
		service.saveDataRepo(data);
		System.err.println("OUT BACK-REST-CONTROLLER Prot:5500\n RETURNING DATA OBJECT");
		return data;
	}

}

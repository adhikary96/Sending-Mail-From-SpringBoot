package com.example.backcontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backcontroller.beans.LoginData;
import com.example.backcontroller.repo.BackRepo;

@Service
public class BackService {
	
	@Autowired
	private BackRepo repo;
	
	public LoginData saveDataRepo(LoginData d) {
		repo.save(d);
		return d;
	}
	
}

package com.cg.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.repo.IInviteFriendRepo;

@Service
public class InviteFriendServiceImpl implements IInviteFriendService{
	
	@Autowired
	private IInviteFriendRepo repo;

	@Override
	public CustomerBean inviteFriend(String customerName) {
		// TODO Auto-generated method stub
		return repo.getCustomerEmail(customerName);
	}

}

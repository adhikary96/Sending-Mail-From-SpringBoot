package com.cg.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.capstore.repo.InviteFriendRepo;
import org.springframework.stereotype.Service;

@Service
public class InviteFriendServiceImpl implements IInviteFriendService{
	
	@Autowired
	private InviteFriendRepo inviteFriendRepo;

	@Override
	public String inviteFriend(String name) {
		// TODO Auto-generated method stub
		return inviteFriendRepo.findCustomerEmail(name);
	}

}

package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.CustomerBean;

@Repository
public interface InviteFriendRepo extends JpaRepository<CustomerBean, String>{
	
	@Query(value="SELECT c.email FROM CustomerBean c WHERE c.customerName=(:name)")
	public String findCustomerEmail(@Param(value="name") String customerName);
}

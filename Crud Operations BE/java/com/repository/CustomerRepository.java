package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Customer;
import com.service.OrderResponse;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

  
//	@Query("SELECT new com.service.OrderResponse(c.username,p.mobilename,p.provider,p.mobileid,p.price,p.quantity) from Customer c JOIN c.mobiles p")
//	public List<OrderResponse> getJoinInformation();
	
}

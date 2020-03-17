package com.sample.order.placeorderservice.placeorderservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sample.order.placeorderservice.placeorderservice.Model.UserOrderDetails;

@Repository
public interface PlaceOrderRepository extends MongoRepository<UserOrderDetails, String>{

	public  List<UserOrderDetails> findByUserId(String userId);
	
	public  List findByorderId(String orderId);
	
	

}

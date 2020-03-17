package com.sample.payment.service.samplepaymentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.payment.service.samplepaymentservice.Model.OrderDetails;
import com.sample.payment.service.samplepaymentservice.repository.OrderRepository;

@Service
public class OrderService implements OrderServiceInf{

	@Autowired
	private OrderRepository orderRepository;
	
	public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
		return orderRepository.save(orderDetails);
	}
	
	
}

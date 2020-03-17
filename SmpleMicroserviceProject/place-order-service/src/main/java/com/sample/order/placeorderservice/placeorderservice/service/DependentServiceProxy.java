package com.sample.order.placeorderservice.placeorderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="netflix-zuul-api-gateway-server")
//@RibbonClient(name="sample-payment-service")
public interface DependentServiceProxy {
		@PostMapping("/sample-payment-service/sample-payment-service/payOredrAmount/userId/{userId}/orderId/{orderId}")
		public ResponseEntity<String> payOredrAmount(@RequestBody String paymentRequest,
				@PathVariable("userId") String userId,
				@PathVariable("orderId") String orderId);

		@GetMapping("/user-details-service/user-details-service/findUserDetails/userId/{userId}")
		public ResponseEntity<String> findUserDetails(@PathVariable("userId") String userId);

	}
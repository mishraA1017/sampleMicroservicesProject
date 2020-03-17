package com.sample.order.placeorderservice.placeorderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="netflix-zuul-api-gateway-server")
//@RibbonClient(name="sample-payment-service")
public interface UserDetailsServiceProxy {
		//@GetMapping("/user-details-service/user-details-service/findUserDetails/userId/{userId}")
		//public ResponseEntity<String> findUserDetails(@PathVariable("userId") String userId);

	}
	
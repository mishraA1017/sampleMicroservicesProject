package com.sample.order.placeorderservice.placeorderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.sample.order.placeorderservice.placeorderservice")
@EnableDiscoveryClient
public class PlaceOrderServiceApplication {

	@Value("${spring.application.name}")
	public static void main(String[] args) {
		SpringApplication.run(PlaceOrderServiceApplication.class, args);
	}

}

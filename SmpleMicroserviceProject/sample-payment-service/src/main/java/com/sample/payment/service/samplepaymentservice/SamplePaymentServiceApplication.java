package com.sample.payment.service.samplepaymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SamplePaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamplePaymentServiceApplication.class, args);
	}

}

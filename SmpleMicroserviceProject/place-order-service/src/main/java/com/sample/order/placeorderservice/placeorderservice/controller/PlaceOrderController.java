package com.sample.order.placeorderservice.placeorderservice.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sample.order.placeorderservice.placeorderservice.service.PlaceOrderService;

@RestController
@RequestMapping("place-order-service")
public class PlaceOrderController {

	@Autowired
	private PlaceOrderService placeOrderService;	
	 
	@PostMapping("/placeUserOrder")
	public String placeUserOrder(@RequestBody String orderDetailsRequest) {
		System.out.println("placeUserOrder");
		 Gson gson = new Gson(); 
		 System.out.println(orderDetailsRequest);
		 JsonObject jsonObject= gson.fromJson(orderDetailsRequest, JsonObject.class);
		 		
	     return new Gson().toJson(placeOrderService.saveUserOrderDetails(jsonObject));
		
	} 
	
	@PostMapping("/placeUserOrderFegin")
	public String placeUserOrderFegin(@RequestBody String orderDetailsRequest) {
		System.out.println("placeUserOrder");
		 Gson gson = new Gson(); 
		 System.out.println(orderDetailsRequest);
		 JsonObject jsonObject= gson.fromJson(orderDetailsRequest, JsonObject.class);
		 		
	     return new Gson().toJson(placeOrderService.saveUserOrderDetailsFegin(jsonObject));
		
	} 
	
	
	
	
	@GetMapping("/viewUserOrderDetails/orderId/{orderId}")
	//@RequestMapping(path = , method = RequestMethod.GET)
	public  String checkOutUserCartDetails(@PathVariable("orderId") String orderId) {
		
		Map<String, Object> orderMap= new HashMap<String,Object>();
		 System.out.println("test"+orderId);
		orderMap.put("orderDetailsList", placeOrderService.findByUserOrderDetails(orderId));
		return new Gson().toJson(orderMap);
		//return productService.checkOutUserCartDetails(userId);
	} 
}

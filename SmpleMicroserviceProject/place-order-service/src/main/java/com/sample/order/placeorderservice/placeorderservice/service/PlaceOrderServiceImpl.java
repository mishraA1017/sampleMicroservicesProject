package com.sample.order.placeorderservice.placeorderservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sample.order.placeorderservice.placeorderservice.Model.ProductDetails;
import com.sample.order.placeorderservice.placeorderservice.Model.UserOrderDetails;
import com.sample.order.placeorderservice.placeorderservice.repository.PlaceOrderRepository;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

	@Autowired
	private PlaceOrderRepository placeOrderRepository; 
	
	@Autowired
	private DependentServiceProxy DependentServiceProxy;
	//@Autowired
	//private UserDetailsServiceProxy userDetailsServiceProxy;
	
	@Override
	public UserOrderDetails saveUserOrderDetails(JsonObject jsonObject) {
		UserOrderDetails userOrder = new UserOrderDetails();
		JsonArray userOrderDetails = jsonObject.getAsJsonArray("userOrderDetails");
		System.out.println("json object userOrderDetails " + userOrderDetails);
		System.out.println("json object userId " + userOrderDetails.size());
		 Gson gson =null;
		String productCode;
		String productName;
		double productPrice;
		JsonObject arrayElments = null;
		ProductDetails productDetails;
		double totalAmount = 0;
		// @formatter:off
		ArrayList<ProductDetails> productList = new ArrayList<ProductDetails>();
		String orderId="O-2020"+ Math.random();
		
		
		
		for (int i = 0; i < userOrderDetails.size(); i++) {
			productDetails = new ProductDetails();

			arrayElments = userOrderDetails.get(i).getAsJsonObject();

			productCode = arrayElments.get("productCode").getAsString();
			productName = arrayElments.get("productName").getAsString();
			productPrice = arrayElments.get("productPrice").getAsDouble();
			productDetails.setProductCode(productCode);
			productDetails.setProductName(productName);
			productDetails.setProductPrice(productPrice);

			if (i == 0) {
				userOrder.setOrderId(orderId);
				userOrder.setUserId(arrayElments.get("userId").getAsString());
				userOrder.setOrderBy(arrayElments.get("userId").getAsString());
			}
			totalAmount = totalAmount + productPrice;
			productList.add(productDetails);

		}
		//call payment service to make payment 
		String cardNumber="4111111111111111";
		String currency="INR";
		String expirationDate="12-2024";
		
		JsonObject subDetails= new JsonObject();
		JsonObject amountDetails= new JsonObject();
		JsonObject cardDetails= new JsonObject();
		
		amountDetails.addProperty("currency", currency);
		amountDetails.addProperty("totalOrderAmount", totalAmount);
		subDetails.add("amount", amountDetails);
		
		cardDetails.addProperty("cardNumber", cardNumber);
		cardDetails.addProperty("expirationDate", expirationDate);
		subDetails.add("cardInfo", cardDetails);
		
		//System.out.println("subDetails--"+subDetails);
		
		
		String userId=arrayElments.get("userId").getAsString();
		
		Map<String, String> pathVariables=new HashMap<>();
		pathVariables.put("userId",arrayElments.get("userId").getAsString());
		pathVariables.put("orderId",orderId);
		
		System.out.println("userId  "+arrayElments.get("userId").getAsString());
		System.out.println("orderId  "+orderId );
		System.out.println("subDetails.toString()  "+subDetails.toString() );
		
		//ordinory call

		ResponseEntity<String> paymentRespnse = new RestTemplate().postForEntity(
				"http://localhost:8081/sample-payment-service/payOredrAmount/userId/{userId}/orderId/{orderId}",
				subDetails.toString(), String.class, pathVariables);
		
		System.out.println("paymentRespnse-->"+paymentRespnse.getStatusCodeValue()); 
		System.out.println("res code    "+paymentRespnse.getStatusCodeValue());
		if(paymentRespnse.getStatusCodeValue()==200)
		{
			
			Map<String, String> map = new HashMap<>();
			map.put("userId", arrayElments.get("userId").getAsString());

			ResponseEntity<String> respnse = new RestTemplate().getForEntity(
					"http://localhost:8091/user-details-service/findUserDetails/userId/{userId}", String.class, map);
		
		System.out.println("respnse   "+respnse); 
		
		gson = new Gson(); 
		JsonObject jsonAddressObject= gson.fromJson(respnse.getBody(),JsonObject.class);
		//System.out.println(jsonAddressObject); 
		//System.out.println("address->"+jsonAddressObject.get("address"));
		userOrder.setProductDetails(productList);
		userOrder.setAddress(jsonAddressObject.get("address").getAsString());
		userOrder.setOrderDate(new Date().toString());
		userOrder.setOrderStatus("Order Placed");
		userOrder.setTotalOrderAmount(totalAmount);
		userOrder.setProductDileveryDate(new Date().toString());
		
		UserOrderDetails orderDetails=placeOrderRepository.save(userOrder);
		
		return orderDetails;
		}
		else {
			return null;
		}
	}

	@Override
	public List findByUserOrderDetails(String orderId) {
		// TODO Auto-generated method stub
		return placeOrderRepository.findByorderId(orderId);
	}

	@Override
	public UserOrderDetails saveUserOrderDetailsFegin(JsonObject jsonObject) {

		UserOrderDetails userOrder = new UserOrderDetails();
		JsonArray userOrderDetails = jsonObject.getAsJsonArray("userOrderDetails");
		System.out.println("json object saveUserOrderDetailsFegin " + userOrderDetails);
		System.out.println("saveUserOrderDetailsFegin object userId " + userOrderDetails.size());
		 Gson gson =null;
		String productCode;
		String productName;
		double productPrice;
		JsonObject arrayElments = null;
		ProductDetails productDetails;
		double totalAmount = 0;
		// @formatter:off
		ArrayList<ProductDetails> productList = new ArrayList<ProductDetails>();
		String orderId="O-2020"+ Math.random();
		
		
		
		for (int i = 0; i < userOrderDetails.size(); i++) {
			productDetails = new ProductDetails();

			arrayElments = userOrderDetails.get(i).getAsJsonObject();

			productCode = arrayElments.get("productCode").getAsString();
			productName = arrayElments.get("productName").getAsString();
			productPrice = arrayElments.get("productPrice").getAsDouble();
			productDetails.setProductCode(productCode);
			productDetails.setProductName(productName);
			productDetails.setProductPrice(productPrice);

			if (i == 0) {
				userOrder.setOrderId(orderId);
				userOrder.setUserId(arrayElments.get("userId").getAsString());
				userOrder.setOrderBy(arrayElments.get("userId").getAsString());
			}
			totalAmount = totalAmount + productPrice;
			productList.add(productDetails);

		}
		//call payment service to make payment 
		String cardNumber="4111111111111111";
		String currency="INR";
		String expirationDate="12-2024";
		
		JsonObject subDetails= new JsonObject();
		JsonObject amountDetails= new JsonObject();
		JsonObject cardDetails= new JsonObject();
		
		amountDetails.addProperty("currency", currency);
		amountDetails.addProperty("totalOrderAmount", totalAmount);
		subDetails.add("amount", amountDetails);
		
		cardDetails.addProperty("cardNumber", cardNumber);
		cardDetails.addProperty("expirationDate", expirationDate);
		subDetails.add("cardInfo", cardDetails);
		
		//System.out.println("subDetails--"+subDetails);
		
		
		String userId=arrayElments.get("userId").getAsString();
		
		Map<String, String> pathVariables=new HashMap<>();
		pathVariables.put("userId",arrayElments.get("userId").getAsString());
		pathVariables.put("orderId",orderId);
		
		System.out.println("userId  "+arrayElments.get("userId").getAsString());
		System.out.println("orderId  "+orderId );
		System.out.println("subDetails.toString()  "+subDetails.toString() );
		//using feign client
		ResponseEntity<String> paymentRespnse = DependentServiceProxy.payOredrAmount(subDetails.toString(), userId, orderId);
		
		
		System.out.println("saveUserOrderDetailsFegin paymentRespnse-->"+paymentRespnse.getStatusCodeValue()); 
		System.out.println("saveUserOrderDetailsFegin res code    "+paymentRespnse.getStatusCodeValue());
		if(paymentRespnse.getStatusCodeValue()==200)
		{		
		//useing fegin
		///ResponseEntity<String> userRespnse=userDetailsServiceProxy.findUserDetails(userId);
		
		ResponseEntity<String> userRespnse=DependentServiceProxy.findUserDetails(userId);
			
		System.out.println("saveUserOrderDetailsFegin userRespnse   "+userRespnse); 
		
		gson = new Gson(); 
		JsonObject jsonAddressObject= gson.fromJson(userRespnse.getBody(),JsonObject.class);
		//System.out.println(jsonAddressObject); 
		//System.out.println("address->"+jsonAddressObject.get("address"));
		userOrder.setProductDetails(productList);
		userOrder.setAddress(jsonAddressObject.get("address").getAsString());
		userOrder.setOrderDate(new Date().toString());
		userOrder.setOrderStatus("Order Placed");
		userOrder.setTotalOrderAmount(totalAmount);
		userOrder.setProductDileveryDate(new Date().toString());
		
		UserOrderDetails orderDetails=placeOrderRepository.save(userOrder);
		
		return orderDetails;
		}
		else {
			return null;
		}
	
	} 

	/*
	 * @Override public List<UserOrderDetails> viewAllOrderDetails(String userId) {
	 * // TODO Auto-generated method stub return
	 * placeOrderRepository.findByUserId(userId) }	
	 */
	
	
	

}

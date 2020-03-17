package com.user.service.userdetailsservice.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.user.service.userdetailsservice.model.UserDetails;
import com.user.service.userdetailsservice.model.UserProfile;
import com.user.service.userdetailsservice.repository.UserRepository;
import com.user.service.userdetailsservice.service.UserService;

@RestController
@RequestMapping("/user-details-service")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository rep;
	
	@PostMapping("/saveUserDetails")
	public String saveUserDetails(@RequestBody String userDetailsRequest) {
		
		 Map<String, String> userResponse= new LinkedHashMap<>();
		// Map<String, Object> parentResponse= new LinkedHashMap<>();
		 
		 Gson gson = new Gson(); 
		 JsonObject jsonObject= gson.fromJson(userDetailsRequest, JsonObject.class);
		
		 UserProfile userModel =new UserProfile();
		
		
		 
		 System.out.println("json object paymentRequest "+jsonObject.toString()); 
		 
		 
		 
		 JsonObject userDetails= (JsonObject) jsonObject.get("userDetails");
		 
		 String userId= userDetails.get("userId").getAsString();	 
		 String userName=userDetails.get("userName").getAsString();
		 String mobileNo= userDetails.get("MobileNo").getAsString();	 
		 String email=userDetails.get("email").getAsString();
		 String status= userDetails.get("status").getAsString();	 
		 String address=userDetails.get("address").getAsString();
		
		 userModel.setUserId(userId);
		 userModel.setUserName(userName);
		 userModel.setMobileNo(mobileNo);
		 userModel.setEmail(email);
		 userModel.setStatus(status);
		 userModel.setAddress(address);
		//userService
		 userService.saveUserDetails(userModel);
		 
		 userResponse.put("statusCode", "0");
		 userResponse.put("message", "user saved successFully");
		 
		 return new Gson().toJson(userResponse);
	
	}
	@GetMapping("/getUserRequest")
	public String getUserRequest() {
		
		UserDetails user= new UserDetails();
		user.setUserDetails(new UserProfile());
		
		 System.out.println(new Gson().toJson(user));
			return new Gson().toJson(user);
	
	}
	
	@PutMapping("/updateUserAddress")
	public String updateUserAddress(@RequestBody String userAddUpdateRequest) {
		
		 Gson gson = new Gson(); 
		 JsonObject jsonObject= gson.fromJson(userAddUpdateRequest, JsonObject.class);
		// UserModel userModel =new UserModel();
		 String userId=jsonObject.get("userId").getAsString();
		 UserProfile userModel=userService.findUserDetails(userId);
		 
		 System.out.println("json object getAddress "+userModel.getAddress()); 
		 //System.out.println("json object mobile "+userModel.getMobileNo()); 
		 //System.out.println("json object email "+userModel.getEmail()); 
		 //System.out.println("json object status "+userModel.getStatus()); 
		 
		 
		 String userAddress=jsonObject.get("address").getAsString();
		 System.out.println("json object userId "+userId); 
		 System.out.println("json object userAddress "+userAddress); 
		 
		 userModel.setAddress(userAddress);
		 userService.updateUserAddress(userModel);
		 
		 Map<String, String> userResponse= new LinkedHashMap<>();
		 userResponse.put("statusCode", "0");
		 userResponse.put("message", "Address Updated Successfully");
		 
		 return new Gson().toJson(userResponse);
	}
	
	
	@GetMapping("/findUserDetails/userId/{userId}")
	public UserProfile findUserDetails(@PathVariable("userId") String userId ) {
		System.out.println("findUserDetails userId==  "+userId);
		return userService.findUserDetails(userId);
	}
	

	
}

package com.user.service.userdetailsservice.service;

import com.user.service.userdetailsservice.model.UserProfile;


public interface UserService {

	public UserProfile saveUserDetails(UserProfile userModel); 
	public UserProfile findUserDetails(String userId);
	public UserProfile updateUserAddress(UserProfile userModel);
}

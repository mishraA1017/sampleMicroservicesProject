package com.user.service.userdetailsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.userdetailsservice.model.UserProfile;
import com.user.service.userdetailsservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserProfile saveUserDetails(UserProfile userModel) {
		// TODO Auto-generated method stub
		return userRepository.save(userModel);
	}

	@Override
	public UserProfile findUserDetails(String userId) {
		// TODO Auto-generated method stub		
		System.out.println("userId   "+userId);
		System.out.println(userRepository.findByUserId(userId));
		return userRepository.findByUserId(userId);
	}

	@Override
	public UserProfile updateUserAddress(UserProfile userModel) {
		return userRepository.save(userModel);
	}

}

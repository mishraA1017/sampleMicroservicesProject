package com.user.service.userdetailsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.service.userdetailsservice.model.UserProfile;
@Repository
public interface UserRepository extends MongoRepository<UserProfile, String> {

	UserProfile findByUserId(String userId);

	
	//public UserDetails findUserById(String userId);
}

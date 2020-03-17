package com.mongo.demoMongoDB.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.demoMongoDB.Model.UserCartDetails;
import com.mongo.demoMongoDB.Model.product;
@Repository
public interface ProductRepository extends MongoRepository<UserCartDetails, String> {

	public UserCartDetails findByProductName(String productName);
	public UserCartDetails findByProductCode(String productCode);
	public  List<UserCartDetails> findByUserId(String userId);
}

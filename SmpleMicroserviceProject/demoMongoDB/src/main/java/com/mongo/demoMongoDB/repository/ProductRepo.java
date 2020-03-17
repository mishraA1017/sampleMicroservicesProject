package com.mongo.demoMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.demoMongoDB.Model.product;

public interface ProductRepo extends MongoRepository<product, String> {

	product findByProductCode(String productCode);

}

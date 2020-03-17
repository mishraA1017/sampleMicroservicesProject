package com.sample.payment.service.samplepaymentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sample.payment.service.samplepaymentservice.Model.OrderDetails;

@Repository
public interface OrderRepository extends MongoRepository<OrderDetails, String> {

}

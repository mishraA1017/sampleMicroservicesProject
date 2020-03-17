package com.sample.order.placeorderservice.placeorderservice.service;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sample.order.placeorderservice.placeorderservice.Model.UserOrderDetails;

public interface PlaceOrderService {

	public UserOrderDetails saveUserOrderDetails(JsonObject jsonObject);
	public List findByUserOrderDetails(String userId);
	public UserOrderDetails saveUserOrderDetailsFegin(JsonObject jsonObject);
}

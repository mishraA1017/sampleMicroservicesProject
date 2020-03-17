package com.sample.payment.service.samplepaymentservice.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderDetails {
	
	private String userId ;
     private String  orderId;
     private String  orderDetailDescription;
     private String orderAmount;
     private String currency;
     private String transactionId;
     private String transactionType;
     private String transactionDate;
     private String transactionDesc;
     private String status;
     private String paymentMethod;
     private String paymentMethodId;
     private String maskedAccountNumber;
     private String cardExpiryDate;
     private String statusCode;
     private String  message;
     
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderDetailDescription() {
		return orderDetailDescription;
	}
	public void setOrderDetailDescription(String orderDetailDescription) {
		this.orderDetailDescription = orderDetailDescription;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getMaskedAccountNumber() {
		return maskedAccountNumber;
	}
	public void setMaskedAccountNumber(String maskedAccountNumber) {
		this.maskedAccountNumber = maskedAccountNumber;
	}
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
     
}

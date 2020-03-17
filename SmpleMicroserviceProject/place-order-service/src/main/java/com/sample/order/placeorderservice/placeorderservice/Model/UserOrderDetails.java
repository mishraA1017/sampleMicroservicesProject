package com.sample.order.placeorderservice.placeorderservice.Model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class UserOrderDetails {

	private int oid;
	private String orderId;
	private String userId;
	private ArrayList<ProductDetails> productDetails; 
	private double totalOrderAmount;
	private String dileveryAddress;
	private String productDileveryDate;
	private String orderStatus;
	private String orderDate;
	private String orderBy;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	public ArrayList<ProductDetails> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(ArrayList<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
	public String getDileveryAddress() {
		return dileveryAddress;
	}
	public void setDileveryAddress(String dileveryAddress) {
		this.dileveryAddress = dileveryAddress;
	}
	public double getTotalOrderAmount() {
		return totalOrderAmount;
	}
	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}
	public String getAddress() {
		return dileveryAddress;
	}
	public void setAddress(String dileveryAddress) {
		this.dileveryAddress = dileveryAddress;
	}
	public String getProductDileveryDate() {
		return productDileveryDate;
	}
	public void setProductDileveryDate(String productDileveryDate) {
		this.productDileveryDate = productDileveryDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
}

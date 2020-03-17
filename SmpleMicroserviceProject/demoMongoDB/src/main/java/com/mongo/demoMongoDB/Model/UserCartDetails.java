package com.mongo.demoMongoDB.Model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class UserCartDetails {

	@Id
	private String oid;
	private String productCode;
	private String productName;
	private double productPrice;
	@NotNull
	private String userId;
	
	public UserCartDetails(String productCode, String productName, double productPrice, String userId) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.userId = userId;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}

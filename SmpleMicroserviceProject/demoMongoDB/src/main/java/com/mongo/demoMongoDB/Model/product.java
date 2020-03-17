package com.mongo.demoMongoDB.Model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class product implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	//private String prodId;
	@NotNull
	@UniqueElements
	private String productCode;
	@NotNull
	private String productName;
	@NotNull
	private String productPrice;
	private ArrayList<ReviewDetails> ProductReviewDetails;
	
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
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public ArrayList<ReviewDetails> getProductReviewDetails() {
		return ProductReviewDetails;
	}
	public void setProductReviewDetails(ArrayList<ReviewDetails> productReviewDetails) {
		ProductReviewDetails = productReviewDetails;
	}
	public product(String productCode, String productName, String productPrice,
			ArrayList<ReviewDetails> productReviewDetails) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		ProductReviewDetails = productReviewDetails;
	}
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

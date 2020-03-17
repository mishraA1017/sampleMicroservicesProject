package com.mongo.demoMongoDB.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.mongo.demoMongoDB.Model.ReviewDetails;
import com.mongo.demoMongoDB.Model.UserCartDetails;
import com.mongo.demoMongoDB.Model.product;
import com.mongo.demoMongoDB.repository.ProductRepo;
import com.mongo.demoMongoDB.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private Environment environment;
	@Autowired
	private ProductRepository prodRepository;
	@Autowired
	private ProductRepo repo;

	public UserCartDetails addProductInCart(String ProductCode, String ProductName, double procuctPrice,String userId) {
		return prodRepository.save(new UserCartDetails(ProductCode, ProductName, procuctPrice,userId));
	}
	
	public product addProduct(String productCode, String productName, String productPrice,
			ArrayList<ReviewDetails> productReviewDetails) {
		   
		return  repo.save(new product(productCode, productName, productPrice, productReviewDetails));
	}
	

	public List<UserCartDetails> getAllProductFromCart() {
		return prodRepository.findAll();
	}

	public UserCartDetails getProductByName(String productName) {
		return prodRepository.findByProductName(productName);
	}
	public  List<UserCartDetails> checkOutUserCartDetails(String userId) {
		return prodRepository.findByUserId(userId);
	}
	
	
	public UserCartDetails findByProductCode(String productCode) {
		UserCartDetails p=prodRepository.findByProductCode(productCode);
		//p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return p;
	}

	public UserCartDetails updateProductDetails(String productCode,String productName, double procuctPrice) {
		UserCartDetails prod=prodRepository.findByProductCode(productCode);
		prod.setProductName(productName); 
		prod.setProductPrice(procuctPrice);
		return prodRepository.save(prod);
		
	}
	
	
	public void removeAllproductFromCart() {
		prodRepository.deleteAll();
	}

	public void removeProductFromCart(String productName) {
		UserCartDetails prod= prodRepository.findByProductName(productName);
		prodRepository.delete(prod);
	}

	public void removeAllproductFromUserCart(String userId) {
		// TODO Auto-generated method stub
		UserCartDetails prod= prodRepository.findByProductName(userId);
		prodRepository.delete(prod);
	}
	
	

	public product findProductDetails(String productCode) {
		return repo.findByProductCode(productCode);		
	}

	public product updateProductReview(product productModel) {		
		return repo.save(productModel);
	}
	
	
}

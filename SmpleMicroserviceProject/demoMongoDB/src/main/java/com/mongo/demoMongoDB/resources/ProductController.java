package com.mongo.demoMongoDB.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongo.demoMongoDB.Model.ReviewDetails;
import com.mongo.demoMongoDB.Model.UserCartDetails;
import com.mongo.demoMongoDB.Model.product;
import com.mongo.demoMongoDB.service.ProductService;

@RestController
@RequestMapping("/product-details-service")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	 

	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	@RequestMapping("/addProductInCart")
	public String addProductInCart(@RequestParam String productCode,@RequestParam String productName, @RequestParam double productPrice, @RequestParam String userId)
	{
		UserCartDetails p=productService.addProductInCart(productCode, productName, productPrice,userId);
		return p.toString();
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody String prod)
	{
		
		 Gson gson = new Gson(); 
		 JsonObject jsonObject= gson.fromJson(prod, JsonObject.class);
		 String productCode=jsonObject.get("productCode").getAsString();
		 String productName=jsonObject.get("productName").getAsString();
		 String productPrice=jsonObject.get("productPrice").getAsString();
		 System.out.println(productCode);
		 ReviewDetails r=new ReviewDetails();
		 
		 JsonArray productReviewDetails = jsonObject.getAsJsonArray("ProductReviewDetails");
		 System.out.println("json object productReviewDetails " + productReviewDetails);
		 System.out.println("json object productReviewDetails.size " + productReviewDetails.size());
		 
		 JsonObject arrayElments = null;
		 
		 ArrayList<ReviewDetails> productReview =new ArrayList<>();
		 
		 for (int i = 0; i < productReviewDetails.size(); i++) {
			
			 arrayElments = productReviewDetails.get(i).getAsJsonObject();
			 String userId = arrayElments.get("userId").getAsString();
			 
			 String review=arrayElments.get("review").getAsString();
			 
			 r.setUserId(userId);
			 r.setReview(review);
			 productReview.add(r);
		 }
		product p=productService.addProduct(productCode,productName, productPrice ,productReview);
		return p.toString();
	}
	@PutMapping("/addProductReview")
	public String addProductReview(@RequestBody String updateReview)
	{
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhh");
			 Gson gson = new Gson(); 
			 JsonObject jsonObject= gson.fromJson(updateReview, JsonObject.class);
		
			 String productCode=jsonObject.get("productCode").getAsString();
			 System.out.println("productCode"+productCode);
			 String userId=jsonObject.get("userId").getAsString();
			 String review=jsonObject.get("review").getAsString();
			 
			 product productModel=productService.findProductDetails(productCode);
			// System.out.println(productModel.getProdId());
			 System.out.println("json object getProductCode "+productModel.getProductCode()); 
			 
			 
			 System.out.println(productModel.getProductReviewDetails());
			 ArrayList<ReviewDetails> list =productModel.getProductReviewDetails();
			 
			 ReviewDetails productReviewDetails=new ReviewDetails();
			 productReviewDetails.setUserId(userId);
			 productReviewDetails.setReview(review);
			 
			 list.add(productReviewDetails);
			 productModel.setProductReviewDetails(list);
			 
			product p= productService.updateProductReview(productModel);
			 
			 Map<String, String> userResponse= new LinkedHashMap<>();
			 userResponse.put("statusCode", "0");
			 userResponse.put("message", "product review Updated Successfully");
			 userResponse.put("prodDetails", p.toString());
			 return new Gson().toJson(userResponse);
		}	
	
	
	@RequestMapping("/getAllProductFromCart")
	public List<UserCartDetails> getAllProductFromCart()
	{
		return productService.getAllProductFromCart();
	}
	
	@RequestMapping("/getProduct")
	public UserCartDetails getProductByName(@RequestParam String productName) {
		return productService.getProductByName(productName);
	} 
	///userId/{userId}", method = RequestMethod.GET
	@RequestMapping(path = "/checkOutUserCartDetails")
	public  String checkOutUserCartDetails(@RequestParam String userId) {
		System.out.println("userId "+userId);
		Map<String, Object> orderMap= new HashMap<String,Object>();
		
		orderMap.put("userOrderDetails", productService.checkOutUserCartDetails(userId));
		return new Gson().toJson(orderMap);
		//return productService.checkOutUserCartDetails(userId);
	} 
	
	@RequestMapping("/getProductFromCode")
	public UserCartDetails findByProductCode(@RequestParam String productCode) {
		return productService.findByProductCode(productCode);
	} 
	
	
	@RequestMapping("/updateProductDetails")
	public UserCartDetails updateProductDetails(@RequestParam String productCode,@RequestParam String productName, @RequestParam double productPrice) {
		return productService.updateProductDetails(productCode, productName, productPrice);
	} 
	
	@RequestMapping("/removeAllproductFromCart")
	public String removeAllproductFromCart() {
		productService.removeAllproductFromCart(); 
		 return "all records are deleted";
	} 
	
	@RequestMapping("/removeProductFromCart")
	public String removeProductFromCart(@RequestParam String productName) {
		productService.removeProductFromCart(productName);
		 return "record is deleted"+ productName;
	} 
	
	
	
	@DeleteMapping(path = "/removeAllproductFromUserCart/userId/{userId}")
	public  String removeAllproductFromUserCart(@PathVariable String userId) {
		System.out.println("userId-->"+userId);
		productService.removeAllproductFromUserCart(userId);
		return "product removed form cart";
	} 
	
}

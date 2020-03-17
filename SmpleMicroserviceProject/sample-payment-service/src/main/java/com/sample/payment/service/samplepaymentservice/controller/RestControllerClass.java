package com.sample.payment.service.samplepaymentservice.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sample.payment.service.samplepaymentservice.Model.OrderDetails;
import com.sample.payment.service.samplepaymentservice.Model.PaymentDetails;
import com.sample.payment.service.samplepaymentservice.services.OrderServiceInf;

@RestController
@RequestMapping("sample-payment-service")
public class RestControllerClass {

	
	
	public RestControllerClass() {
		super();
System.out.println("test");	}


	@Autowired
	private OrderServiceInf orderService;
	
	OrderDetails orderDetails =new OrderDetails();
	
	@RequestMapping("/test")
	public String test() {
		 
		return "test";
	}
	
	
	//@POST
	//@Path("/createLTfitFilghtInvoicing")
	//@Consumes(MediaType.APPLICATION_JSON)//{ "ltfilghtInvReq":{ "ticketInfo":[ {"createdBy":"ltadmin", "pcc":"LO0001", "airlineCode":"AI_AI_98", "gdsType":"0", "ticketType":"0", "journeyType":"0", "Consolidator":"TCIL", "crsPnr":"YHRSMK", "xoVmpdNo":"0101", "tktgTicketCode":"", "noOfSegments": "2", "bookingFileNo":"F190000013", "paxNo":"1", "firstName":"abc", "lastName":"dsfer", "paxType":"0", "ticketNo":"009568677666508", "FareBasis":"23313", "baseFare":"1200", "currency":"INR", "exRate":"1", "commission":"0", "overridecomm":"0", "taxes":"2134", "discountORCharges":"50" }, { "createdBy":"ltadmin", "pcc":"LO0001", "airlineCode":"AI_AI_98", "gdsType":"0", "ticketType":"0", "journeyType":"0", "Consolidator":"TCIL", "crsPnr":"YHRSMK", "xoVmpdNo":"0101", "tktgTicketCode":"", "noOfSegments": "2", "bookingFileNo":"F190000012", "paxNo":"2", "firstName":"abc", "lastName":"dsfer", "paxType":"0", "ticketNo":"6987556675800", "FareBasis":"1223", "baseFare":"1200", "currency":"INR", "exRate":"1", "commission":"0", "overridecomm":"0", "taxes":"5566788", "discountORCharges":"50" } ], "segmentInfo":[ { "segNo":"1", "fromAirportCode":"BOM", "toAirportCode":"DEL", "depDate":"10/08/2019", "arriDate":"10/08/2019", "flightNo":"420", "airLinePNR":"PNR", "rbd":"R", "status":"0" }, { "segNo":"2", "fromAirportCode":"DEL", "toAirportCode":"BOM", "depDate":"12/08/2019", "arriDate":"12/08/2019", "flightNo":"420", "airLinePNR":"PNR", "rbd":"R", "status":"0" } ] } } 
	//@Produces(MediaType.APPLICATION_JSON)//{ "code": 0, "message": "Flight invoicing done successfully.", "flightRefNo": "FF342061#FF342062#" } 


	@PostMapping("/payOredrAmount/userId/{userId}/orderId/{orderId}")
	public String payOredrAmount(@RequestBody String paymentRequest,@PathVariable("userId") String userId,@PathVariable("orderId") String orderId) {
		System.out.println("payOredrAmount");
		Gson gson = new Gson(); 
		 JsonObject jsonObject= gson.fromJson(paymentRequest, JsonObject.class);
		 
		 PaymentDetails p1 = new PaymentDetails();
		 
		 Map<String, Object> parentResponse= new LinkedHashMap<>();
		// parentResponse.put("orderDetails", value)
		 
		 Map<String, String> jesonResponse= new LinkedHashMap<>();
		 //List<Object> transactionReferences= new ArrayList<>();;
		
		 
		 System.out.println("json object paymentRequest "+jsonObject.toString()); 
		 System.out.println("json object userId "+userId); 
		 System.out.println("json object orderId "+orderId); 
		 
		 
		 JsonObject orderAmountDetails= (JsonObject) jsonObject.get("amount");
		 JsonObject cardInfo= (JsonObject) jsonObject.get("cardInfo");
		 
		 String totalOrderAmount= orderAmountDetails.get("totalOrderAmount").getAsString();	 
		 String currancy=orderAmountDetails.get("currency").getAsString();
		 String cardNo =cardInfo.get("cardNumber").getAsString();	
		 String validtoData=cardInfo.get("expirationDate").getAsString();			 
		
		 orderDetails.setOrderAmount(totalOrderAmount);
		 orderDetails.setCurrency(currancy);
		 orderDetails.setCardExpiryDate(validtoData);
		 orderDetails.setMaskedAccountNumber(cardNo);
		 orderDetails.setUserId(userId);
		 orderDetails.setOrderId(orderId);
		 orderDetails.setOrderDetailDescription("");
		 
		 orderDetails.setTransactionId("12345678");
		 orderDetails.setTransactionType("");
		 orderDetails.setMaskedAccountNumber(cardNo);
		 orderDetails.setTransactionDate(new Date().toString());
		 orderDetails.setTransactionDesc("Transaction accepted");
		 orderDetails.setOrderDetailDescription("");
		 
		 
		 orderDetails.setStatus("Processed");
		 orderDetails.setPaymentMethod("Visa");
		 orderDetails.setPaymentMethodId("1001");
		 
		 
		 System.out.println("json object totalOrderAmount "+totalOrderAmount); 
		 System.out.println("json object currancy "+currancy); 
		 System.out.println("json object cardNo "+cardNo); 
		 System.out.println("json object validtoData "+validtoData); 
		 
		 boolean isPaymentDone=true;
		 //send request to bank to verify card details and availability of amount in card
		 //if card valid make payment and return us payment done successfully then we take order.
		 
		/*
		 * jesonResponse.put("userId", userId); jesonResponse.put("orderId", orderId);
		 * jesonResponse.put("orderDetailDescription", "");
		 * jesonResponse.put("orderAmount", totalOrderAmount);
		 * jesonResponse.put("currency", currancy); jesonResponse.put("transactionId",
		 * "12345678"); jesonResponse.put("transactionType", "Authorize");
		 * jesonResponse.put("transactionDate", new Date().toString());
		 * jesonResponse.put("transactionDesc", "Transaction accepted");
		 * jesonResponse.put("status", "Processed"); jesonResponse.put("paymentMethod",
		 * "Visa"); jesonResponse.put("paymentMethodId", "1001");
		 * jesonResponse.put("maskedAccountNumber", cardNo);
		 * jesonResponse.put("cardExpiryDate", validtoData);
		 * 
		 * if(isPaymentDone) { orderDetails.setStatusCode("0");
		 * orderDetails.setMessage("payment done successfully");
		 * 
		 * }else { orderDetails.setStatusCode("1");
		 * orderDetails.setMessage("some error occuered"); }
		 * 
		 * parentResponse.put("orderDetails", jesonResponse);
		 */
		 
		
		 orderService.saveOrderDetails(orderDetails); 
		  //{
				//return orderRepository.save(orderDetails);
			//}
		p1.setPaymentDetails(orderDetails);
		 System.out.println(new Gson().toJson(p1));
		return new Gson().toJson(p1);
	}
	
	
}

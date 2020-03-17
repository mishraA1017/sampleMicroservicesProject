package com.user.service.userdetailsservice.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
//@AllArgsConstructor
@Document
public class UserProfile implements Serializable {
		
		private static final long serialVersionUID = 1L;

	/*
	 * @Id private String userId="user1" ; private String userName="Amit Mishra";
	 * private String MobileNo="9819553887"; private String
	 * email="mitkumar.mishra@techtreeit.com"; private String status="online";
	 * private String
	 * address="Unit no 8, corporate park sion tromby Road chembur mumbai-400071";
	 */
		
		 @Id
	   	 private String userId ;
	     private String  userName;
	     private String  MobileNo;
	     private String email;
	     private String status;
	     private String address;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getMobileNo() {
			return MobileNo;
		}
		public void setMobileNo(String mobileNo) {
			MobileNo = mobileNo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	
	
}

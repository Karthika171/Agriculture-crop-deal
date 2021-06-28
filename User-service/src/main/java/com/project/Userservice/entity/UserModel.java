package com.project.Userservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document
public class UserModel  {
	
	@Id
	@NonNull
	private String emailId;
	@NonNull
	private String mobileNo;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String password;
	@NonNull
	private String Address;
	@NonNull
	private String district;
	@NonNull
	private String city;
	@NonNull
	private String state;
	@NonNull
	private String pincode;
	@NonNull
	private String role;
	
	public UserModel() {
	
	}
	
	public UserModel(String emailId, String mobileNo, String firstName, String lastName, String password,String Address,
			    String district,String city, String state,String pincode, String role) {
		
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.Address = Address;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;	
		this.role = role;

	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserModel [emailId=" + emailId + ", mobileNo=" + mobileNo + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", Address=" + Address + ", district=" + district
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", role=" + role + "]";
	}
	
}


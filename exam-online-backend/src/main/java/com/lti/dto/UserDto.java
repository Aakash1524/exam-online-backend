package com.lti.dto;

public class UserDto {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNo;
	private String email;
	private String city;
	private String state;
	
	
	public UserDto(String firstName, String middleName, String lastName, String phoneNo, String email, String city,
			String state) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.city = city;
		this.state = state;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	@Override
	public String toString() {
		return "UserDto [firstName : " + firstName + ", lastName : " + lastName + ", middleName : " + middleName + 
				", email : " + email + ", phoneNo : "+ phoneNo + ", city : " + city + ", state : " + state + "]";
	}
}

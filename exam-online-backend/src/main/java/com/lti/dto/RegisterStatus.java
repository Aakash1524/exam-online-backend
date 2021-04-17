package com.lti.dto;

//********************************* Registration Status ********************************

public class RegisterStatus extends Status{
	private int registeredUserId;

	public int getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredUserId(int registeredUserId) {
		this.registeredUserId = registeredUserId;
	}
	
}

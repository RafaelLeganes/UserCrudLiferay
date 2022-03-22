package com.sinensia.model;

public class User {
	
	private String userName;
	private String userSurname;
	private String userAddress;
	private String userIdCard;
	
	public User(String userName, String userSurname, String userAddress, String userIdCard) {
		super();
		this.userName = userName;
		this.userSurname = userSurname;
		this.userAddress = userAddress;
		this.userIdCard = userIdCard;
	}
	
	public User() {	
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	
}

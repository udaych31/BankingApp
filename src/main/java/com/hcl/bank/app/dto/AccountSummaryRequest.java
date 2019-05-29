package com.hcl.bank.app.dto;

import java.io.Serializable;

public class AccountSummaryRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String fullName;
	
	private String gender;
	
	private String address;
	
	private Long mobileNo;
	
	private String emailId;
	
	private String accountType;
	
	private Double balance;
	
	private String uniqueId;
	

	public AccountSummaryRequest() {
		super();
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public String getUniqueId() {
		return uniqueId;
	}


	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	
	

}

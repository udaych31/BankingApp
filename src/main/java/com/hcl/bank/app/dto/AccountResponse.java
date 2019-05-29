package com.hcl.bank.app.dto;

public class AccountResponse {
	
	private Long accountNumber;
	private Double balance;
	private String name;
	
	public Long getAccountNUmber() {
		return accountNumber;
	}
	public void setAccountNUmber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AccountResponse [accountNumber=" + accountNumber + ", balance=" + balance + ", name=" + name + "]";
	}
	
	
	

}

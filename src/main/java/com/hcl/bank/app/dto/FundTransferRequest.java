package com.hcl.bank.app.dto;

import java.io.Serializable;

public class FundTransferRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long accountNo;
	
	private Long toAccountNo;
	
	private Double amount;
	
	public FundTransferRequest() {
		super();
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Long getToAccountNo() {
		return toAccountNo;
	}

	public void setToAccountNo(Long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
}

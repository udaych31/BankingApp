package com.hcl.bank.app.service;


import com.hcl.bank.app.dto.AccountResponse;
import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.entity.AccountSummary;

public interface BankingService {
	
	public AccountResponse getAccountDetails(String userName);
	public FundTransferResponse makeTransaction(FundTransferRequest request);
	public String openAccount(AccountSummary accountSummary);

}

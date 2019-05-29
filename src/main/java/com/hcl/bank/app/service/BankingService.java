package com.hcl.bank.app.service;

import com.hcl.bank.app.dto.AccountResponse;

public interface BankingService {
	
	public AccountResponse getAccountDetails(String userName);

}

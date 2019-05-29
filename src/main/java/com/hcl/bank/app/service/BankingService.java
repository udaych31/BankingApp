package com.hcl.bank.app.service;


import java.util.List;

import com.hcl.bank.app.dto.AccountResponse;
import com.hcl.bank.app.dto.AccountSummaryRequest;
import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;

public interface BankingService {
	
	public AccountResponse getAccountDetails(String userName);
	public FundTransferResponse makeTransaction(FundTransferRequest request);
	
	public List<Long> fetchAllAccountNumbers(Long accountNumber);
	
	public String openAccount(AccountSummaryRequest accountSummary);

}

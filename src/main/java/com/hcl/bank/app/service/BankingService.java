package com.hcl.bank.app.service;

import java.util.List;

import com.hcl.bank.app.entity.AccountSummary;
	
import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;

public interface BankingService {
	
	public FundTransferResponse makeTransaction(FundTransferRequest request);
	
	public List<Long> fetchAllAccountNumbers(Long accountNumber);
	
	public String openAccount(AccountSummary accountSummary);


}

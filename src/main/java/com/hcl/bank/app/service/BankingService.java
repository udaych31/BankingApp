package com.hcl.bank.app.service;

import com.hcl.bank.app.entity.AccountSummary;
	
import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;

public interface BankingService {
	
	public FundTransferResponse makeTransaction(FundTransferRequest request);
	public String openAccount(AccountSummary accountSummary);


}

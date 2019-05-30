package com.hcl.bank.app.service;

import com.hcl.bank.app.dto.TransactionHistoryResponse;

import java.util.List;

import com.hcl.bank.app.dto.AccountResponse;
import com.hcl.bank.app.dto.AccountSummaryRequest;
import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.dto.OpenAccountResponse;

public interface BankingService {
	
	public AccountResponse getAccountDetails(String userName);
	public FundTransferResponse makeTransaction(FundTransferRequest request);
	
	public List<Long> fetchAllAccountNumbers(Long accountNumber);
	
	public OpenAccountResponse openAccount(AccountSummaryRequest accountSummary);

	TransactionHistoryResponse TransactionHistory();

}

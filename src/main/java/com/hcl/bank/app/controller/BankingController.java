package com.hcl.bank.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.app.dto.AccountResponse;
import com.hcl.bank.app.dto.AccountSummaryRequest;
import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.service.BankingService;

@RestController
@RequestMapping("/bank")
public class BankingController {
	
	public static final Logger logger=LogManager.getLogger(BankingController.class);
	
	@Autowired
	BankingService bankingService;
	
	@GetMapping("/getAccountDetails")
	public AccountResponse getAccountDetails(String userName) {
		
		return bankingService.getAccountDetails(userName);
			
	}

	@PostMapping("/openAccount")
	public String openAccount(@RequestBody AccountSummaryRequest request) {
		return bankingService.openAccount(request);
		}
	
	
	@PostMapping("/transferfund")
	public FundTransferResponse makeTransaction(@RequestBody FundTransferRequest request) {
		logger.info("makeTransaction calling...!");
		return bankingService.makeTransaction(request);
	}
	
	@GetMapping("/findallaccounts")
	public List<Long> findAllAccounts(@RequestParam("accountNumber") Long accountNumber) {
		logger.info("findAllAccounts calling...!");
		return bankingService.fetchAllAccountNumbers(accountNumber);
	}

}

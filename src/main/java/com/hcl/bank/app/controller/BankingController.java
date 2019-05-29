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

import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.service.BankingService;

@RestController
@RequestMapping("/bank")
public class BankingController {
	
	@Autowired
	private BankingService bankingService;
	
	@PostMapping("/openAccount")
	public String openAccount(@RequestBody AccountSummary accountSummary) {
		bankingService.openAccount(accountSummary);
		return "Account opened with Account number "+accountSummary.getAccountNumber();
		}
	public static final Logger logger=LogManager.getLogger(BankingController.class);
	
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

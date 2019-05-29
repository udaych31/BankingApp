package com.hcl.bank.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.app.dto.TransactionHistoryResponse;
import com.hcl.bank.app.service.BankingService;

@RestController
@RequestMapping("/bank")
public class BankingController {

	private static final Logger logger = LogManager.getLogger(BankingController.class);

	@Autowired
	BankingService bankingService;
	
	
	@GetMapping("/transactionHistory")
	public TransactionHistoryResponse listbreach()
	{
		logger.info("inside in controller");
		logger.debug("inside########");

		TransactionHistoryResponse transactionHistoryResponse=bankingService.TransactionHistory();
		return transactionHistoryResponse;
		
	}
}

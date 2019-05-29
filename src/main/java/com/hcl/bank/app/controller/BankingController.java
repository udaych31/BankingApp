package com.hcl.bank.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.service.BankingService;

@RestController
@RequestMapping("/bank")
public class BankingController {
	
	public static final Logger logger=LogManager.getLogger(BankingController.class);
	
	@Autowired
	private BankingService bankingService;
	
	@PostMapping("/transferfund")
	public FundTransferResponse makeTransaction(@RequestBody FundTransferRequest request) {
		logger.info("makeTransaction calling...!");
		return bankingService.makeTransaction(request);
	}

}

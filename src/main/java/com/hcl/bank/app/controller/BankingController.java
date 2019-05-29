package com.hcl.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.app.entity.AccountSummary;
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

}

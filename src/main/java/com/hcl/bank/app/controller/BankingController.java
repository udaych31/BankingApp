package com.hcl.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.app.dto.AccountResponse;
import com.hcl.bank.app.service.BankingService;

@RestController
@RequestMapping("/bank")
public class BankingController {
	
	@Autowired
	BankingService bankservice;
	
	@GetMapping("/getAccountDetails")
	public AccountResponse getAccountDetails(String userName) {
		
		AccountResponse response=bankservice.getAccountDetails(userName);
		return response;
			
	}


}

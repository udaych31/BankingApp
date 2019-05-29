package com.hcl.bank.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.UserInfo;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.UserRepository;

@Service
public class BankingServiceImpl implements BankingService {
	
	@Autowired
	private AccountSummaryRepository accountSummaryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String openAccount(AccountSummary accountSummary) {
		
		
		AccountSummary summary= accountSummaryRepository.save(accountSummary);
		UserInfo userInfo=new UserInfo();
		userInfo.setUserId(1111L);
		userInfo.setUserName("sushil");
		userInfo.setPassword("sushil");
		userInfo.setRole("user");
		userInfo.setCreateDt(new Date());
		userInfo.setAccountNumber(summary.getAccountNumber());
		userRepository.save(userInfo);
		return "Account opened with Account number "+accountSummary.getAccountNumber();
		}
	

}

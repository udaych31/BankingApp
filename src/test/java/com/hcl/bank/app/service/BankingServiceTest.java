package com.hcl.bank.app.service;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class BankingServiceTest {
	
	@InjectMocks
	private BankingServiceImpl bankingService;
	
	@Mock
	private AccountSummaryRepository accountSummaryRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void openAccountTest() {
		
		AccountSummary accountSummary=new AccountSummary();
		accountSummary.setAccountNumber(1234L);
		accountSummary.setAccountType("savings");
		accountSummary.setAddress("Bangalore");
		accountSummary.setBalance(5000.0);
		accountSummary.setCreateDt(new Date());
		accountSummary.setEmailId("s@gmail.com");
		accountSummary.setFullName("Sushil Tiwari");
		accountSummary.setGender("Male");
		accountSummary.setMobileNo(1234567890L);
		accountSummary.setUniqueId("ACVPT4573W");

		when(accountSummaryRepository.save(accountSummary)).thenReturn(accountSummary);
       // assertNotEquals(1234L, bankingService.openAccount(accountSummary));
		
	}

}

package com.hcl.bank.app.service;

import java.util.Date;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bank.app.dto.AccountResponse;
import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.UserInfo;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class BankingAppTests {

	@Mock
	AccountSummaryRepository accountRepository;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	BankingServiceImpl serviceImpl;

	@Test
	public void testGetAccountDetails() {

		Optional<AccountSummary> summary = Optional.empty();

		AccountSummary account = new AccountSummary();
		account.setAccountNumber(1L);
		account.setBalance(1000.0);
		account.setFullName("satya");
		summary = Optional.ofNullable(account);

		Optional<UserInfo> user = Optional.empty();
		UserInfo info = new UserInfo();
		info.setAccountNumber(1L);
		info.setCreateDt(new Date());
		info.setPassword("madhurya");
		info.setRole("user");
		info.setUserId(1L);
		info.setUserName("suma");
		user = Optional.ofNullable(info);

		AccountResponse response = new AccountResponse();
		response.setAccountNUmber(1L);
		response.setBalance(1000.0);
		response.setName("satya");

		Mockito.when(accountRepository.findById(1L)).thenReturn(summary);
		Mockito.when(userRepository.findByUserNameAndRole("suma","user")).thenReturn(user);

		AccountResponse result = serviceImpl.getAccountDetails("suma");

		Assert.assertEquals(response.toString(), result.toString());

	}

}

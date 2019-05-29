package com.hcl.bank.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.TransactionHistoryRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class BankingServiceImplTest {
	
	
	@Mock
	private TransactionHistoryRepository transaction;
	
	@Mock
	private AccountSummaryRepository account;
	
	@InjectMocks
	private BankingServiceImpl service;
	
	@Test
	public void makeTransaction() {
		
		
		FundTransferRequest request=new FundTransferRequest();
		request.setAccountNo(1L);
		request.setToAccountNo(2L);
		request.setAmount(50.0);
		
		AccountSummary summary1=new AccountSummary();
		summary1.setAccountNumber(1l);
		summary1.setAccountType("saving");
		summary1.setBalance(5000.0);
		summary1.setFullName("uday");
		
		AccountSummary summary=new AccountSummary();
		summary.setAccountNumber(2l);
		summary.setAccountType("saving");
		summary.setBalance(4000.0);
		summary.setFullName("uday");
		
		when(account.findByAccountNumber(1l)).thenReturn(summary1);
		when(account.findByAccountNumber(2l)).thenReturn(summary);
		
		FundTransferResponse response = service.makeTransaction(request);
		if(response!=null) {
			Integer statusCode = response.getStatusCode();
			Double code=Double.valueOf(""+statusCode);
			Assert.assertEquals(200.0, code);
		}
		
		
		
	}
	
	

}

package com.hcl.bank.app.service;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.dto.TransactionHistoryDto;
import com.hcl.bank.app.dto.TransactionHistoryResponse;
import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.TransactionHistory;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.TransactionHistoryRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)

public class BankingServiceImplTest {
	@Mock
	TransactionHistoryRepository transactionHistoryRepository;
	
	//private static final Logger logger=LogManager.getLogger(BankingServiceImplTest.class);
	
	@InjectMocks
	private BankingServiceImpl bankingServiceImpl;

	
	@Mock
	private TransactionHistoryRepository transaction;
	
	@Mock
	private AccountSummaryRepository account;
	
	@InjectMocks
	private BankingServiceImpl service;
	
	@Test
	public void TransactionHistory() {

		List<TransactionHistory> transactionHistoryList=new ArrayList<TransactionHistory>();
		TransactionHistory transactionHistory=new TransactionHistory();
		transactionHistory.setAccountNo(1l);
		transactionHistory.setAmount(100.0);
		transactionHistory.setClosingBalance(10.0);
		Date dt=new Date();
		transactionHistory.setCreateDt(dt);
		transactionHistory.setMonth(1);
		transactionHistory.setToAccountNo(1l);
		transactionHistory.setTransactionId(1l);
		transactionHistory.setTransactionType("credit");
		transactionHistory.setYear(1);
		transactionHistoryList.add(transactionHistory);
		Mockito.when(transactionHistoryRepository.findAll()).thenReturn(transactionHistoryList);
		TransactionHistoryDto transactionHistoryDto = new TransactionHistoryDto();
		transactionHistoryDto.setAccountNo(1l);
		transactionHistoryDto.setAmount(100.0);
		transactionHistoryDto.setClosingBalance(10.0);
		transactionHistoryDto.setCreateDt(dt);
		transactionHistoryDto.setMonth(1);
		transactionHistoryDto.setToAccountNo(1l);
		transactionHistoryDto.setTransactionId(1l);
		transactionHistoryDto.setTransactionType("credit");
		transactionHistoryDto.setYear(1);
		List<TransactionHistoryDto> TransactionHistoryDtoList=new ArrayList<TransactionHistoryDto>();
		TransactionHistoryDtoList.add(transactionHistoryDto);
		TransactionHistoryResponse transactionHistoryResponse=new TransactionHistoryResponse();
		transactionHistoryResponse.setList(TransactionHistoryDtoList);
		TransactionHistoryResponse TransactionHistoryResponse1=bankingServiceImpl.TransactionHistory();
		 Assert.assertEquals(TransactionHistoryResponse1.toString(),transactionHistoryResponse.toString());
			
	}
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
	
	@Test
	public void fetchAllAccountNumbersTest() {
		
		Long accountNumber=1l;
		
		List<Long> list=new ArrayList<Long>();
		list.add(2l);
		list.add(3l);
		
		when(account.findAllAccountNumbers(accountNumber)).thenReturn(list);
		List<Long> allAccountNumbers = service.fetchAllAccountNumbers(accountNumber);
		if(allAccountNumbers!=null && !allAccountNumbers.isEmpty()) {
			Double size=Double.valueOf(""+allAccountNumbers.size());
			Assert.assertEquals(2.0,size);
		}
		
		
	}
	
	

}


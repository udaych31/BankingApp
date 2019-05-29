package com.hcl.bank.app.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
*/import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bank.app.dto.TransactionHistoryDto;
import com.hcl.bank.app.dto.TransactionHistoryResponse;
import com.hcl.bank.app.entity.TransactionHistory;
import com.hcl.bank.app.repository.TransactionHistoryRepository;

@RunWith(MockitoJUnitRunner.class)

public class BankingServiceImplTest {
	@Mock
	TransactionHistoryRepository transactionHistoryRepository;
	
	//private static final Logger logger=LogManager.getLogger(BankingServiceImplTest.class);
	
	@InjectMocks
	private BankingServiceImpl bankingServiceImpl;
	

	@Test
	public void listbreach() {

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
	
	

}


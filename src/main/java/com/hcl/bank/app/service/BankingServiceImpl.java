package com.hcl.bank.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hcl.bank.app.dto.TransactionHistoryDto;
import com.hcl.bank.app.dto.TransactionHistoryResponse;
import com.hcl.bank.app.repository.TransactionHistoryRepository;


@Service
public class BankingServiceImpl implements BankingService {

	@Autowired
	TransactionHistoryRepository transactionHistoryRepository;
	@Override
	public TransactionHistoryResponse TransactionHistory() {
		TransactionHistoryResponse transactionHistoryResponse = new TransactionHistoryResponse();
		Logger log = LogManager.getLogger(BankingServiceImpl.class);
		try {
			List<com.hcl.bank.app.entity.TransactionHistory> transactionHistoryList= transactionHistoryRepository.findAll();
			List<com.hcl.bank.app.entity.TransactionHistory> transactionHistoryList1= transactionHistoryRepository.findall(new PageRequest(0,1));
				System.out.println(transactionHistoryList1.size());
			ArrayList<TransactionHistoryDto> transactionHistoryDtoList = new ArrayList<TransactionHistoryDto>();
			for (com.hcl.bank.app.entity.TransactionHistory transactionHistory : transactionHistoryList) {
				TransactionHistoryDto transactionHistoryDto = new TransactionHistoryDto();
				
				transactionHistoryDto.setAccountNo(transactionHistory.getAccountNo());
				transactionHistoryDto.setAmount(transactionHistory.getAmount());
				transactionHistoryDto.setClosingBalance(transactionHistory.getClosingBalance());
				transactionHistoryDto.setCreateDt(transactionHistory.getCreateDt());
				transactionHistoryDto.setMonth(transactionHistory.getMonth());
				transactionHistoryDto.setToAccountNo(transactionHistory.getToAccountNo());
				transactionHistoryDto.setTransactionId(transactionHistory.getTransactionId());
				transactionHistoryDto.setTransactionType(transactionHistory.getTransactionType());
				transactionHistoryDto.setYear(transactionHistory.getYear());
				
				transactionHistoryDtoList.add(transactionHistoryDto);

			}
			transactionHistoryResponse.setList(transactionHistoryDtoList);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return transactionHistoryResponse;
	}
}
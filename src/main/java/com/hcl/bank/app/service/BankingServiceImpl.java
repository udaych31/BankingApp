package com.hcl.bank.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.UserInfo;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.UserRepository;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.TransactionHistory;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.TransactionHistoryRepository;

@Service
public class BankingServiceImpl implements BankingService {
	
	private static final Logger logger=LogManager.getLogger(BankingServiceImpl.class);
	
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
	
	private TransactionHistoryRepository transactionHistoryRepository;

	@Override
	public FundTransferResponse makeTransaction(FundTransferRequest request) {
		FundTransferResponse response=null;
		try {
			response=new FundTransferResponse();
			
			if(request!=null) {
				
				AccountSummary account = accountSummaryRepository.findByAccountNumber(request.getAccountNo());
				
				if(account!=null && account.getBalance()>=request.getAmount()) {
					// payee account details and transaction details
					Long toAccountNo = request.getToAccountNo();
					AccountSummary accountSummary = accountSummaryRepository.findByAccountNumber(toAccountNo);
					if(accountSummary!=null) {
						Double balance = accountSummary.getBalance()+request.getAmount();
						accountSummary.setBalance(balance);
						
						Calendar cal=Calendar.getInstance();
						
						//payee transaction history
						TransactionHistory transaction=new TransactionHistory();
						transaction.setAccountNo(accountSummary.getAccountNumber());
						transaction.setAmount(request.getAmount());
						transaction.setClosingBalance(balance);
						transaction.setCreateDt(new Date());
						transaction.setToAccountNo(request.getAccountNo());
						transaction.setYear(cal.get(Calendar.YEAR));
						transaction.setMonth(cal.get(Calendar.MONTH)+1);
						transaction.setTransactionType("CREDIT");
						transactionHistoryRepository.save(transaction);
						
						
						//user transaction history
						Double closingBal=account.getBalance()-request.getAmount();
						
						TransactionHistory transactionHistory=new TransactionHistory();
						transactionHistory.setAccountNo(account.getAccountNumber());
						transactionHistory.setAmount(request.getAmount());
						transactionHistory.setClosingBalance(closingBal);
						transactionHistory.setCreateDt(new Date());
						transactionHistory.setToAccountNo(request.getToAccountNo());
						transactionHistory.setYear(cal.get(Calendar.YEAR));
						transactionHistory.setMonth(cal.get(Calendar.MONTH)+1);
						transactionHistory.setTransactionType("DEBIT");
						transactionHistoryRepository.save(transactionHistory);
						
						account.setBalance(closingBal);
						
						//update account details after transaction
						accountSummaryRepository.save(accountSummary);
						accountSummaryRepository.save(account);
						
						response.setMessage("Fund transfered successfully ...!");
						response.setStatus("SUCCESS");
						response.setStatusCode(200);
						
					}else {
						response.setStatusCode(404);
						response.setStatus("ACCOUNTNOTVALID");
						response.setMessage("Account does not exist, invalid account ...!");
					}
				
				}else {
					response.setStatusCode(51);
					response.setStatus("INSUFFICIENTFUNDS");
					response.setMessage("Insufficient funds in your account ...!");
				}
				
				
			
			}// outer if
			
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" makeTransaction :"+e.getMessage());
		}
		
		return response;
	}

}

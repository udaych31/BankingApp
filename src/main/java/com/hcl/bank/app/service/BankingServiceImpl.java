package com.hcl.bank.app.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hcl.bank.app.dto.AccountResponse;
import com.hcl.bank.app.dto.AccountSummaryRequest;
import com.hcl.bank.app.dto.FundTransferRequest;
import com.hcl.bank.app.dto.FundTransferResponse;
import com.hcl.bank.app.dto.OpenAccountResponse;
import com.hcl.bank.app.dto.TransactionHistoryDto;
import com.hcl.bank.app.dto.TransactionHistoryResponse;
import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.TransactionHistory;
import com.hcl.bank.app.entity.UserInfo;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.TransactionHistoryRepository;
import com.hcl.bank.app.repository.UserRepository;

@Service
public class BankingServiceImpl implements BankingService {
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountSummaryRepository accountSummaryRepository;

	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;

	@Override
	public AccountResponse getAccountDetails(String userName) {

		AccountResponse response = null;
		try {
			logger.info("Enter into account details");
			Optional<UserInfo> user = userRepository.findByUserNameAndRole(userName, "user");
			logger.debug("User details " + user.toString());
			if (user.isPresent()) {

				Optional<AccountSummary> summary = accountSummaryRepository.findById(user.get().getAccountNumber());
				logger.debug("Accoutn summary deatils" + summary.toString());
				if (summary.isPresent()) {
					response = new AccountResponse();
					response.setAccountNUmber(summary.get().getAccountNumber());
					response.setBalance(summary.get().getBalance());
					response.setName(summary.get().getFullName());

				}
			}
		}

		catch (Exception e) {

			logger.error(this.getClass().getName() + "  " + e.getMessage());
		}
		return response;

	}

	@Override
	public TransactionHistoryResponse TransactionHistory() {
		TransactionHistoryResponse transactionHistoryResponse = new TransactionHistoryResponse();
		Logger log = LogManager.getLogger(BankingServiceImpl.class);
		try {
			List<com.hcl.bank.app.entity.TransactionHistory> transactionHistoryList = transactionHistoryRepository
					.findAll();
			List<com.hcl.bank.app.entity.TransactionHistory> transactionHistoryList1 = transactionHistoryRepository
					.findall(new PageRequest(0, 1));
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

	public OpenAccountResponse openAccount(AccountSummaryRequest request) {

		OpenAccountResponse response = new OpenAccountResponse();

		AccountSummary summary = new AccountSummary();
		summary.setAccountType(request.getAccountType());
		summary.setAddress(request.getAddress());
		summary.setBalance(request.getBalance());
		summary.setCreateDt(new Date());
		summary.setEmailId(request.getEmailId());
		summary.setFullName(request.getFullName());
		summary.setGender(request.getGender());
		summary.setMobileNo(request.getMobileNo());
		summary.setUniqueId(request.getUniqueId());

		UserInfo userInfo = new UserInfo();
		Random random = new Random();
		int pwd = random.nextInt(100000);
		userInfo.setUserName(request.getFullName() + "123");
		userInfo.setPassword(request.getFullName() + "" + pwd);
		userInfo.setRole("user");
		userInfo.setCreateDt(new Date());
		AccountSummary summary1 = accountSummaryRepository.save(summary);

		if (summary1 != null) {
			userInfo.setAccountNumber(summary1.getAccountNumber());
			UserInfo user = userRepository.save(userInfo);
			response.setStatusCode(200);
			response.setStatus("SUCCESS");
			response.setMessage("Account opened with Account number " + summary1.getAccountNumber());
			response.setUserName(user.getUserName());
			response.setPassword(user.getPassword());
		}

		return response;
	}

	@Override
	public FundTransferResponse makeTransaction(FundTransferRequest request) {
		FundTransferResponse response = null;
		try {
			response = new FundTransferResponse();

			if (request != null) {

				AccountSummary account = accountSummaryRepository.findByAccountNumber(request.getAccountNo());

				if (account != null && account.getBalance() >= request.getAmount()) {
					// payee account details and transaction details
					Long toAccountNo = request.getToAccountNo();
					AccountSummary accountSummary = accountSummaryRepository.findByAccountNumber(toAccountNo);
					if (accountSummary != null) {
						Double balance = accountSummary.getBalance() + request.getAmount();
						accountSummary.setBalance(balance);

						Calendar cal = Calendar.getInstance();

						// payee transaction history
						TransactionHistory transaction = new TransactionHistory();
						transaction.setAccountNo(accountSummary.getAccountNumber());
						transaction.setAmount(request.getAmount());
						transaction.setClosingBalance(balance);
						transaction.setCreateDt(new Date());
						transaction.setToAccountNo(request.getAccountNo());
						transaction.setYear(cal.get(Calendar.YEAR));
						transaction.setMonth(cal.get(Calendar.MONTH) + 1);
						transaction.setTransactionType("CREDIT");
						transactionHistoryRepository.save(transaction);

						// user transaction history
						Double closingBal = account.getBalance() - request.getAmount();

						TransactionHistory transactionHistory = new TransactionHistory();
						transactionHistory.setAccountNo(account.getAccountNumber());
						transactionHistory.setAmount(request.getAmount());
						transactionHistory.setClosingBalance(closingBal);
						transactionHistory.setCreateDt(new Date());
						transactionHistory.setToAccountNo(request.getToAccountNo());
						transactionHistory.setYear(cal.get(Calendar.YEAR));
						transactionHistory.setMonth(cal.get(Calendar.MONTH) + 1);
						transactionHistory.setTransactionType("DEBIT");
						transactionHistoryRepository.save(transactionHistory);

						account.setBalance(closingBal);

						// update account details after transaction
						accountSummaryRepository.save(accountSummary);
						accountSummaryRepository.save(account);

						response.setMessage("Fund transfered successfully ...!");
						response.setStatus("SUCCESS");
						response.setStatusCode(200);

					} else {
						response.setStatusCode(404);
						response.setStatus("ACCOUNTNOTVALID");
						response.setMessage("Account does not exist, invalid account ...!");
					}

				} else {
					response.setStatusCode(51);
					response.setStatus("INSUFFICIENTFUNDS");
					response.setMessage("Insufficient funds in your account ...!");
				}

			} // outer if

		} catch (Exception e) {
			logger.error(this.getClass().getName() + " makeTransaction :" + e.getMessage());
		}

		return response;

	}

	@Override
	public List<Long> fetchAllAccountNumbers(Long accountNumber) {
		List<Long> list = new ArrayList<>();
		try {
			logger.debug("BankingServiceImpl -> fetchAllAccountNumbers calling...!");
			list = accountSummaryRepository.findAllAccountNumbers(accountNumber);
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " fetchAllAccountNumbers :" + e.getMessage());
		}
		return list;
	}

}

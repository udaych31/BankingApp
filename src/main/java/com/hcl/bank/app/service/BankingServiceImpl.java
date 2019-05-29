package com.hcl.bank.app.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.app.dto.AccountResponse;
import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.UserInfo;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.UserRepository;

@Service
public class BankingServiceImpl implements BankingService {
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccountSummaryRepository accountSummaryRepository;

	@Override
	public AccountResponse getAccountDetails(String userName) {

		AccountResponse response = null;
		try {
			logger.info("Enter into account details");
			Optional<UserInfo> user = userRepository.findByUserName(userName);
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
			
			logger.error(this.getClass().getName()+ "  "+e.getMessage());

		}

		return response;
	}
}

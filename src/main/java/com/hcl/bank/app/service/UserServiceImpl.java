package com.hcl.bank.app.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.app.entity.UserInfo;
import com.hcl.bank.app.repository.UserRepository;
import com.hcl.bank.app.util.InvalidCredentialsException;
import com.hcl.bank.app.util.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public Boolean login(String userName, String password) {
		logger.info("Enter into login screen");
		
		Optional<UserInfo> name = userRepository.findByUserName(userName);
		if (!name.isPresent())
			throw new UserNotFoundException("UserNotFound Exception");

		Optional<UserInfo> user = userRepository.findByUserNameAndPassword(userName, password);

		if (!user.isPresent())
			throw new InvalidCredentialsException("InvalidCredentialsException");

		return true;

	}
}

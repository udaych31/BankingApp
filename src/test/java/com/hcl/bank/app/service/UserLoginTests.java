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

import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.UserInfo;
import com.hcl.bank.app.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserLoginTests {
	
    @Mock
	UserRepository userRepository;
 
    @InjectMocks
    UserServiceImpl serviceImpl;
	
	@Test
	public void testLogin() {
		
		Optional<UserInfo> optional=Optional.empty();
		UserInfo info=new UserInfo();
		info.setAccountNumber(1L);
		info.setCreateDt(new Date());
		info.setPassword("madhurya");
		info.setRole("user");
		info.setUserId(1L);
		info.setUserName("suma");
		optional=Optional.ofNullable(info);
		
			
		Mockito.when(userRepository.findByUserName("suma")).thenReturn(optional);
		Mockito.when(userRepository.findByUserNameAndPassword("suma", "madhurya")).thenReturn(optional);
		
		Boolean response = serviceImpl.login("suma", "madhurya");
		
		Assert.assertEquals(true, response);
		
		
		
	}

}

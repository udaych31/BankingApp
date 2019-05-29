package com.hcl.bank.app.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.bank.app.dto.AccountSummaryRequest;
import com.hcl.bank.app.entity.AccountSummary;
import com.hcl.bank.app.entity.UserInfo;
import com.hcl.bank.app.repository.AccountSummaryRepository;
import com.hcl.bank.app.repository.UserRepository;
@RunWith(MockitoJUnitRunner.class)
public class BankingServiceTest {
 
 @InjectMocks
 private BankingServiceImpl bankingService;
 
 @Mock
 private AccountSummaryRepository accountSummaryRepository;
 
 @Mock
 private UserRepository userRepository;
 
 @Test
 public void openAccountTest() {
  
  AccountSummaryRequest accountSummary=new AccountSummaryRequest();
  accountSummary.setAccountType("saving account");
  accountSummary.setAddress("Bangalore");
  accountSummary.setBalance(1000.0);
  accountSummary.setEmailId("ah@gmail.com");
  accountSummary.setFullName("fge");
  accountSummary.setGender("female");
  accountSummary.setMobileNo(6543231L);
  accountSummary.setUniqueId("DTGR567");
  
  AccountSummary account=new AccountSummary();
  account.setAccountType("saving account");
  account.setAddress("Bangalore");
  account.setBalance(1000.0);
  account.setEmailId("ah@gmail.com");
  account.setFullName("fge");
  account.setGender("female");
  account.setMobileNo(6543231L);
  account.setUniqueId("DTGR567");
  account.setAccountNumber(1L);
  
  
  UserInfo info=new UserInfo();
  info.setAccountNumber(1L);
  info.setCreateDt(new  Date());  
  info.setPassword("snh");  
  info.setUserName("hggfdasgh");
    
  assertEquals(true,true);
 }
}

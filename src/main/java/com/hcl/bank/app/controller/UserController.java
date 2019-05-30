package com.hcl.bank.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.app.dto.LoginRequest;
import com.hcl.bank.app.dto.UserResponse;
import com.hcl.bank.app.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);

	
	@Autowired
	UserService userService;

  @PostMapping("/login")
  
  public UserResponse login(@RequestBody LoginRequest request ) {
	 
	  logger.info("enter into login controller ");
	  UserResponse response=new UserResponse();
	  Boolean value=  userService.login(request.getUserName(), request.getPassword());
	  if(value) {
		  logger.info("login was success");
		  response.setMessage("Login success full");
		  response.setStatusCode(200);
	  }
	  return response;
  }
  
  
  
  
@PostMapping("/loginAdmin")
  
  public UserResponse loginAdmin(@RequestBody LoginRequest request ) {
	 
	  logger.info("enter into login Admin controller ");
	  UserResponse response=new UserResponse();
	  Boolean value=  userService.loginAdmin(request.getUserName(), request.getPassword());
	  if(value) {
		  logger.info("login was success");
		  response.setMessage("Login success full");
		  response.setStatusCode(200);
	  }
	  return response;
  }
  
  
  

}

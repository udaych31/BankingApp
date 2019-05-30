package com.hcl.bank.app.dto;

import java.io.Serializable;

import com.hcl.bank.app.util.Response;

public class OpenAccountResponse extends Response implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private String userName;
	private String password;
	
	public OpenAccountResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

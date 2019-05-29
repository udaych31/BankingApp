package com.hcl.bank.app.dto;

import java.io.Serializable;

import com.hcl.bank.app.util.Response;

public class OpenAccountResponse extends Response implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public OpenAccountResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}

package com.hcl.bank.app.util;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	
	private String status;
	
	public Response() {
		super();
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}

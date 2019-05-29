package com.hcl.bank.app.util;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	
	private String message;
	
	public Response() {
		super();
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [statusCode=");
		builder.append(statusCode);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
	

}

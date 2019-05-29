package com.hcl.bank.app.util;

public class ExceptionResponse {

	private String errorMsg;
	
	private String requestUri;
	
	public ExceptionResponse() {
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	
}

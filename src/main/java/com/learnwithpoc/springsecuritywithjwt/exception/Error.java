package com.learnwithpoc.springsecuritywithjwt.exception;

public class Error {

	private String message;
	private String errorCode;
	private String details;

	public Error(String message, String errorCode, String details) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getDetails() {
		return details;
	}
	
	

}

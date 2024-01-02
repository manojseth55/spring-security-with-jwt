package com.learnwithpoc.springsecuritywithjwt.exception;

public class InvalidJwtTokenException extends Exception {

	public static final long serialVersionUID = 1L;

	public InvalidJwtTokenException(String message) {
		super(message);
	}
}

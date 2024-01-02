package com.learnwithpoc.springsecuritywithjwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidJwtTokenException.class)
	public ResponseEntity<Error> invalidJwtTokenException(InvalidJwtTokenException exception) {
		return new ResponseEntity<>(
				new Error("Invalid Jwt Token Error", HttpStatus.UNAUTHORIZED.name(), exception.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}

}

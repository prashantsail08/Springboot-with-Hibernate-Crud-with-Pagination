package com.assignment.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/*if id not found in service controller then orElseThrow
	method throw here it will give response */
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public String HandelResourceNotFoundException(ResourceNotFoundException ex) {
	
		
		return ex.getMessage();
	}
}

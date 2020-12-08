package com.example.hospitalfrontdesk.exception;

import org.springframework.http.HttpStatus;

public class ClientErrorException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -58475313844943572L;

	public ClientErrorException(String message, HttpStatus status) {
		super(message);
	}
	
	

}

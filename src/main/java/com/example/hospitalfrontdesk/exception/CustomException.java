package com.example.hospitalfrontdesk.exception;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		 ExceptionResponse exceptionResponse = 
				 new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		 return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({HospitalNotFoundException.class, SpecialistNotFoundException.class})
	public final ResponseEntity<Object> handleHospitalNotFoundException(Exception ex, WebRequest request){
		 ExceptionResponse exceptionResponse = 
				 new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		 return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ClientErrorException.class)
	public final ResponseEntity<Object> handleClientErrorException(HttpClientErrorException ex, WebRequest request){
		ExceptionResponse exceptionResponse = 
				 new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		if(ex.getStatusCode()==HttpStatus.NOT_FOUND) {
			return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
		}
		
		else if(ex.getStatusCode()==HttpStatus.BAD_REQUEST) {
			return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		}
		return null;
		
		
		
	}

}

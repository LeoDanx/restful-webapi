package com.angelehl.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.angelehl.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<errorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception{
		
		errorDetails errDetails = new errorDetails(LocalDateTime.now(), ex.getLocalizedMessage(),request.getDescription(false));
		
		return new ResponseEntity<errorDetails>(errDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<errorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
		
		errorDetails errDetails = new errorDetails(LocalDateTime.now(), ex.getLocalizedMessage(),request.getDescription(false));
		
		return new ResponseEntity<errorDetails>(errDetails,HttpStatus.NOT_FOUND);
	}
}

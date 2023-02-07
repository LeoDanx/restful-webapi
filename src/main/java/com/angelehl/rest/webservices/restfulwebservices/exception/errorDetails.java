package com.angelehl.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class errorDetails {
	
	//timestamp
	
	private LocalDateTime timestamp;
	private String message;
	private String details;
	
	public errorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "errorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

}

package com.spring.exception;

public class NoIdFoundException  extends RuntimeException{
	private String message = " data for given id not found";
	
	public NoIdFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public NoIdFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
 
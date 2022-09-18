package com.spring.exception;

public class NoDataFoundForGivenNameException extends RuntimeException{
private String message = "no data  found in DataBase";
	
	public NoDataFoundForGivenNameException() {
		// TODO Auto-generated constructor stub
	}
	
	public NoDataFoundForGivenNameException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

package com.spring.exception;

public class NoDataFoundInDataBaseException extends RuntimeException{
private String message = "no data  found in DataBase";
	
	public NoDataFoundInDataBaseException() {
		// TODO Auto-generated constructor stub
	}
	
	public NoDataFoundInDataBaseException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

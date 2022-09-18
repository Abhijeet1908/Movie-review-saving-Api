package com.spring.exception;

public class NoDataFoundForGivenRatingException extends RuntimeException{
private String message = "no data  found in DataBase";
	
	public NoDataFoundForGivenRatingException() {
		// TODO Auto-generated constructor stub
	}
	
	public NoDataFoundForGivenRatingException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

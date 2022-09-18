package com.spring.exception;

public class MovieNotSavedException extends RuntimeException {
private String message = "Movie not saved please check the values entered";
	
	public MovieNotSavedException() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieNotSavedException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

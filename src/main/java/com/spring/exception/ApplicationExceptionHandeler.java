package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.responseStructure.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandeler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdFoundExceptionHandler(NoIdFoundException ie) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No data found");
		responseStructure.setData(ie.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MovieNotSavedException.class)
	public ResponseEntity<ResponseStructure<String>> movieNotSavedExceptionHandler(MovieNotSavedException ie) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("Empty or invalid entries made");
		responseStructure.setData(ie.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = NoDataFoundInDataBaseException.class)
	public ResponseEntity<ResponseStructure<String>> noDataFoundInDataBaseExceptionHandler(
			NoDataFoundInDataBaseException ie) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Empty or invalid entries made");
		responseStructure.setData(ie.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoDataFoundForGivenNameException.class)
	public ResponseEntity<ResponseStructure<String>> noDataFoundForGivenNameExceptionHandler(
			NoDataFoundForGivenNameException ie) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No data for given name found");
		responseStructure.setData(ie.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoDataFoundForGivenRatingException.class)
	public ResponseEntity<ResponseStructure<String>> noDataFoundForGivenRatingExceptionHandeler(
			NoDataFoundForGivenRatingException ie) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No data for given rating found");
		responseStructure.setData(ie.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}

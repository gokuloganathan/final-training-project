package com.supermarket.billing.ExceptionCentral;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralBillErrorHandler {

	@Autowired
	Environment environment;
	
	@ExceptionHandler(BillNotFoundException.class)
	public ResponseEntity<BillErrorInfo> billNotFoundExceptionHandler(){
		BillErrorInfo error = new BillErrorInfo();
		error.setErrorCode(HttpStatus.NO_CONTENT.value());
		error.setErrorMessage(environment.getProperty("Bill_Not_Found_Exception"));
		error.setTimestampDateTime(LocalDateTime.now());
		
		return new ResponseEntity<BillErrorInfo>(error,HttpStatus.NOT_FOUND);
	}
}

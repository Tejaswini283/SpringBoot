package com.deloitte.demospringtool.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.deloitte.demospringtool.util.ErrorResponse;
import com.deloitte.demospringtool.util.ProductNotFoundException;

@RestController
@ControllerAdvice

public class ProductErrorController extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundError(Exception ex,WebRequest req){
	ErrorResponse response=new ErrorResponse(new Date(),ex.getMessage(),req.getDescription(false));
  return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
		  
}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllError(Exception ex,WebRequest req){
	ErrorResponse response=new ErrorResponse(new Date(),ex.getMessage(),req.getDescription(false));
  return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
		  
}
}

package com.ekarudianto.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ekarudianto.service.ApiErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandling {
	
	protected Logger logger;
	
	public GlobalExceptionHandling() {
		logger = LoggerFactory.getLogger(getClass());
	}
	
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> notAllowedException(HttpServletRequest request, Exception ex) {
		
		logger.error("Requested URL=" + request.getRequestURL());
		logger.error(ex.toString());

		ApiErrorResponse apiResponse = new ApiErrorResponse(
				HttpServletResponse.SC_METHOD_NOT_ALLOWED, 
				HttpStatus.METHOD_NOT_ALLOWED, 
				ex.getLocalizedMessage(), 
				ex.toString()
		);
		
		return new ResponseEntity<Object>(apiResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }
	
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	public ResponseEntity<Object> notFoundException(HttpServletRequest request, Exception ex) {
//		
//		logger.error("Requested URL=" + request.getRequestURL());
//		logger.error(ex.toString());
//
//		ApiErrorResponse apiResponse = new ApiErrorResponse(
//				HttpServletResponse.SC_NOT_FOUND, 
//				HttpStatus.NOT_FOUND, 
//				ex.getLocalizedMessage(), 
//				ex.toString()
//		);
//		
//		return new ResponseEntity<Object>(apiResponse, HttpStatus.METHOD_NOT_ALLOWED);
//    }
}

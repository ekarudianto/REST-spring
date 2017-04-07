package com.ekarudianto.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ekarudianto.service.ApiErrorResponseService;

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

		ApiErrorResponseService apiResponse = new ApiErrorResponseService(
				HttpStatus.METHOD_NOT_ALLOWED, 
				ex.getLocalizedMessage(),
				HttpServletResponse.SC_METHOD_NOT_ALLOWED, 
				ex.toString()
		);
		
		return new ResponseEntity<Object>(apiResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> notFoundException(HttpServletRequest request, Exception ex) {
		
		logger.error("Requested URL=" + request.getRequestURL());
		logger.error(ex.toString());

		ApiErrorResponseService apiResponse = new ApiErrorResponseService(
				HttpStatus.NOT_FOUND, 
				ex.getLocalizedMessage(),
				HttpServletResponse.SC_NOT_FOUND, 
				ex.toString()
		);
		
		return new ResponseEntity<Object>(apiResponse, HttpStatus.NOT_FOUND);
    }
	
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<Object> unsupportedMediaTypeException(HttpServletRequest request, Exception ex) {
		
		logger.error("Requested URL=" + request.getRequestURL());
		logger.error(ex.toString());
		
		ApiErrorResponseService apiResponse = new ApiErrorResponseService(
				HttpStatus.UNSUPPORTED_MEDIA_TYPE,
				ex.getLocalizedMessage(),
				HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
				ex.toString()
		);
		
		return new ResponseEntity<Object>(apiResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> badRequestException(HttpServletRequest request, Exception ex) {
		
		logger.error("Requested URL=" + request.getRequestURL());
		logger.error(ex.toString());

		ApiErrorResponseService apiResponse = new ApiErrorResponseService(
				HttpStatus.BAD_REQUEST,
				ex.getLocalizedMessage(),
				HttpServletResponse.SC_BAD_REQUEST,
				ex.toString()
		);
		
		return new ResponseEntity<Object>(apiResponse, HttpStatus.BAD_REQUEST);
	}
}

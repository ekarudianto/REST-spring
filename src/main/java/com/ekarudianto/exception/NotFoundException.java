package com.ekarudianto.exception;

public class NotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public NotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public NotFoundException() {
		super();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}

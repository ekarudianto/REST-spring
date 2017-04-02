package com.ekarudianto.service;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {
	private HttpStatus status;
    private String message;
    private String errors;
    private int code;
 
    public ApiErrorResponse(int code, HttpStatus status, String message, String errors) {
        super();
        this.code = code;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
    
    public int getCode() {
    	return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
    
    public String getErros() {
    	return errors;
    }

    @Override
    public String toString() {
        return "ApiErrorResponse{" +
        		"code=" + code +
                ", status=" + status +
                ", message=" + message +
                ", erros=" + errors +
                '}';
    }
}

package com.javatpoint.exceptionhandling;

public class ErrorResponse {

	private int statusCode;
    private String message;
 
	/*
	 * public ErrorResponse(int i, String message) { super(); this.message =
	 * message; }
	 */

	public ErrorResponse(int value, String message2) {
		super();
		this.message = message2;
		this.statusCode = value;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}

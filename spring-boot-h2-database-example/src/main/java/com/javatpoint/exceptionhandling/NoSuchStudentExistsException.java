package com.javatpoint.exceptionhandling;

public class NoSuchStudentExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public NoSuchStudentExistsException() {}

	public NoSuchStudentExistsException(String msg) {
        super(msg);
        this.message = msg;
    }

}

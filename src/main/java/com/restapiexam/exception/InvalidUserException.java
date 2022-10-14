package com.restapiexam.exception;

public class InvalidUserException extends RuntimeException {

	public InvalidUserException(String mess) {
		super(mess);
	}

	public InvalidUserException(Throwable ex) {
		super(ex);
	}

	public InvalidUserException(String message, Throwable ex) {
		super(message, ex);
	}

}

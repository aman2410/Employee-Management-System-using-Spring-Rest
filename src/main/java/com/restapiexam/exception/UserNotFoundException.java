package com.restapiexam.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String mess) {
		super(mess);
	}

	public UserNotFoundException(Throwable ex) {
		super(ex);
	}

	public UserNotFoundException(String mess, Throwable ex) {
		super(mess, ex);
	}

}

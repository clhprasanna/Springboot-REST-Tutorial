package com.mjc.rest.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
        super("User Notfound Exception");
    }

	
}

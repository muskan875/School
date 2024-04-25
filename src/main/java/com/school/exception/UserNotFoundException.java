package com.school.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		super("User Not Found Exception");
	}
	
public UserNotFoundException(String msg) {
		super(msg);
	}
}

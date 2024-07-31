package com.profile.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException() {
		super("Data not found");
	}
	
	public DataNotFoundException(String msg) {
		super("Data not found: "+msg);
	}

}

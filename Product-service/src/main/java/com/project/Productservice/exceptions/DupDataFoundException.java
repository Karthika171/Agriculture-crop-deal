package com.project.Productservice.exceptions;

public class DupDataFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DupDataFoundException(String message) {
		super(message);
	}
}

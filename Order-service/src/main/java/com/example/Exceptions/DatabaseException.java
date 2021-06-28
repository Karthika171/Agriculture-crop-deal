package com.example.Exceptions;

public class DatabaseException extends RuntimeException {

	public DatabaseException() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Sorry!No Orders details available.";
	}

}

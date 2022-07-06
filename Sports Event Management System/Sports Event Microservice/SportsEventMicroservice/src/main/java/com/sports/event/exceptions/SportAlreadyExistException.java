package com.sports.event.exceptions;

/*
 *  Class for handling SportAlreadyExistException
 *  */

public class SportAlreadyExistException extends RuntimeException {

	/**
	 * Constructor
	 * 
	 * @param message
	 */

	public SportAlreadyExistException(String message) {
		super(message);
	}
}

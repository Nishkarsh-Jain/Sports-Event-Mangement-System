package com.sports.event.exceptions;

/*
 *  Class for handling EventAlreadyExistException
 *  */

public class EventAlreadyExistException extends RuntimeException {

	/**
	 * Constructor
	 * 
	 * @param message
	 */

	public EventAlreadyExistException(String message) {
		super(message);
	}
}

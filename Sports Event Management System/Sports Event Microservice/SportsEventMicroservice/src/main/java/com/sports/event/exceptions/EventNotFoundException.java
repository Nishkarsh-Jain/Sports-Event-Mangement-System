package com.sports.event.exceptions;

/*
 *  Class for handling EventNotFoundException
 *  */

public class EventNotFoundException extends RuntimeException {

	/**
	 * Constructor
	 * 
	 * @param message
	 */

	public EventNotFoundException(String message) {
		super(message);
	}
}

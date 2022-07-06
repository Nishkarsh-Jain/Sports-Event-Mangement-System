package com.sports.event.exceptions;

/*
 *  Class for handling SportNotFoundException
 *  */

public class SportsNotFoundException extends RuntimeException {

	public SportsNotFoundException(String message) {
		/**
		 * Constructor
		 * 
		 * @param message
		 */
		super(message);
	}
}

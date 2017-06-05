package org.ricamn.user.application;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5683462894072110900L;

	public UserNotFoundException(String message) {
		super(message);
	}

}

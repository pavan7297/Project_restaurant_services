package com.restaurent.exceptions;

@SuppressWarnings("serial")
public class DataNotFoundException extends Exception {
	/**
	 * Constructs a DataNotFoundException using the given exception message.
	 *
	 * @param message The message explaining the reason for the exception
	 */
	public DataNotFoundException(String description) {
		super(description);
	}

	/**
	 * Constructs a DataNotFoundException using the given message and underlying
	 * cause.
	 *
	 * @param cause The underlying cause.
	 */
	public DataNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a DataNotFoundException using the given message and underlying
	 * cause.
	 *
	 * @param message The message explaining the reason for the exception.
	 * @param cause   The underlying cause.
	 */
	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}

package com.dobmob.dobsliding.exceptions;

public class NoActionBarException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7650056147012180569L;

	public NoActionBarException() {
		super();
	}

	public NoActionBarException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public NoActionBarException(String detailMessage) {
		super(detailMessage);
	}

	public NoActionBarException(Throwable throwable) {
		super(throwable);
	}

}

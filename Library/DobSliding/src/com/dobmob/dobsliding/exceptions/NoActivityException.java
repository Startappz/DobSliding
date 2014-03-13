package com.dobmob.dobsliding.exceptions;

public class NoActivityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6667928019305324280L;

	public NoActivityException() {
		super();
	}

	public NoActivityException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public NoActivityException(String detailMessage) {
		super(detailMessage);
	}

	public NoActivityException(Throwable throwable) {
		super(throwable);
	}

}

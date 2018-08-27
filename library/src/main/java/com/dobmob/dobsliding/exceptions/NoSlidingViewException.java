package com.dobmob.dobsliding.exceptions;

public class NoSlidingViewException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7441385082527922432L;

	public NoSlidingViewException() {
		super();
	}

	public NoSlidingViewException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public NoSlidingViewException(String detailMessage) {
		super(detailMessage);
	}

	public NoSlidingViewException(Throwable throwable) {
		super(throwable);
	}

}

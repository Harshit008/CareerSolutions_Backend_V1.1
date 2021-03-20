package com.zensar.exception;

public class MailException extends Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MailException(String exMessage, Exception exception) {
	        super(exMessage, exception);
	    }

	    public MailException(String exMessage) {
	        super(exMessage);
	    }
}

package com.scheduler.exceptions;

@SuppressWarnings("serial")
public class NoRoomAvailableException extends Exception {
	public NoRoomAvailableException(String errMsg) {
		super(errMsg);
	}
}

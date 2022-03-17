package com.scheduler.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String errMsg) {
		super(errMsg);
	}
}

package com.scheduler.exceptions;

@SuppressWarnings("serial")
public class ResourceConflictException extends Exception {
	public ResourceConflictException(String errMsg) {
		super(errMsg);
	}
}

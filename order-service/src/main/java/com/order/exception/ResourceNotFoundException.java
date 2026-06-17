package com.order.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
	
	public ResourceNotFoundException()
	{
		super("resource not found");
	}

}

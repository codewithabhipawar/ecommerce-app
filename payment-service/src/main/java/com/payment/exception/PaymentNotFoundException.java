package com.payment.exception;

public class PaymentNotFoundException extends RuntimeException{
	
	public PaymentNotFoundException(String message)
	{
		super(message);
	}
	
	public PaymentNotFoundException()
	{
		super("payment not found!!");
	}

}

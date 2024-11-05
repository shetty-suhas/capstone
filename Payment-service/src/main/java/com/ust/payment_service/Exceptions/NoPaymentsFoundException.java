package com.ust.payment_service.Exceptions;

public class NoPaymentsFoundException extends Throwable{ 
	public NoPaymentsFoundException(String message){  
		super(message);
	}
}

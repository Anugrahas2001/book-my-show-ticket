package com.demo.myticketexception;

public class InsufficientAmountException extends RuntimeException{
	
	public InsufficientAmountException(String message) {
		super(message);
	}

}

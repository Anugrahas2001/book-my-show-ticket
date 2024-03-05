package com.demo.myticketexception;

import com.demo.myticket.entity.Ticket;

public class IdNotFoundException extends RuntimeException{

	String message="Id Not Found";
	
	public IdNotFoundException()
	{
		
	}
	public IdNotFoundException(String message)
	{
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;

	}
	
}

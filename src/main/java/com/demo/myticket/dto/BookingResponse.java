package com.demo.myticket.dto;

import com.demo.myticket.entity.Ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponse {

	private String status;
	private double totalFare;
	private Ticket ticket;
	

}

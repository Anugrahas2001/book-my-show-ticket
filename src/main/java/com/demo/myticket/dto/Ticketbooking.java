package com.demo.myticket.dto;

import com.demo.myticket.entity.PaymentInfo;
import com.demo.myticket.entity.Ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticketbooking {
private Ticket ticket;
private PaymentInfo paymentInfo;
}

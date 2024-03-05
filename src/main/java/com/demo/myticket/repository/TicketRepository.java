package com.demo.myticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.myticket.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}

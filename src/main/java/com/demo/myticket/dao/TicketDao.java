package com.demo.myticket.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.myticket.dto.Ticketbooking;
import com.demo.myticket.entity.Ticket;
import com.demo.myticket.entity.UserInfo;
import com.demo.myticket.repository.TicketRepository;
import com.demo.myticket.repository.UserRepository;
import com.demo.myticket.service.EmailSenderService;

@Repository
public class TicketDao {
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailSenderService senderService;

	public Ticket save(Ticket ticket) {
		senderService.sendMail("anugrahas0017@gmail.com", "Tickets", "Tickets booked");
		return ticketRepository.save(ticket);

	}

	public List<Ticket> getTicketsByUserId(int userId) {
		Optional<UserInfo> users = userRepository.findById(userId);
		if (users.isPresent()) {
			return users.get().getTicket();
		} else {
			return null;
		}
	}

}

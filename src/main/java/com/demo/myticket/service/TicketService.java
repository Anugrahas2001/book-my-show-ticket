package com.demo.myticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.myticket.dao.TicketDao;
import com.demo.myticket.dto.BookingResponse;
import com.demo.myticket.dto.ResponseStructure;
import com.demo.myticket.dto.Ticketbooking;
import com.demo.myticket.entity.Movie;
import com.demo.myticket.entity.PaymentInfo;
import com.demo.myticket.entity.Screen;
import com.demo.myticket.entity.Ticket;
import com.demo.myticket.entity.UserInfo;
import com.demo.myticket.repository.MovieRepository;
import com.demo.myticket.repository.PaymentInfoRepository;
import com.demo.myticket.repository.ScreenRepository;
import com.demo.myticket.repository.UserRepository;
import com.demo.myticket.util.PaymentUtils;

@Service
@Transactional
public class TicketService {

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private PaymentInfoRepository paymentRepository;

	// Save Ticket
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(int userId, int screenId, int movieId,
			Ticketbooking ticket) {
		ResponseStructure<Ticket> response = new ResponseStructure<Ticket>();

		Ticket tickets = ticket.getTicket();

		int seatNum = tickets.getSeatNum();
		Optional<UserInfo> user = userRepository.findById(userId);
		if (user.isPresent()) {
			Optional<Screen> screen = screenRepository.findById(screenId);
			if (screen.isPresent()) {
				Optional<Movie> movie = movieRepository.findById(movieId);
				if (movie.isPresent()) {
					if (seatNum < screen.get().getCapacity()) {

						tickets.setUser(user.get());
						tickets.setScreen(screen.get());
						tickets.setMovie(movie.get());
						Ticket savedTicket = ticketDao.save(tickets);

						PaymentInfo paymentInfo = ticket.getPaymentInfo();

						PaymentUtils.validateCredentialLimit(paymentInfo.getAccountNum(), tickets.getTicketfare());
						paymentInfo.setTicketId(tickets.getTicketId());
						paymentInfo.setAmount(tickets.getTicketfare());
						paymentRepository.save(paymentInfo);

						response.setMessage("PAYMENT SUCCESS.");
						response.setStatusCode(HttpStatus.OK.value());

						// Decrease the screen capacity
						int newCapacity = screen.get().getCapacity() - seatNum;
						Screen screens = screen.get();
						screens.setCapacity(newCapacity);
						screenRepository.save(screens);

						response.setData(savedTicket);
						response.setMessage("Ticket booked successfully.");
						response.setStatusCode(HttpStatus.OK.value());

						return new ResponseEntity<>(response, HttpStatus.OK);
					} else {
						response.setMessage("Seat number exceeds the screen capacity.");
						response.setStatusCode(HttpStatus.BAD_REQUEST.value());
					}
				}
			}
		}

		response.setMessage("User, screen, or movie not found.");
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Ticket>>> getTicketsByUserId(int userId) {
		List<Ticket> ticket = ticketDao.getTicketsByUserId(userId);
		if (ticket != null) {

			ResponseStructure<List<Ticket>> responsestructure = new ResponseStructure<List<Ticket>>();
			responsestructure.setStatusCode(HttpStatus.FOUND.value());
			responsestructure.setMessage("List of ticktes retrived");
			responsestructure.setData(ticket);
			return new ResponseEntity<ResponseStructure<List<Ticket>>>(responsestructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}
}
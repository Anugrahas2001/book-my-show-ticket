package com.demo.myticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myticket.dto.ResponseStructure;
import com.demo.myticket.dto.Ticketbooking;
import com.demo.myticket.entity.Ticket;
import com.demo.myticket.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/myticket/api")
@EnableTransactionManagement
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Operation(description = "To Book Tickets", summary = "Tickets will be saved in the database")
	@ApiResponses(value = { @ApiResponse(description = "Ticket Booked", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	
	@PostMapping("/tickets/{userId}/{screenId}/{movieId}")
	public ResponseEntity<ResponseStructure<Ticket>> bookTickets(
			@PathVariable int userId,
            @PathVariable int screenId,
            @PathVariable int movieId,
            @RequestBody Ticketbooking ticket)
	{
		return ticketService.saveTicket(userId, screenId, movieId,ticket);
	}
	
	@Operation(description = "Specified User id's list of tickets retrieved from the database", summary = "Display user booked tickets")
	@ApiResponses(value = { @ApiResponse(description = "OK", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	
	@GetMapping("/tickets/{userId}")
	public ResponseEntity<ResponseStructure<List<Ticket>>> getTicketsByUserId(@PathVariable int userId)
	{
		return ticketService.getTicketsByUserId(userId);
	}
	
	
	
}

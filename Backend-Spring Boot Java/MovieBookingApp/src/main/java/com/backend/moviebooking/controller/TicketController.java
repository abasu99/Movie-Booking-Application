package com.backend.moviebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.moviebooking.model.Movie;
import com.backend.moviebooking.model.Ticket;
import com.backend.moviebooking.service.AuthService;
import com.backend.moviebooking.service.MovieService;
import com.backend.moviebooking.service.TicketService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1.0/ticketbooking")
public class TicketController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/book/{movieId}")
	public ResponseEntity<?> bookTicket(@RequestHeader("Authorization") String jwt, 
			@PathVariable("movieId") int movieId, @RequestBody Ticket ticket)
	{
		if(jwt.length()>0 && authService.validateJwt(jwt)) {
		Movie m1=movieService.getMovieById(movieId);
		if(m1!=null) {
		int avail=m1.getAvailableSeats();
		m1.setAvailableSeats(avail-ticket.getBookedSeats()); //data added to movie table
		
		ticket.setMovieId_fk(m1.getMovieId());
		ticket.setAvailableSeats(avail-ticket.getBookedSeats());
		ticket.setMovieName(m1.getMovieName());
		
		ticket.setTotalSeats(m1.getTotalSeats());
		ticket.setBookedSeats(ticket.getBookedSeats());
		
		ticket.setTotalPrice(m1.getPrice()*ticket.getBookedSeats());
		ticket.setUserName(ticket.getUserName());
		ticket.setBookingDateTime(ticket.getBookingDateTime());
		
		if(movieService.updateMovie(m1) && ticketService.bookTicket(ticket)) {
			return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
		}
		}
		return new ResponseEntity<String>("ticket cannot be booked", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Jwt validation failed",HttpStatus.UNAUTHORIZED);

	}
	
	@GetMapping("/tickets/{userName}")
	public ResponseEntity<?> getMyTickets(@RequestHeader("Authorization") String jwt, 
			@PathVariable("userName") String userName)
	{
		if(jwt.length()>0 && authService.validateJwt(jwt)) {
			List<Ticket> myTickets= ticketService.getTicketsByUserName(userName);
			if(myTickets!=null) {
				return new ResponseEntity<List<Ticket>>(myTickets,HttpStatus.OK);
			}
			return new ResponseEntity<String>("No Tickets booked",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Jwt validation failed",HttpStatus.UNAUTHORIZED);
	}
	

}

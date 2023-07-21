package com.backend.moviebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.moviebooking.model.Ticket;
import com.backend.moviebooking.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets(int movieId) {
		// TODO Auto-generated method stub
		return ticketRepository.getTicketList(movieId);
	}

	@Override
	public boolean bookTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket ticketObj=new Ticket();
		
//		int avail=ticket.getAvailableSeats();
		
		ticketObj.setMovieId_fk(ticket.getMovieId_fk());
		ticketObj.setAvailableSeats(ticket.getAvailableSeats());
		ticketObj.setMovieName(ticket.getMovieName());
		
		ticketObj.setTotalSeats(ticket.getTotalSeats());
		ticketObj.setBookedSeats(ticket.getBookedSeats());
		
		ticketObj.setTotalPrice(ticket.getTotalPrice());
		ticketObj.setBookingDateTime(ticket.getBookingDateTime());
		ticketObj.setUserName(ticket.getUserName());
		
		ticketRepository.saveAndFlush(ticketObj);
		return true;
	}

	@Override
	public boolean deleteTicket(int movieId) {
		ticketRepository.deleteTicketData(movieId);
		return true;
	}

	@Override
	public List<Ticket> getTicketsByUserName(String userName) {
		// TODO Auto-generated method stub
		return ticketRepository.getTicketsByUserName(userName);
	}
	
	

}

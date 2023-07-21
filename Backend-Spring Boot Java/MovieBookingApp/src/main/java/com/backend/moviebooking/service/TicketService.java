package com.backend.moviebooking.service;

import java.util.List;

import com.backend.moviebooking.model.Ticket;


public interface TicketService {
	
	public List<Ticket> getAllTickets(int movieId);
	public boolean bookTicket(Ticket ticket);
	public boolean deleteTicket(int movieId);
	public List<Ticket> getTicketsByUserName(String userName);

}

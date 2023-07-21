package com.backend.moviebooking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;

@Entity
public class Movie {
	
	@Id
	private int movieId;
	
	private String movieName;
	private String theatreName;
	
	private int totalSeats;
	
	private int availableSeats;
	
	public int price;
	
	
	@OneToMany(cascade = CascadeType.DETACH,targetEntity= Ticket.class)
	private List<Ticket> ticketDetails;
	
	//private int seatsBooked;
	
	public Movie() {}
	
	
	public Movie(int movieId, String movieName, String theatreName, int totalSeats, int availableSeats) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
	}
	
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public List<Ticket> getTicketDetails() {
		return ticketDetails;
	}
	public void setTicketDetails(List<Ticket> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	/*public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}*/
	
	
	

}

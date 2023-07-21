package com.backend.moviebooking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.backend.moviebooking.exceptions.DuplicateMovieException;
import com.backend.moviebooking.model.Movie;
import com.backend.moviebooking.model.Ticket;
import com.backend.moviebooking.service.AuthService;
import com.backend.moviebooking.service.MovieService;
import com.backend.moviebooking.service.TicketService;


@SpringBootTest
public class MovieControllerTest {
	
	@Mock
	private MovieService movieService;
	
	@Mock
	private TicketService ticketService;
	
	@Mock
	private AuthService authorizationService;
	
	@InjectMocks
	private MovieController movieController;
	
	@Test
	public void testGetAllMovies() {
		
		List<Movie> movieList=new ArrayList<Movie>();
		
		List<Ticket> tic=new ArrayList<Ticket>();
		
		Movie m1=new Movie(1001, "Pathaan", "Inox", 100, 100);
		Movie m2=new Movie(1002, "Mirzapur","PVR",100,100);
		
		movieList.add(m1);
		movieList.add(m2);
		
		when(authorizationService.validateJwt("jwt")).thenReturn(true);
		
		when(ticketService.getAllTickets(1001)).thenReturn(tic);
		when(ticketService.getAllTickets(1002)).thenReturn(tic);
		
		when(movieService.getAllMovies()).thenReturn(movieList);
		
		
		assertEquals(new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK), movieController.getAllMovies("jwt"));
		
		
	}
	
	
	@Test
	public void testAddMovie() throws DuplicateMovieException{
		
		List<Ticket> tic=new ArrayList<Ticket>();
		
		Movie m1=new Movie(1001, "Sonar Kella","Inox",100,100);
		
		when(authorizationService.validateJwt("jwt")).thenReturn(true);
		
		when(movieService.addMovie(m1)).thenReturn(m1);
		
		assertEquals(new ResponseEntity<Movie>(m1,HttpStatus.CREATED), movieController.addMovie("jwt", m1));
		
		
	}
	

}

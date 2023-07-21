package com.backend.moviebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.moviebooking.exceptions.DuplicateMovieException;
import com.backend.moviebooking.model.Movie;
import com.backend.moviebooking.model.Ticket;
import com.backend.moviebooking.service.AuthService;
//import com.backend.moviebooking.service.KafkaProducerService;
import com.backend.moviebooking.service.MovieService;
import com.backend.moviebooking.service.TicketService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1.0/moviebooking")
public class MovieController {
	
	@Autowired
	private MovieService movieService;  //upcasting done to maintain abstraction
	
	@Autowired
	private TicketService ticketService;
	
//	@Autowired
//	private KafkaProducerService kps;
	
	@Autowired
	private AuthService authService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllMovies(@RequestHeader("Authorization") String jwt)
	{
		if(jwt.length()>0 && authService.validateJwt(jwt)) {
		List<Movie> movieList = movieService.getAllMovies();
		if(movieList!=null) {
			for(Movie m:movieList) 
			{
				List<Ticket> ticketList=ticketService.getAllTickets(m.getMovieId());
				m.setTicketDetails(ticketList);
			}
			return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Movie List is empty",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Jwt validation failed",HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/admin/addmovie")
	public ResponseEntity<?> addMovie(@RequestHeader("Authorization") String jwt, @RequestBody Movie movie) throws DuplicateMovieException
	{
		if(jwt.length()>0 && authService.validateJwt(jwt)) {
		Movie movie1= movieService.addMovie(movie);
		
		if(movie1!=null) {
			
			String msg="New movie added. \n Movie Id:"+movie1.getMovieId()
			+"\n Movie Name: "+movie1.getMovieName()
			+"\n Theatre Name: "+movie1.getTheatreName();
			
//			kps.setData(msg);
			return new ResponseEntity<Movie>(movie1,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Movie already exists",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Jwt validation failed",HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/movies/search/{movieId}")
	public ResponseEntity<?> getMovieById(@RequestHeader("Authorization") String jwt, @PathVariable("movieId") int movieId)
	{
		if(jwt.length()>0 && authService.validateJwt(jwt)) {
		Movie movieObj = movieService.getMovieById(movieId);
		if(movieObj!=null) {
			List<Ticket> ticketList=ticketService.getAllTickets(movieObj.getMovieId());
			movieObj.setTicketDetails(ticketList);
			
			return new ResponseEntity<Movie>(movieObj,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Movie not found",HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<String>("Jwt validation failed",HttpStatus.UNAUTHORIZED);
	}
	
	
	@GetMapping("/search/{movieName}")
	public ResponseEntity<?> getMovieByName(@RequestHeader("Authorization") String jwt, @PathVariable("movieName") String movieName)
	{
		if(jwt.length()>0 && authService.validateJwt(jwt)) {
		Movie movieObj = movieService.getMovieByMovieName(movieName);
		if(movieObj!=null) {
//			List<Ticket> ticketList=ticketService.getAllTickets(movieObj.getMovieId());
//			movieObj.setTicketDetails(ticketList);
			
			return new ResponseEntity<Movie>(movieObj,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Movie not found",HttpStatus.NO_CONTENT);
	}
		return new ResponseEntity<String>("Jwt validation failed",HttpStatus.UNAUTHORIZED);
	}
	
	
	@DeleteMapping("/admin/delete/{movieId}")
	public ResponseEntity<?> deleteMovie(@RequestHeader("Authorization") String jwt, @PathVariable("movieId") int movieId) 
	{
		if(jwt.length()>0 && authService.validateJwt(jwt)) {
		if(ticketService.deleteTicket(movieId) & movieService.deleteMovie(movieId)) {
			
			String msg="Movie Id: "+ movieId + " deleted";
			
//			kps.setData(msg);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<String>("Movie & ticket record cannot be deleted",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Jwt validation failed",HttpStatus.UNAUTHORIZED);	
	}
	
	@PutMapping("/updateMovie")
	public ResponseEntity<?> updateBook(@RequestHeader("Authorization") String jwt, @RequestBody Movie movie) 
	{
		if(jwt.length()>0 && authService.validateJwt(jwt)) {
	  if(movieService.updateMovie(movie))
	  {
		  return new ResponseEntity<Movie>(movie, HttpStatus.OK);
		  
	  }
	  return new ResponseEntity<String>("book could not be updated", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<String>("Jwt validation failed",HttpStatus.UNAUTHORIZED);
}
}

package com.backend.moviebooking.service;

import java.util.List;

import com.backend.moviebooking.exceptions.DuplicateMovieException;
import com.backend.moviebooking.model.Movie;

public interface MovieService {
	
	public List<Movie> getAllMovies();
	public Movie addMovie(Movie movie) throws DuplicateMovieException;
	public boolean deleteMovie(int movieId);
	
	public Movie getMovieById(int movieId);
	public boolean updateMovie(Movie movie);
	
	public Movie getMovieByMovieName(String movieName);

}

package com.backend.moviebooking.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.backend.moviebooking.exceptions.DuplicateMovieException;
import com.backend.moviebooking.model.Movie;
import com.backend.moviebooking.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList=movieRepository.findAll();
		if(movieList!=null && movieList.size()>0) {
			return movieList;
		}
		return null;
	}

	@Override
	public Movie addMovie(Movie movie) throws DuplicateMovieException {
		Optional<Movie> movieObj = movieRepository.findById(movie.getMovieId());
		
		if(movieObj.isPresent())
		{
			throw new DuplicateMovieException();
		}
		return movieRepository.saveAndFlush(movie);
	}

	@Override
	public boolean deleteMovie(int movieId) {
		movieRepository.deleteById(movieId);
		return true;
	}

	@Override
	public Movie getMovieById(int movieId) {
		Optional<Movie> movie = movieRepository.findById(movieId);
		if(movie.isPresent())
		{
			return movie.get();
		}
		
		return null;
	}

	@Override
	public boolean updateMovie(Movie movie) {
		Movie movie1 = movieRepository.getById(movie.getMovieId());
		if(movie1!=null)
		{
			movie1.setMovieName(movie.getMovieName());
			movie1.setTheatreName(movie.getTheatreName());
			movie1.setPrice(movie.getPrice());
			
			movieRepository.saveAndFlush(movie1);
			return true;
		}

		return false;
	}

	@Override
	public Movie getMovieByMovieName(String movieName) {
		// TODO Auto-generated method stub
		return movieRepository.getMovieByName(movieName);
	}

}

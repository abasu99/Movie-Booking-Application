package com.backend.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.moviebooking.model.Movie;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	@Query("select m from Movie m where m.movieName= :movieName")
	public Movie getMovieByName(String movieName);

}

package com.backend.moviebooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.backend.moviebooking.model.Movie;
import com.backend.moviebooking.repository.MovieRepository;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieServiceImplTest {
	
	@Mock
	private MovieRepository movieRepository;
	
	@InjectMocks
	private MovieServiceImpl movieServiceImpl;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(movieServiceImpl).build();
	}
	
	
	
	@Test
	public void getAllMoviesSuccess() throws Exception{
		List<Movie> expectedMovieList=new ArrayList<>();

		expectedMovieList.add(new Movie(1,"Tom & Jerry","Phoenix Theatre",100,100));
		
		when(movieRepository.findAll()).thenReturn(expectedMovieList);
		
		List<Movie> actualMovieList=movieServiceImpl.getAllMovies();
		assertEquals(expectedMovieList, actualMovieList);
	}
	
	@Test
	public void getAllMoviesFailure() throws Exception{
		
		List<Movie> m1=new ArrayList<>();

		when(movieRepository.findAll()).thenReturn(m1);
		
//		assertThrows(NoMoviePresentException.class,()->{
//			movieServiceImpl.getAllMovies();
//		});
		
		List<Movie> actualMovieList=movieServiceImpl.getAllMovies();
		assertNull(actualMovieList);
	}
	
	@Test
	public void addMovieSuccess() throws Exception{
		
		Movie expectedMovie=new Movie(1,"Tom & Jerry","Phoenix Theatre",100,100);
		when(movieRepository.saveAndFlush(any())).thenReturn(expectedMovie);
		
		Movie actualMovie=movieServiceImpl.addMovie(expectedMovie);
		assertEquals(expectedMovie, actualMovie);
	}
	
	

}

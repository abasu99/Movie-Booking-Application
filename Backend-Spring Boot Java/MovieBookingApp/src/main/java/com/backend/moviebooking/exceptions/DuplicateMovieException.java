package com.backend.moviebooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Movie already exists")
public class DuplicateMovieException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

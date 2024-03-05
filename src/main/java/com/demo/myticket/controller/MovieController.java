package com.demo.myticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myticket.dto.ResponseStructure;
import com.demo.myticket.entity.Movie;
import com.demo.myticket.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/myticket/api")
public class MovieController {
	
	@Autowired
	private MovieService movieservice;
	
	@Operation(description = "To Create Movie info", summary = "Movie will be saved in the database")
	@ApiResponses(value = { @ApiResponse(description = "Movie Created", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	
	@PostMapping("/movies/{theatreId}")
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(@RequestBody Movie movie,@PathVariable int theatreId)
	{
		return movieservice.saveMovie(movie,theatreId);
	}
	
	@Operation(description = "Specified Movie id's details retrieved from the database", summary = "Display movie details")
	@ApiResponses(value = { @ApiResponse(description = "OK", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<ResponseStructure<Movie>> getMovieById(@PathVariable int movieId)
	{
		return movieservice.getMovieById(movieId);
	}

}

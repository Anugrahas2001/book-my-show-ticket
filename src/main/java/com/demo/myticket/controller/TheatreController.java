package com.demo.myticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myticket.dto.ResponseStructure;
import com.demo.myticket.entity.Theatre;
import com.demo.myticket.service.TheatreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/myticket/api")
public class TheatreController {
	@Autowired
	private TheatreService theatreService;
	
	@Operation(description = "To Create Theatre info", summary = "Theatre will be saved in the database")
	@ApiResponses(value = { @ApiResponse(description = "Theatre Created", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	
	@PostMapping("/usertheares")
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestBody Theatre theatre)
	{
		return theatreService.saveTheatre(theatre);
	}

	@Operation(description = "Specified Movie id's and City id's list of theatres retrieved from the database", summary = "Display  list of Theatres")
	@ApiResponses(value = { @ApiResponse(description = "OK", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	
	@GetMapping("/theatres/{movieId}/{cityId}")
	public ResponseEntity<ResponseStructure<List<Theatre>>> getTheatresByMovieAndCity(
            @PathVariable int movieId,
            @PathVariable int cityId)
	{
		return theatreService.getTheatresByMovieAndCity(movieId, cityId);
	}
}

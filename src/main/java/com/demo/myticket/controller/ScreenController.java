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
import com.demo.myticket.entity.Screen;
import com.demo.myticket.service.ScreenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/myticket/api")
public class ScreenController {

	@Autowired
	private ScreenService screenService;

	@Operation(description = "To Create Screen info", summary = "Screen will be saved in the database")
	@ApiResponses(value = { @ApiResponse(description = "Screen Created", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	
	@PostMapping("/screens/{theatreId}")
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(@RequestBody Screen screen,
			@PathVariable int theatreId) {
		return screenService.saveScreen(screen, theatreId);
	}

	@Operation(description = "Specified screen id's details retrieved from the database", summary = "Display screen details")
	@ApiResponses(value = { @ApiResponse(description = "OK", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	
	@GetMapping("/screens/{screenId}")
	public ResponseEntity<ResponseStructure<Screen>> getScreenById(@PathVariable int screenId) {
		return screenService.getScreenById(screenId);
	}

}

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
import com.demo.myticket.entity.UserInfo;
import com.demo.myticket.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/myticket/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//save User

	@Operation(description = "To Create User info", summary = "User will be saved in the database")
	@ApiResponses(value = { @ApiResponse(description = "User Created", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<UserInfo>> saveUser(@Valid @RequestBody UserInfo user)
	{
		return userService.saveUser(user);
	}


	@Operation(description = "Specified User id's details retrieved from the database", summary = "Display user details")
	@ApiResponses(value = { @ApiResponse(description = "OK", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@GetMapping("/user/{userId}")
	public ResponseEntity<ResponseStructure<UserInfo>> getUser(@PathVariable int userId)
	{
		return userService.getUser(userId);
	}
}

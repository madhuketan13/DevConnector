package com.dnb.devconnector.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devconnector.dto.DevConnector;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@PostMapping("/create")
	public DevConnector createProfile(@RequestBody DevConnector user) {
		return user;
		
	}

}

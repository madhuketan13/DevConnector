package com.dnb.devconnector.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devconnector.dto.Education;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

	@PostMapping("/create")
	public Education createEducation(@RequestBody Education education) {
		return education;
		
	}
}

package com.coronavirus.main.controller;

import com.coronavirus.main.service.StatsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {
	@Autowired
	StatsService statsService;

	@GetMapping("/endpoints")
	public String stats() {
		return statsService.getEndpoints();
	}

	@GetMapping("/summary")
	public String summary() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(statsService.getSummary());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@GetMapping("/records")
	public String records() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(statsService.getRecordsSpain());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
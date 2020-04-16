package com.coronavirus.main.controller;

import com.coronavirus.main.service.StatsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {
	@GetMapping("/endpoints")
	public String stats() {
		StatsService stats = new StatsService();
		return stats.getEndpoints();
	}
}
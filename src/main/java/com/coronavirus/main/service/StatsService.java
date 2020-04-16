package com.coronavirus.main.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatsService {
	private final String baseUrl = "https://api.covid19api.com";
	private final RestTemplate restTemplate;

	public StatsService() {
		this.restTemplate = new RestTemplate();
	}

	public String getEndpoints() {
		return this.restTemplate.getForObject(this.baseUrl, String.class);
	}

	public Map getSummary() {
		return this.restTemplate.getForObject(this.baseUrl + "/summary", Map.class);
	}
}
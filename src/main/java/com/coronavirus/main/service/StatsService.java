package com.coronavirus.main.service;

import com.coronavirus.main.model.stats.Record;
import com.coronavirus.main.model.stats.Summary;

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

	public Summary getSummary() {
		return this.restTemplate.getForObject(this.baseUrl + "/summary", Summary.class);
	}

	public Record[] getRecordsSpain() {
		return this.restTemplate.getForObject(this.baseUrl + "/dayone/country/spain", Record[].class);
	}
}
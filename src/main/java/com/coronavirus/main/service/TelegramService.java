package com.coronavirus.main.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramService {
	@Value("${bot.url}")
	private String baseUrl;
	private final RestTemplate restTemplate;

	public TelegramService() {
		this.restTemplate = new RestTemplate();
	}

	public void sendMessage(int chatId, String text) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		Map<String, Object> map = new HashMap<>();
		map.put("chat_id", chatId);
		map.put("text", text);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		String url = this.baseUrl + "/sendMessage";

		restTemplate.postForEntity(url, entity, Map.class);
	}
}
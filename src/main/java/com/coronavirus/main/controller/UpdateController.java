package com.coronavirus.main.controller;

import com.coronavirus.main.model.update.Update;
import com.coronavirus.main.service.UpdateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {
	@Autowired
	UpdateService updateService;

	@GetMapping("/")
	public String health() {
		return "OK";
	};

	@PostMapping("/webhook")
	public void webhook(@RequestBody Update update) {
		try {
			updateService.handleUpdate(update);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
package com.coronavirus.main.service;

import java.util.ArrayList;

import com.coronavirus.main.model.update.Update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
	@Autowired
	TelegramService telegramService;

	@Autowired
	MessageService messageService;

	public void handleUpdate(Update update) {
		ArrayList<String> messages = new ArrayList<String>();

		if (this.isCommand(update)) {
			switch (update.message.text) {
				case "/global":
					messages = messageService.getSummaryMessage();
					break;
				case "/historico":
					messages = messageService.getRecordsSpainMessage();
					break;
				case "/actual":
					messages = messageService.getActualSpainMessage();
					break;
			}
		} else {
			messages.add("Usa \"/\" para ver los comandos disponibles");
		}

		for (String message : messages) {
			this.telegramService.sendMessage(update.message.chat.id, message);
		}
	}

	public boolean isCommand(Update update) {
		if (update.message.entities != null && update.message.entities[0].type.equals("bot_command")) {
			return true;
		} else {
			return false;
		}
	}
}
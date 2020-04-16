package com.coronavirus.main.service;

import com.coronavirus.main.model.update.Update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
	@Autowired
	TelegramService telegramService;

	public void handleUpdate(Update update) {
		if (this.isCommand(update)) {
			if (update.message.text == "/global") {
				this.telegramService.sendMessage(update.message.chat.id, "GLOBAL");
			} else if (update.message.text == "/historico") {
				this.telegramService.sendMessage(update.message.chat.id, "HISTORICO");
			} else if (update.message.text == "/actual") {
				this.telegramService.sendMessage(update.message.chat.id, "ACTUAL");
			}
		} else {
			this.telegramService.sendMessage(update.message.chat.id, "Usa \"/\" para ver los comandos disponibles");
		}
	}

	public boolean isCommand(Update update) {
		System.out.println(update.message.entities[0].type);

		if (update.message.entities != null && update.message.entities[0].type == "bot_command") {
			return true;
		} else {
			return false;
		}
	}
}
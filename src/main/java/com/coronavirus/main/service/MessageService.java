package com.coronavirus.main.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.coronavirus.main.model.stats.Global;
import com.coronavirus.main.model.stats.Record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	StatsService statsService;

	public ArrayList<String> getSummaryMessage() {
		ArrayList<String> messages = new ArrayList<String>();
		Global global = statsService.getSummary().getGlobal();

		String infected = new StringBuilder().append("😷 Infectados:").append("\n").append("- Recientes: ")
				.append(global.getNewConfirmed()).append("\n").append("- Totales: ").append(global.getTotalConfirmed())
				.toString();

		String deaths = new StringBuilder().append("💀 Muertes:").append("\n").append("- Recientes: ")
				.append(global.getNewDeaths()).append("\n").append("- Totales: ").append(global.getTotalDeaths())
				.toString();

		String recovered = new StringBuilder().append("😊 Recuperados:").append("\n").append("- Recientes: ")
				.append(global.getNewRecovered()).append("\n").append("- Totales: ").append(global.getTotalRecovered())
				.toString();

		messages.add(infected);
		messages.add(deaths);
		messages.add(recovered);

		return messages;
	}

	public ArrayList<String> getRecordsSpainMessage() {
		ArrayList<String> messages = new ArrayList<String>();
		Record[] records = statsService.getRecordsSpain();

		for (Record record : records) {
			messages.add(this.getRecordMessage(record));
		}

		return messages;
	}

	public ArrayList<String> getActualSpainMessage() {
		ArrayList<String> messages = new ArrayList<String>();
		Record[] records = statsService.getRecordsSpain();

		Record record = records[records.length - 1];

		messages.add(this.getRecordMessage(record));

		return messages;
	}

	public String getRecordMessage(Record record) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return new StringBuilder().append("📆 Fecha: ").append(dateFormat.format(record.getDate())).append("\n")
				.append("😷 Infectados: ").append(record.getConfirmed()).append("\n").append("💀 Muertes: ")
				.append(record.getDeaths()).append("\n").append("😊 Recuperados: ").append(record.getRecovered())
				.toString();
	}
}
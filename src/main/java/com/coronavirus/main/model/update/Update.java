package com.coronavirus.main.model.update;

public class Update {
	public int update_id;
	public Message message;

	public String getText() {
		return this.message.text;
	}
}
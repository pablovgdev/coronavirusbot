package com.coronavirus.main.model.update;

import java.util.Date;

public class Message {
	public int message_id;
	public User from;
	public Chat chat;
	public Date date;
	public String text;
	public Entity[] entities;
}
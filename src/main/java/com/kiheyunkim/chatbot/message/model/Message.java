package com.kiheyunkim.chatbot.message.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	@Column(name = "question", nullable = false, unique = true, length = 30)
	private String question;
	@Column(name = "message", nullable = false, unique = true, length = 30)
	private String message;

	public Message() {
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}

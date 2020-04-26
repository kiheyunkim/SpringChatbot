package com.kiheyunkim.chatbot.message.model;

public class Message {
	private String question;
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

package com.kiheyunkim.chatbot.message.dao;

public interface MessageDao {
	String getAnswer(String question);
	Boolean setMessage(String question, String answer);
}

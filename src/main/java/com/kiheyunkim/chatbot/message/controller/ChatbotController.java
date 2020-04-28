package com.kiheyunkim.chatbot.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class ChatbotController {

	@GetMapping(value = "/")
	public String Initial(ModelMap model) {
		return "thymeleaf/Client.html";
	}
}

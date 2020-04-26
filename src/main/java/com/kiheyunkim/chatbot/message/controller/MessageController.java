package com.kiheyunkim.chatbot.message.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kiheyunkim.chatbot.message.dao.MessageDao;

@Controller
@RequestMapping("/message")
public class MessageController {

	private final MessageDao messageDao;
	
	public MessageController(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@RequestMapping(value = "/get",params = "question")
	@ResponseBody
	public Map<String, Object> getAnswer(@RequestParam("question")String question) {
		String answer = messageDao.getAnswer(question);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result",answer == null ? "등록된 답변이 없습니다." : answer);			
		
		return result;
	}
	
	@PostMapping(value = "/add",params = {"question", "answer"})
	@ResponseBody
	public Map<String, Object> addAnswer(@RequestParam("question")String question, @RequestParam("answer")String answer) {
		Boolean isSuccess = messageDao.setMessage(question, answer);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result",isSuccess ? "등록에 성공하였습니다" : "등록에 실패하였습니다");			
		
		return result;
	}
	
	@GetMapping(value="/hi",params="test")
	@ResponseBody
	public Map<String, Object> Hi(@RequestParam("test")String test) {
		System.out.println("hi");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result",test);			
		
		return result;
	}
}
package com.kiheyunkim.chatbot.message.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kiheyunkim.chatbot.message.dao.MessageDao;

@Controller
@RequestMapping("/message")
public class MessageController {

	private final MessageDao messageDao;
	
	public MessageController(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@PostMapping(value = "/get")
	@ResponseBody
	public Map<String, Object> processingMessage(@RequestBody HashMap<String,Object> receive) {
		String received = (String)receive.get("question");
		System.out.println(received);
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(received == null || received.length() == 0) {
			result.put("result","잘못된 접근입니다.");
			return result;
		}
		
		if(received.charAt(0) == '$') {	//Command
			String[] splits = received.split("\\,");
			if(splits.length != 3 ||
				!splits[0].equals("$add")) {
				result.put("result","잘못된 접근입니다.");
				return result;
			}
			
			if(splits[1].length() > 30 ||
				splits[2].length() > 30) {
				result.put("result","등록 요청한 질문이나 답변의 길이가 너무 깁니다.");
				return result;
			}
			
			
			String question = splits[1] , answer= splits[2];
			Boolean setResult = messageDao.setMessage(question, answer);
			if(setResult) {
				result.put("result","등록되었습니다.");
			}
			else {
				result.put("result","등록에 실패했습니다.");
			}
			
			return result;
		}
		else {
			String answer = messageDao.getAnswer(received);
			result.put("result", answer == null ? "질문에 대한 답변이 없습니다. \"$add,질문,답변\" 으로 전송하면 등록됩니다." : answer);			
			
			return result;			
		}
	}
}
package com.demochatbot.conversation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demochatbot.conversation.model.GenericMessage;
import com.demochatbot.conversation.serviceImpl.ConversationServiceImpl;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@RestController
@RequestMapping("/v1/chatbot/conversation")
public class ConvertationController {

	@Autowired
	ConversationServiceImpl conversationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String messageResponse() {
		return "test";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public MessageResponse messageResponse(@RequestBody GenericMessage msg) {
		return conversationService.sendMessage(msg);
	}
	
}
package com.demochatbot.ella.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demochatbot.ella.App;
import com.demochatbot.ella.design.message.adapter.EllaMessageClassAdapter;
import com.demochatbot.ella.fb.model.Event;
import com.demochatbot.ella.fb.model.Message;
import com.demochatbot.ella.model.GenericMessage;
import com.demochatbot.ella.model.GenericOutPut;
import com.demochatbot.ella.service.ConversationService;
import com.demochatbot.ella.service.impl.ConversationServiceImpl;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@RestController
@RequestMapping("/v1/chatbot/ella")
public class EllaController {
	private static Logger LOG = LoggerFactory.getLogger(EllaController.class);
	@Autowired
	private ConversationServiceImpl conversationService;
	@Autowired
	private EllaMessageClassAdapter msgAdapter;
	@PostMapping(value="/")
	public MessageResponse fbInput(@RequestBody GenericMessage msg) {
		MessageResponse messageResponse = conversationService.getMessageResponse(msg);
		LOG.info("conversation response {}",messageResponse);
		
		return messageResponse;
	}
	
	@PostMapping(value="/fb")
	public Message getEventFb(@RequestBody GenericMessage msg) {
		MessageResponse messageResponse = conversationService.getMessageResponse(msg);		
		return msgAdapter.getFbMessage(messageResponse);
	}
}

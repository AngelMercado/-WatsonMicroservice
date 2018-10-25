package com.demochatbot.ella.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demochatbot.ella.client.ConversationFeingClient;
import com.demochatbot.ella.fb.model.Message;
import com.demochatbot.ella.model.GenericMessage;
import com.demochatbot.ella.service.ConversationService;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;
@Service
public class ConversationServiceImpl implements ConversationService{

	@Autowired
	private ConversationFeingClient conversationFeingClient;
	@Override
	public MessageResponse getMessageResponse(GenericMessage genericMessage) { 
		return conversationFeingClient.getMessageResponse(genericMessage);
	}

	

}

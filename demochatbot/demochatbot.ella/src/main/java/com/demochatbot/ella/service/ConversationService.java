package com.demochatbot.ella.service;

import org.springframework.stereotype.Service;

import com.demochatbot.ella.fb.model.Message;
import com.demochatbot.ella.model.GenericMessage;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;


public interface ConversationService {
	MessageResponse getMessageResponse(GenericMessage genericMessage);
	
}

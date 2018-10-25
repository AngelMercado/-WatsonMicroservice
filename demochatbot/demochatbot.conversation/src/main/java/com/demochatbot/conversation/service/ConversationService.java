package com.demochatbot.conversation.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demochatbot.conversation.model.GenericMessage;
import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

public interface ConversationService {
	MessageResponse sendMessage(GenericMessage msg);
}

package com.demochatbot.conversation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demochatbot.conversation.config.ServiceConfig;
import com.demochatbot.conversation.model.GenericMessage;
import com.demochatbot.conversation.service.ConversationService;
import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@Service
public class ConversationServiceImpl implements ConversationService{
	@Autowired
	Assistant assistant;
	@Autowired
	ServiceConfig serviceConfig;
	
	@Override
	public MessageResponse sendMessage(GenericMessage msg) {
		InputData input = new InputData.Builder(msg.getText()).build();
		MessageOptions options = new MessageOptions.Builder(serviceConfig.getWorkSpaceName()).input(input).build();
		MessageResponse response = assistant.message(options).execute();
		return response;
	}
	public Assistant getAssistant() {
		return assistant;
	}
	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}
	public ServiceConfig getServiceConfig() {
		return serviceConfig;
	}
	public void setServiceConfig(ServiceConfig serviceConfig) {
		this.serviceConfig = serviceConfig;
	}
	
}

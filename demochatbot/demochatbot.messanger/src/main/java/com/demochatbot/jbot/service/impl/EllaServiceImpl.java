package com.demochatbot.jbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demochatbot.ella.model.GenericMessage;
import com.demochatbot.jbot.client.EllaFeingClient;
import com.demochatbot.jbot.core.facebook.models.Message;
import com.demochatbot.jbot.service.EllaService;

@Service
public class EllaServiceImpl implements EllaService{

	@Autowired
	EllaFeingClient ellaFeingClient;
	@Override
	public Message getMessageResponse(GenericMessage genericMessage) {
		
		return ellaFeingClient.getMessageResponse(genericMessage);
	}

}

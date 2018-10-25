package com.demochatbot.ella.design.message.adapter;

import com.demochatbot.ella.fb.model.Message;
import com.demochatbot.ella.model.GenericMessage;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

public interface EllaMessageAdapter {

	Message getFbMessage(MessageResponse genericMessage);
	MessageResponse getWatsonMessage(Object genericMessage);
}

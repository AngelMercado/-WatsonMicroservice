package com.demochatbot.ella.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demochatbot.ella.fb.model.Message;
import com.demochatbot.ella.model.GenericMessage;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@FeignClient("conversation")
public interface ConversationFeingClient {
	@RequestMapping(value="v1/chatbot/conversation",method=RequestMethod.POST,consumes="application/json")
	MessageResponse getMessageResponse(@RequestBody GenericMessage genericMessage);
}

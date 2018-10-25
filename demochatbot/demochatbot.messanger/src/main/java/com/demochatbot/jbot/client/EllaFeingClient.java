package com.demochatbot.jbot.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demochatbot.ella.model.GenericMessage;
import com.demochatbot.jbot.core.facebook.models.Message;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@FeignClient("ella")
public interface EllaFeingClient {
	@RequestMapping(value="v1/chatbot/ella/fb",method=RequestMethod.POST,consumes="application/json")
	Message getMessageResponse(@RequestBody GenericMessage genericMessage);
}

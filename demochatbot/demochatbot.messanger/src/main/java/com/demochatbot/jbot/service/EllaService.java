package com.demochatbot.jbot.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.demochatbot.ella.model.GenericMessage;
import com.demochatbot.jbot.core.facebook.models.Message;

public interface EllaService {
	Message getMessageResponse(@RequestBody GenericMessage genericMessage);
}

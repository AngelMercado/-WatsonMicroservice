package com.demochatbot.conversation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;

@Configuration
public class AssistantConfiguration {

	@Autowired
	ServiceConfig serviceConfig;
	
	@Bean
	@Primary
	public Assistant assistant() {
		Assistant assistant = new Assistant("2018-09-20");
		assistant.setUsernameAndPassword(serviceConfig.getUserName(), serviceConfig.getPassword());
		return assistant;
	}
}

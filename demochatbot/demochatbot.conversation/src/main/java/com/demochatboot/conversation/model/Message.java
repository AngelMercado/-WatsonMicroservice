package com.demochatboot.conversation.model;

import com.ibm.watson.developer_cloud.assistant.v1.model.MessageInput;

public class Message extends MessageInput{

	String username;
	String source;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
}

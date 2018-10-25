package com.demochatbot.ella.model;

import com.ibm.watson.developer_cloud.assistant.v1.model.MessageInput;

public class GenericMessage {

	String username;
	String source;
	String text;
	
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}

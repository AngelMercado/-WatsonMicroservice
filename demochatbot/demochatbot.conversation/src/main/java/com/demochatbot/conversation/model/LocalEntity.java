package com.demochatbot.conversation.model;

import  com.ibm.watson.developer_cloud.assistant.v1.model.Entity;
public class LocalEntity extends Entity{
	Long idEntity;

	public Long getId() {
		return idEntity;
	}

	public void setId(Long id) {
		this.idEntity = id;
	}		
	
}

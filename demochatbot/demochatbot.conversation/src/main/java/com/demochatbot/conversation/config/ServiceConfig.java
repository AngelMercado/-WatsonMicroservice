package com.demochatbot.conversation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	@Value("${watson.authentication.url}")
	private String uRL;
	@Value("${watson.authentication.username}")
	private String userName;
	@Value("${watson.authentication.password}")
	private String password;
	@Value("${watson.workspace1.name}")
	private String workSpaceName;
	public String getuRL() {
		return uRL;
	}
	public void setuRL(String uRL) {
		this.uRL = uRL;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWorkSpaceName() {
		return workSpaceName;
	}
	public void setWorkSpaceName(String workSpaceName) {
		this.workSpaceName = workSpaceName;
	}
	
	
}

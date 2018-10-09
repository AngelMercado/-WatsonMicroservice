package com.chatbot.userservice.service;

import com.chatbot.userservice.model.User;


public interface UserService {
	User createUser(User user);
	User getUserByUsername(String username);
}

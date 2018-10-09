package com.chatbot.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.userservice.model.User;
import com.chatbot.userservice.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@RequestMapping("/{username}")
	public User getUserByName(@PathVariable String username) {
		LOG.debug("Entering the user-server-controller");
		return userService.getUserByUsername(username);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public User createUser( @RequestBody User user) {
		return userService.createUser(user);
	}
}

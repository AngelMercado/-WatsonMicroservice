package com.chatbot.userservice.service.Impl;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot.userservice.model.Role;
import com.chatbot.userservice.model.User;
import com.chatbot.userservice.model.UserRole;
import com.chatbot.userservice.repository.UserRepository;
import com.chatbot.userservice.service.UserService;
import com.chatbot.userservice.utility.SecurityUtility;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		//valid id user with the username exists
		User userVo = getUserByUsername(user.getUsername());
		
		if (userVo != null) {
			LOG.info("User with username {} already exists. Nothing will be done", user.getUsername());
		}else {
			Set<UserRole> userRoles =  new HashSet<>();
			Role localRole = new Role();
			localRole.setRoleId(1);
			userRoles.add(new UserRole(user, localRole));
			user.getUserRoles().addAll(userRoles);
			
			Date today = new Date(0);
			user.setJoinDate(today);
			user.setUserRoles(userRoles);
			
			String encryptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
			user.setPassword(encryptedPassword);
			userVo = userRepository.save(user);
			
			
		}
		
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		
		return userRepository.findByusername(username);
	}

}

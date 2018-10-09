package com.chatbot.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.chatbot.userservice.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByusername(String username);
	
	
	
}

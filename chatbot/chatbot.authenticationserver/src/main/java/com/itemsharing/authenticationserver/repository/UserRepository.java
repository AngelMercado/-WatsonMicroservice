package com.itemsharing.authenticationserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.itemsharing.authenticationserver.model.User;

public interface UserRepository extends CrudRepository<User,Long>{
	User findByUsername(String username);
}

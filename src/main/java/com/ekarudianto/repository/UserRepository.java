package com.ekarudianto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ekarudianto.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findAll();
}
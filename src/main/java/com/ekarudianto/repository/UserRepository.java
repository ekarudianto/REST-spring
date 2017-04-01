package com.ekarudianto.repository;

import com.ekarudianto.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends MongoRepository<User, String> {
	
	/**
	 * Return list of all Users
	 */
	public List<User> findAll();
	public List<User> findByNameLikeIgnoreCase(@Param("name") String name);
}
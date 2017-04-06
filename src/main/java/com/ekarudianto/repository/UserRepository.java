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

	/**
	 * Return one single user find by id
	 */
	public User findOne(@Param("id") String id);
	
	/**
	 * Save one single user to db
	 */
	@SuppressWarnings("unchecked")
	public User save(User user);
	
//	public User remove(@Param("id") String id);
	void delete(User user);
}
package main.java.service;

import java.util.List;
import main.java.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserService extends MongoRepository<User, String> {
	public List<User> findAll();
}
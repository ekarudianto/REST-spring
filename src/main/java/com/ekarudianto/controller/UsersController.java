package com.ekarudianto.controller;

import com.ekarudianto.exception.NotFoundException;
import com.ekarudianto.model.User;
import com.ekarudianto.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
	UserRepository userRepository;
    
    private final String contentType = "content-type=application/json";

    /**
     * @param name{String} filter by name
     * @return list of users
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET, headers = {contentType})
    public List<User> getAllUsers() {
    	return userRepository.findAll();
	}
    
    /**
     * @param id{String} id of the user
     * @return user find by id
     * @throws NotFoundException 
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = {contentType})
    public User getUserById(@PathVariable("id") String id) throws NotFoundException {
    	User user = userRepository.findOne(id);
    	
    	if (user == null) throw new NotFoundException("User not found !");
    	
    	return user;
    }
    
    /**
     * @param user
     * @return saved user object
     * @throws HttpMessageNotReadableException
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST, headers = {contentType})
    public User saveUser(@RequestBody User user) throws HttpMessageNotReadableException {
    	
    	if (user.getId() != null) 
    		throw new HttpMessageNotReadableException("Must not provide id !");
    	
    	return userRepository.save(user);
    }
    
    /**
     * @param id
     * @return deleted user object
     * @throws NotFoundException
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, headers = {contentType})
    public User deleteUser(@PathVariable("id") String id) throws NotFoundException {
    	User user = userRepository.findOne(id);
    	
    	if (user == null) throw new NotFoundException("User not found !");
    	
    	userRepository.delete(user);
    	return user;
    }
}
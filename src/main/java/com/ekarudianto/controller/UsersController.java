package com.ekarudianto.controller;

import com.ekarudianto.config.LocaleConfig;
import com.ekarudianto.exception.NotFoundException;
import com.ekarudianto.model.Locale;
import com.ekarudianto.model.User;
import com.ekarudianto.repository.UserRepository;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
     * Installation to get locale properties 
     */

    private ApplicationContext context = new AnnotationConfigApplicationContext(LocaleConfig.class);
    private Locale locale = (Locale)context.getBean("locale");
    
    protected Logger logger = LoggerFactory.getLogger(getClass());

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
    	
    	if (user == null) throw new NotFoundException(locale.getUsersNotFound());
    	
    	logger.info("User fetched");
    	logger.info(user.toString());
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
    		throw new HttpMessageNotReadableException(locale.getMustNotProvideId());
    	
    	logger.info("User saved");
    	logger.info(user.toString());
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
    	
    	if (user == null) throw new NotFoundException(locale.getUsersNotFound());
    	
    	userRepository.delete(user);
    	
    	logger.info("User deleted");
    	logger.info(user.toString());
    	return user;
    }

    /**
     * @param id
     * @param user
     * @return saved user object
     * @throws NotFoundException
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, headers = {contentType})
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) throws NotFoundException {
    	
        if (userRepository.findOne(id) == null) throw new NotFoundException(locale.getUsersNotFound());

        logger.info("User updated for id -> " + id );
        logger.info(user.toString());
        return userRepository.save(new User(id, user.getName(), user.getAge(), user.getCountry()));
    }
}
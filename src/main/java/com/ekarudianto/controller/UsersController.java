package com.ekarudianto.controller;

import com.ekarudianto.model.User;
import com.ekarudianto.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
	UserRepository userRepository;

    /**
     * @param name{String} filter by name
     * @return list of users
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers(
      @RequestParam(value = "name", required = false) String name
    ) {
    	return name != null ? 
    			userRepository.findByNameLikeIgnoreCase(name) : 
    			userRepository.findAll();
	}
}
package com.ekarudianto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ekarudianto.model.User;
import com.ekarudianto.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
	UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
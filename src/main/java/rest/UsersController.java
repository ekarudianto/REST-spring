package main.java.rest;

import java.util.List;
import main.java.service.UserService;
import main.java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
	UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
		return userService.findAll();
	}
}
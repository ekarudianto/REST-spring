package main.java.rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.model.User;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public User user(
        @RequestParam(value="name", defaultValue="Rudi") String name,
        @RequestParam(value="age", defaultValue="25") int age
    ) {
        return new User(name, age);
    }
}
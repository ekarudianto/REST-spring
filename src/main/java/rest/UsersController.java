package main.java.rest;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.repository.MongoRepository;


import main.java.model.User;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @RequestMapping(method = RequestMethod.GET)
    public interface UsersRepository extends MongoRepository<Users, String> {
        List<Users> findByLastName(@Param("name") String name);
    }
}
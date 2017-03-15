package main.java.rest;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.model.User;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @RequestMapping(method = RequestMethod.GET)
    public User user(
        @RequestParam(value="name", defaultValue="Rudi") String name,
        @RequestParam(value="age", defaultValue="25") int age
    ) {
        return new User(name, age);
    }
}

// @RepositoryRestResource(collectionResourceRel = "people", path = "people")
// public interface PersonRepository extends MongoRepository<Person, String> {

// 	List<Person> findByLastName(@Param("name") String name);

// }
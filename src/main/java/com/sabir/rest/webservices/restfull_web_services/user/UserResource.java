package com.sabir.rest.webservices.restfull_web_services.user;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sabir.rest.webservices.restfull_web_services.user.exceptions.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {

    
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User findOne(@PathVariable("id") int id) {
        User user = service.findOne(id);
        if(user == null) throw new UserNotFoundException("id:" + id);        
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") int id) {
        service.deleteOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        // System.out.println(user);
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(savedUser.getId())
                                                  .toUri();
        return ResponseEntity.created(location).build();

    }

    // @PostMapping("/users")
    // public void createUser(@RequestBody User user) {
    //     System.out.println(user);
    // }
}

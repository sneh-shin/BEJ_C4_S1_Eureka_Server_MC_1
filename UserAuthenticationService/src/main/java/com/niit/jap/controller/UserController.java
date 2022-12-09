/*
 *Author Name: Sneha Shinde
 *Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.controller;

import com.niit.jap.domain.User;
import com.niit.jap.exception.UserNotFoundException;
import com.niit.jap.service.SecurityTokenGenerator;
import com.niit.jap.service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {
    private UserImpl service;
    private SecurityTokenGenerator generator;

    @Autowired
    public UserController(UserImpl service, SecurityTokenGenerator generator) {
        this.service = service;
        this.generator = generator;
    }


    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody User user) {
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/get")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws UserNotFoundException {
        try {
            service.getByEmailAndPassword(user.getEmail(), user.getPassword());
            Map<String, String> secretKey = new HashMap<>();
            secretKey = generator.generateToken(user);
            return new ResponseEntity<>(secretKey, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception e) {
            return new ResponseEntity<>("Network error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/v1/get/{id}")
    public ResponseEntity<?> getById(int id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.ACCEPTED);
    }
}

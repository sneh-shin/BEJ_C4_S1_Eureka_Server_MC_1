/*
 *Author Name: Sneha Shinde
 *Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.service;

import com.niit.jap.domain.User;
import com.niit.jap.exception.UserNotFoundException;
import com.niit.jap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return ((List<User>) repository.findAll());
    }

    @Override
    public Optional<User> getById(int id) {
        return repository.findById(id);
    }

    @Override
    public User getByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user = repository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}

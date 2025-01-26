package com.portfolio.portfolio_tracker.service;

import com.portfolio.portfolio_tracker.model.User;
import com.portfolio.portfolio_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }
}


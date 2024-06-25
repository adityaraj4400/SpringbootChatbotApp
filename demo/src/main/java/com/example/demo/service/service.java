package com.example.demo.service;

import com.example.demo.model.userdetail;
import com.example.demo.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service {
    @Autowired
    private repository userRepository;

    public userdetail findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public userdetail saveUser(userdetail user) {
        return userRepository.save(user);
    }
}

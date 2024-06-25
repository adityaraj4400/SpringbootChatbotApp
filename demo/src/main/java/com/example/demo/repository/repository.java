package com.example.demo.repository;

import com.example.demo.model.userdetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<userdetail, Integer> {
    userdetail findByUsername(String username);
}

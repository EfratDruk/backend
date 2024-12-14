package com.example.demo.service;

import com.example.demo.model.Woman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WomanRepository extends JpaRepository<Woman, Long> {

    public Woman findByEmail(String email);
    public Woman findByPassword(String password);
}

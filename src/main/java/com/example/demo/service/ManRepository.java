package com.example.demo.service;

import com.example.demo.model.Man;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManRepository extends JpaRepository<Man, Long> {

    public Man findByEmail(String email);
    public Man findByPassword(String password);
}
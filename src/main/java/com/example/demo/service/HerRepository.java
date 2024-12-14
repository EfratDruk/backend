package com.example.demo.service;

import com.example.demo.model.Her;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HerRepository extends JpaRepository<Her,Long> {
}

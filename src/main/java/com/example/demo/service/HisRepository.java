package com.example.demo.service;

import com.example.demo.model.His;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HisRepository extends JpaRepository<His, Long> {
}

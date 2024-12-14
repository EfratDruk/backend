package com.example.demo.service;

import com.example.demo.model.Siblings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiblingsRepository extends JpaRepository<Siblings, Long> {
}

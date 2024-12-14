package com.example.demo.service;

import com.example.demo.model.Matchmaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchmakerRepository extends JpaRepository<Matchmaker, Long> {

    public Matchmaker findByPassword(String password);
    public Matchmaker findByEmail(String email);

}

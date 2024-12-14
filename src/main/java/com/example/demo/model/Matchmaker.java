package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Matchmaker {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    @JsonIgnore
    @OneToMany(mappedBy = "matchmakerId")
    private List<Adjustment> requirements;

    public Matchmaker() {
    }

    public Matchmaker(long id, String name, String password, String email, String phone, List<Adjustment> requirements) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.requirements = requirements;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Adjustment> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Adjustment> requirements) {
        this.requirements = requirements;
    }
}

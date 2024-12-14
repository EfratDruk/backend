package com.example.demo.model;

import com.example.demo.model.enums.Gender;
import com.example.demo.model.enums.Status;
import com.example.demo.model.enums.Studies;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Siblings {
    @Id
    @GeneratedValue
    private long id;
    @JsonIgnore
    @ManyToOne
    private Users user;
    private Gender gender;
    private Status status;
    private Studies studies;

    public Siblings() {
    }

    public Siblings(long id, Users user, Gender gender, Status status, Studies studies) {
        this.id = id;
        this.user = user;
        this.gender = gender;
        this.status = status;
        this.studies = studies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }
}

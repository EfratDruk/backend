package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PhonesForInquiries {
    @Id
    @GeneratedValue
    private long id;
    @JsonIgnore
    @ManyToOne
    private Users users;
    private String name;
    private String phone;
    private String related;

    public PhonesForInquiries() {
    }

    public PhonesForInquiries(long id, Users users, String name, String phone, String related) {
        this.id = id;
        this.users = users;
        this.name = name;
        this.phone = phone;
        this.related = related;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }
}


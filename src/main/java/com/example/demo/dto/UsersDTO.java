package com.example.demo.dto;

import com.example.demo.model.*;
import com.example.demo.model.enums.*;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

public class UsersDTO {
    private String name;
    private String email;
    private String password;
    private String phon;
    private Date dateOfBirth;
    private String photo;
    private Gender gender;
    @ElementCollection
    private List<Language> languages;
    private License license;
    private Status status;
    private Residence residence;
    @ElementCollection
    private List<Sector> sector;
    private Type_phon type_phon;
    private double height;
    private int budget;
    private Status parents_status;
    private String father_name;
    private String mother_name;
    //    private Occupation fatherOccupation;
//    private Occupation motherOccupation;
    private Land land;
    private Land countryOfOrigin;
    private City city;
    @OneToMany
    private List<Siblings> siblings;
    @OneToMany(mappedBy = "users")
    private List<PhonesForInquiries> phonesForInquiries;

    @Id
    @GeneratedValue
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhon() {
        return phon;
    }

    public void setPhon(String phon) {
        this.phon = phon;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public List<Sector> getSector() {
        return sector;
    }

    public void setSector(List<Sector> sector) {
        this.sector = sector;
    }

    public Type_phon getType_phon() {
        return type_phon;
    }

    public void setType_phon(Type_phon type_phon) {
        this.type_phon = type_phon;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Status getParents_status() {
        return parents_status;
    }

    public void setParents_status(Status parents_status) {
        this.parents_status = parents_status;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public Land getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(Land countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Siblings> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Siblings> siblings) {
        this.siblings = siblings;
    }

    public List<PhonesForInquiries> getPhonesForInquiries() {
        return phonesForInquiries;
    }

    public void setPhonesForInquiries(List<PhonesForInquiries> phonesForInquiries) {
        this.phonesForInquiries = phonesForInquiries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

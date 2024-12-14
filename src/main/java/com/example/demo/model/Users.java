package com.example.demo.model;

import com.example.demo.model.enums.*;
import jakarta.persistence.*;

import  java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class Users implements Serializable {

   private String name;
   private String email;
   private String password;
   private String phon;
   private Date dateOfBirth;
   private String imagePath;                        //picture
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
    private String fatherOccupation;
    private String motherOccupation;
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

    public Users() {
    }

    public Users(String name, String email, String password, String phon, Date dateOfBirth, String imagePath, Gender gender, List<Language> languages, License license, Status status, Residence residence, List<Sector> sector, Type_phon type_phon, double height, int budget, Status parents_status, String father_name, String mother_name, String fatherOccupation, String motherOccupation, Land land, Land countryOfOrigin, City city, List<Siblings> siblings, List<PhonesForInquiries> phonesForInquiries, Long id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phon = phon;
        this.dateOfBirth = dateOfBirth;
        this.imagePath = imagePath;
        this.gender = gender;
        this.languages = languages;
        this.license = license;
        this.status = status;
        this.residence = residence;
        this.sector = sector;
        this.type_phon = type_phon;
        this.height = height;
        this.budget = budget;
        this.parents_status = parents_status;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.fatherOccupation = fatherOccupation;
        this.motherOccupation = motherOccupation;
        this.land = land;
        this.countryOfOrigin = countryOfOrigin;
        this.city = city;
        this.siblings = siblings;
        this.phonesForInquiries = phonesForInquiries;
        this.id = id;
    }

    public Users(String name, String email, String password, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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


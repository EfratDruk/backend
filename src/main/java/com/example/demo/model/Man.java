package com.example.demo.model;

import com.example.demo.model.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
public class Man extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Beard beard;
    private Smoking smoking;
    private Studies studies;
  //  private Occupation  for man
    private StatusMan future;
    @JsonIgnore
    @OneToMany(mappedBy = "manId")
    private List<Adjustment> requirements;
    @OneToOne
    private His his;

    public Man() {
    }

    public Man(String name, String email, String password, String phon, Date dateOfBirth, String imagePath, Gender gender, List<Language> languages, License license, Status status, Residence residence, List<Sector> sector, Type_phon type_phon, double height, int budget, Status parents_status, String father_name, String mother_name, String fatherOccupation, String motherOccupation, Land land, Land countryOfOrigin, City city, List<Siblings> siblings, List<PhonesForInquiries> phonesForInquiries, Long id, long id1, Beard beard, Smoking smoking, Studies studies, StatusMan future, List<Adjustment> requirements, His his) {
        super(name, email, password, phon, dateOfBirth, imagePath, gender, languages, license, status, residence, sector, type_phon, height, budget, parents_status, father_name, mother_name, fatherOccupation, motherOccupation, land, countryOfOrigin, city, siblings, phonesForInquiries, id);
        this.id = id1;
        this.beard = beard;
        this.smoking = smoking;
        this.studies = studies;
        this.future = future;
        this.requirements = requirements;
        this.his = his;
    }

    public Man(long id, Beard beard, Smoking smoking, Studies studies, StatusMan future, List<Adjustment> requirements, His his) {
        this.id = id;
        this.beard = beard;
        this.smoking = smoking;
        this.studies = studies;
        this.future = future;
        this.requirements = requirements;
        this.his = his;
    }

    public Man(String name, String email, String password, Gender gender) {
        super(name, email, password, gender);
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Beard getBeard() {
        return beard;
    }

    public void setBeard(Beard beard) {
        this.beard = beard;
    }

    public Smoking getSmoking() {
        return smoking;
    }

    public void setSmoking(Smoking smoking) {
        this.smoking = smoking;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }

    public StatusMan getFuture() {
        return future;
    }

    public void setFuture(StatusMan future) {
        this.future = future;
    }

    public List<Adjustment> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Adjustment> requirements) {
        this.requirements = requirements;
    }

    public His getHis() {
        return his;
    }

    public void setHis(His his) {
        this.his = his;
    }
}








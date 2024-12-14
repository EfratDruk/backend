package com.example.demo.model;

import com.example.demo.model.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Woman extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Studies studies;
    //occupation-woman
    private Cover cover;
    @JsonIgnore
    @OneToMany(mappedBy = "womanId")
    private List<Adjustment> requirements;
    @OneToOne
    private Her her;

    public Woman() {
    }

    public Woman(String name, String email, String password, String phon, Date dateOfBirth, String imagePath, Gender gender, List<Language> languages, License license, Status status, Residence residence, List<Sector> sector, Type_phon type_phon, double height, int budget, Status parents_status, String father_name, String mother_name, String fatherOccupation, String motherOccupation, Land land, Land countryOfOrigin, City city, List<Siblings> siblings, List<PhonesForInquiries> phonesForInquiries, Long id, long id1, Studies studies, Cover cover, List<Adjustment> requirements, Her her) {
        super(name, email, password, phon, dateOfBirth, imagePath, gender, languages, license, status, residence, sector, type_phon, height, budget, parents_status, father_name, mother_name, fatherOccupation, motherOccupation, land, countryOfOrigin, city, siblings, phonesForInquiries, id);
        this.id = id1;
        this.studies = studies;
        this.cover = cover;
        this.requirements = requirements;
        this.her = her;
    }

    public Woman(String name, String email, String password, Gender gender) {
        super(name, email, password, gender);
    }

    public Long getId(){
        return id;
}


    public void setId(long id) {
        this.id = id;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public List<Adjustment> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Adjustment> requirements) {
        this.requirements = requirements;
    }

    public Her getHer() {
        return her;
    }

    public void setHer(Her her) {
        this.her = her;
    }
}

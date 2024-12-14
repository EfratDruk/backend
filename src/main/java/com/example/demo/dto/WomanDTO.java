package com.example.demo.dto;

import com.example.demo.model.Adjustment;
import com.example.demo.model.enums.Cover;
import com.example.demo.model.Her;
import com.example.demo.model.enums.Studies;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

public class WomanDTO extends UsersDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Studies studies;
//    private String occupation;
    private Cover cover;
    @JsonIgnore
    @OneToMany(mappedBy = "womanId")
    private List<Adjustment> requirements;
    @OneToOne
    private Her her;


    public Her getHer() {
        return her;
    }

    public void setHer(Her her) {
        this.her = her;
    }

    public List<Adjustment> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Adjustment> requirements) {
        this.requirements = requirements;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }

//    public long getId() {
//        return id;
//    }

    public void setId(long id) {
        this.id = id;
    }
}

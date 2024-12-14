package com.example.demo.dto;

import com.example.demo.model.*;
import com.example.demo.model.enums.Beard;
import com.example.demo.model.enums.Smoking;
import com.example.demo.model.enums.StatusMan;
import com.example.demo.model.enums.Studies;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

public class ManDTO extends UsersDTO {

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

//    public long getId() {
//        return id;
//    }

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

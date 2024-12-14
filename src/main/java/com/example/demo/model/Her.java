package com.example.demo.model;

import com.example.demo.model.enums.Beard;
import com.example.demo.model.enums.Smoking;
import com.example.demo.model.enums.StatusMan;
import com.example.demo.model.enums.Studies;
import jakarta.persistence.*;

@Entity
public class Her extends Requirements {
    @Id
    @GeneratedValue
    private Long id;
    private Beard beard;
    private Smoking smoking;
    private StatusMan statusMan;
    private Studies studies;
    private StatusMan future;
    @OneToOne
    private Woman woman;

    public Her(Long id, Beard beard, Smoking smoking, StatusMan statusMan, Studies studies, StatusMan future, Woman woman) {
        this.id = id;
        this.beard = beard;
        this.smoking = smoking;
        this.statusMan = statusMan;
        this.studies = studies;
        this.future = future;
        this.woman = woman;
    }

    public Her() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public StatusMan getStatusMan() {
        return statusMan;
    }

    public void setStatusMan(StatusMan statusMan) {
        this.statusMan = statusMan;
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

    public Woman getWoman() {
        return woman;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }
}

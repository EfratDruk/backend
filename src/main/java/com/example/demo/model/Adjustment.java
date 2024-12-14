package com.example.demo.model;

import com.example.demo.model.enums.StatusAdjustment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Adjustment {


    @Id
    @GeneratedValue
    public long id;
    @ManyToOne
    private Man manId;
    @ManyToOne
    private Woman womanId;
    @ManyToOne
    private Matchmaker matchmakerId;
    private String description;
    private StatusAdjustment statusAdjustment;

    public Adjustment(long id, Man manId, Woman womanId, Matchmaker matchmakerId, String description, StatusAdjustment statusAdjustment) {
        this.id = id;
        this.manId = manId;
        this.womanId = womanId;
        this.matchmakerId = matchmakerId;
        this.description = description;
        this.statusAdjustment = statusAdjustment;
    }

    public Adjustment() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Man getManId() {
        return manId;
    }

    public void setManId(Man manId) {
        this.manId = manId;
    }

    public Woman getWomanId() {
        return womanId;
    }

    public void setWomanId(Woman womanId) {
        this.womanId = womanId;
    }

    public Matchmaker getMatchmakerId() {
        return matchmakerId;
    }

    public void setMatchmakerId(Matchmaker matchmakerId) {
        this.matchmakerId = matchmakerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusAdjustment getStatusAdjustment() {
        return statusAdjustment;
    }

    public void setStatusAdjustment(StatusAdjustment statusAdjustment) {
        this.statusAdjustment = statusAdjustment;
    }
}

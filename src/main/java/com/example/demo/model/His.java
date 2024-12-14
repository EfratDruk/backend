package com.example.demo.model;

import com.example.demo.model.enums.Cover;
import jakarta.persistence.*;

@Entity
public class His extends Requirements{
    @Id
    @GeneratedValue
    private long id;
  //  private Occupation occupationעובדת/לומדת
    private Cover cover;
    @OneToOne
    private Man man;

    public His() {

    }

    public His(Man man, Cover cover, long id) {
        this.man = man;
        this.cover = cover;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }
}

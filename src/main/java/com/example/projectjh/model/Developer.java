package com.example.projectjh.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String year;
    private String country;
    private String hq;

    @ManyToMany(mappedBy = "developers")
    private Set<Game> games = new HashSet<>();

    public Developer(String name, String year, String country, String hq) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.hq = hq;
    }

    public Developer() {

    }

    public Long getId() { return id; }

    public void  setId() { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHq() {
        return hq;
    }

    public void setHq(String hq) {
        this.hq = hq;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", country='" + country + '\'' +
                ", hq='" + hq + '\'' +
                ", games=" + games +
                '}';
    }
}

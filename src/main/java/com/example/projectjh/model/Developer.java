package com.example.projectjh.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
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

    public Developer() {
    }
    public Developer(String name, String year, String country, String hq) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.hq = hq;
    }
}
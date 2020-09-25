package com.example.projectjh.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long Id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

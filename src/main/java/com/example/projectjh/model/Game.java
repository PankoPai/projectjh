package com.example.projectjh.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Game {
    @Id
    @GeneratedValue

    private Long id;
    private String title;
    private String genre;
    private String year;

    @ManyToOne
    private Publisher publisher;
    private Set<Developer> developer = new HashSet<>();

    public Game(String title, String genre, String year, Publisher publisher) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.publisher = publisher;
    }

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Developer> getDeveloper() {
        return developer;
    }

    public void setDeveloper(Set<Developer> developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                ", publisher='" + publisher + '\'' +
                ", developers=" + developer +
                '}';
    }
}

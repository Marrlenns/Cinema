package com.example.cinema.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "movies_table")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;
    private String filmedDate;

    @ManyToOne
    Director director;

    @OneToMany(cascade = CascadeType.ALL)
    List<Review> reviews;

    @ManyToMany
    List<Genre> genres;

}

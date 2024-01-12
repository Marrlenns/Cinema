package com.example.cinema.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "directors_table")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String fullname;
    private String birthDate;

    @OneToMany(cascade = CascadeType.ALL)
    List<Movie> directorMovies;

}

package com.example.cinema.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nickname;
    private String birthDate;

    @OneToMany(cascade = CascadeType.ALL)
    List<Review> userReviews;
}

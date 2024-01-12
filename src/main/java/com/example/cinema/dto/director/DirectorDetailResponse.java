package com.example.cinema.dto.director;

import com.example.cinema.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DirectorDetailResponse {
    private Long id;
    private String fullname;
    private String birthDate;
    private List<Movie> movies;
}

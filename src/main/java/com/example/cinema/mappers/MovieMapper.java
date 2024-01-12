package com.example.cinema.mappers;

import com.example.cinema.dto.movie.MovieDetailResponse;
import com.example.cinema.dto.movie.MovieResponse;
import com.example.cinema.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieMapper {
    List<MovieResponse> toDtos(List<Movie> movies);

    MovieDetailResponse toDetailDto(Movie movie);
}

package com.example.cinema.services;

import com.example.cinema.dto.movie.MovieDetailResponse;
import com.example.cinema.dto.movie.MovieRequest;
import com.example.cinema.dto.movie.MovieResponse;
import com.example.cinema.dto.movie.genre.GenreRequest;

import java.util.List;

public interface MovieService {
    void register(MovieRequest movieRequest);

    List<MovieResponse> all();

    MovieDetailResponse getById(Long id);

    void newGenre(GenreRequest genreRequest);

    void deleteById(Long id);
}

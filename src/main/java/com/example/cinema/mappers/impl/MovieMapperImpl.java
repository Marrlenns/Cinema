package com.example.cinema.mappers.impl;

import com.example.cinema.dto.movie.MovieDetailResponse;
import com.example.cinema.dto.movie.MovieResponse;
import com.example.cinema.entities.Movie;
import com.example.cinema.mappers.MovieMapper;
import com.example.cinema.mappers.impl.utlis.GenreUtils;
import com.example.cinema.mappers.impl.utlis.ReviewUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class MovieMapperImpl implements MovieMapper {

    private final GenreUtils genreUtils;
    private final ReviewUtils reviewUtils;

    public MovieResponse toDto(Movie movie){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setFilmedDate(movie.getFilmedDate());
        return movieResponse;
    }

    @Override
    public List<MovieResponse> toDtos(List<Movie> movies){
        List<MovieResponse> movieResponseList = new ArrayList<>();
        for(Movie movie: movies)movieResponseList.add(toDto(movie));
        return movieResponseList;
    }



    @Override
    public MovieDetailResponse toDetailDto(Movie movie){
        MovieDetailResponse movieDetailResponse = new MovieDetailResponse();
        movieDetailResponse.setId(movie.getId());
        movieDetailResponse.setFilmedDate(movie.getFilmedDate());
        movieDetailResponse.setTitle(movie.getTitle());
        movieDetailResponse.setDirector(movie.getDirector().getFullname());
        movieDetailResponse.setDescription(movie.getDescription());
        movieDetailResponse.setGenres(genreUtils.toGenreDtos(movie.getGenres()));
        movieDetailResponse.setReviews(reviewUtils.toReviewDtos(movie.getReviews()));
        movieDetailResponse.setRating(5.0);
        return movieDetailResponse;
    }
}

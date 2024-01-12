package com.example.cinema.dto.movie;

import com.example.cinema.dto.movie.genre.GenreResponse;
import com.example.cinema.dto.movie.review.ReviewResponse;
import com.example.cinema.entities.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDetailResponse {
    private Long id;
    private String title;
    private String director;
    private String description;
    private String filmedDate;
    private double rating;
    private List<String> genres;
    private List<ReviewResponse> reviews;
}

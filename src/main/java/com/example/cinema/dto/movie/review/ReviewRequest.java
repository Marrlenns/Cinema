package com.example.cinema.dto.movie.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
    private String text;
    private Integer stars;
    private Long movieId;
    private Long userId;
}

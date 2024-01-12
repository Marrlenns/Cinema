package com.example.cinema.dto.movie.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponse {
    private String nickname;
    private String text;
    private Integer stars;
}

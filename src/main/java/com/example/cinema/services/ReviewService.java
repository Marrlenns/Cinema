package com.example.cinema.services;

import com.example.cinema.dto.movie.review.ReviewRequest;

public interface ReviewService {
    void register(ReviewRequest reviewRequest);
}

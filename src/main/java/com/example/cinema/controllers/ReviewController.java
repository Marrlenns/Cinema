package com.example.cinema.controllers;

import com.example.cinema.dto.movie.review.ReviewRequest;
import com.example.cinema.dto.movie.review.ReviewResponse;
import com.example.cinema.entities.Movie;
import com.example.cinema.entities.Review;
import com.example.cinema.entities.User;
import com.example.cinema.repositories.MovieRepository;
import com.example.cinema.repositories.ReviewRepository;
import com.example.cinema.repositories.UserRepository;
import com.example.cinema.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody ReviewRequest reviewRequest){
        reviewService.register(reviewRequest);
        return "Review added successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        reviewService.deleteById(id);
        return "Review is deleted!";
    }
}

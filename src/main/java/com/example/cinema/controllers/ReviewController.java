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

    void deleteReviewOfMovie(Movie movie, Long id){
        List<Review> reviewList = movie.getReviews();
        List<Review> reviews = new ArrayList<>();
        for(Review review: reviewList){
            if(!review.getId().equals(id))reviews.add(review);
        }
        movie.setReviews(reviews);
        movieRepository.save(movie);
    }

    void deleteUserReview(User user, Long id){
        List<Review> reviewList = user.getUserReviews();
        List<Review> reviews = new ArrayList<>();
        for(Review review: reviewList){
            if(!review.getId().equals(id))reviews.add(review);
        }
        user.setUserReviews(reviews);
        userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        Review review = reviewRepository.findById(id).get();
        Movie movie = movieRepository.findById(review.getMovie().getId()).get();
        deleteReviewOfMovie(movie, id);
        User user = userRepository.findById(review.getUser().getId()).get();
        deleteUserReview(user, id);
        reviewRepository.deleteById(id);
        return "Review is deleted!";
    }
}

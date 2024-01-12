package com.example.cinema.controllers;

import com.example.cinema.dto.movie.review.ReviewRequest;
import com.example.cinema.repositories.ReviewRepository;
import com.example.cinema.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    @PostMapping("/register")
    public String register(@RequestBody ReviewRequest reviewRequest){
        reviewService.register(reviewRequest);
        return "Review added successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        reviewRepository.deleteById(id);
        return "Review is deleted!";
    }
}

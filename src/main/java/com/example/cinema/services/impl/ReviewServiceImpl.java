package com.example.cinema.services.impl;

import com.example.cinema.dto.movie.review.ReviewRequest;
import com.example.cinema.entities.Movie;
import com.example.cinema.entities.Review;
import com.example.cinema.entities.User;
import com.example.cinema.exceptions.BadRequestException;
import com.example.cinema.repositories.MovieRepository;
import com.example.cinema.repositories.ReviewRepository;
import com.example.cinema.repositories.UserRepository;
import com.example.cinema.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    private void addReviewToMovie(Movie movie, Review review){
        List<Review> movieReviews = new ArrayList<>();
        if(movie.getReviews() != null)movieReviews = movie.getReviews();
        movieReviews.add(review);
        movie.setReviews(movieReviews);
        movieRepository.save(movie);
    }

    private void addReviewToUser(User user, Review review){
        List<Review> userReviews = new ArrayList<>();
        if(user.getUserReviews() != null)userReviews = user.getUserReviews();
        userReviews.add(review);
        user.setUserReviews(userReviews);
        userRepository.save(user);
    }

    @Override
    public void register(ReviewRequest reviewRequest){
        Review review = new Review();
        Optional<User> user = userRepository.findById(reviewRequest.getUserId());
        Optional<Movie> movie = movieRepository.findById(reviewRequest.getMovieId());
        if(user.isEmpty())
            throw new BadRequestException("This user doesn't exist!");
        if(movie.isEmpty())
            throw new BadRequestException("This movie doesn't exist!");
        review.setUser(user.get());
        review.setMovie(movie.get());
        review.setText(reviewRequest.getText());
        review.setStars(reviewRequest.getStars());
        Review newReview = reviewRepository.saveAndFlush(review);
        addReviewToMovie(movie.get(), newReview);
        addReviewToUser(user.get(), newReview);
    }
}

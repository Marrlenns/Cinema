package com.example.cinema.mappers.impl.utlis;

import com.example.cinema.dto.movie.review.ReviewResponse;
import com.example.cinema.entities.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewUtils {
    public ReviewResponse toReviewDto(Review review){
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setNickname(review.getUser().getNickname());
        reviewResponse.setText(review.getText());
        reviewResponse.setStars(review.getStars());
        return reviewResponse;
    }

    public List<ReviewResponse> toReviewDtos(List<Review> reviews){
        List<ReviewResponse> reviewResponseList = new ArrayList<>();
        for(Review review: reviews)reviewResponseList.add(toReviewDto(review));
        return reviewResponseList;
    }
}

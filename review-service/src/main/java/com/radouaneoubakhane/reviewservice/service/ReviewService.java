package com.radouaneoubakhane.reviewservice.service;

import com.radouaneoubakhane.reviewservice.dto.ReviewRequest;
import com.radouaneoubakhane.reviewservice.dto.ReviewResponse;
import com.radouaneoubakhane.reviewservice.exception.ReviewNotFoundException;
import com.radouaneoubakhane.reviewservice.model.Review;
import com.radouaneoubakhane.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> getReviewByProductId(String productId) {
        if (reviewRepository.findByProductId(productId).isEmpty())
            throw new ReviewNotFoundException("No reviews found for this product");
        List<Review> reviews = reviewRepository.findByProductId(productId).get();
        if (!reviews.isEmpty()) return reviews.stream().map(this::mapToReviewResponse).toList();
        throw  new ReviewNotFoundException("No reviews found for this product");
    }

    public ReviewResponse createReview(String productId, ReviewRequest reviewRequest) {
        Review review = Review.builder()
                .productId(productId)
                .author(reviewRequest.getAuthor())
                .subject(reviewRequest.getSubject())
                .content(reviewRequest.getContent())
                .build();

        Review savedReview = reviewRepository.save(review);

        log.info("Review {} is saved", savedReview.getId());

        return mapToReviewResponse(savedReview);
    }

    private ReviewResponse mapToReviewResponse(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .productId(review.getProductId())
                .author(review.getAuthor())
                .subject(review.getSubject())
                .content(review.getContent())
                .build();
    }
}

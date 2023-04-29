package com.radouaneoubakhane.reviewservice.controller;


import com.radouaneoubakhane.reviewservice.dto.ReviewRequest;
import com.radouaneoubakhane.reviewservice.dto.ReviewResponse;
import com.radouaneoubakhane.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getReviewById(@PathVariable String productId) {
        return reviewService.getReviewByProductId(productId);
    }

    @PostMapping("/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@PathVariable String productId, @RequestBody ReviewRequest reviewRequest) {
        return reviewService.createReview(productId, reviewRequest);
    }
}

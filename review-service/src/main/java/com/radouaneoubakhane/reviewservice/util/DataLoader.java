package com.radouaneoubakhane.reviewservice.util;


import com.radouaneoubakhane.reviewservice.model.Review;
import com.radouaneoubakhane.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    @Override
    public void run(String... args) {
        if (reviewRepository.count() < 1) {
            Review review = new Review();
            review.setProductId("644d0ec1eac59e0be88d6527");
            review.setAuthor("John Doe");
            review.setSubject("Great product");
            review.setContent("I love this product");
            reviewRepository.save(review);
        }
    }

}

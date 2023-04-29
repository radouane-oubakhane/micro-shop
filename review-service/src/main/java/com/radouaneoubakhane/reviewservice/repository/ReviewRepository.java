package com.radouaneoubakhane.reviewservice.repository;

import com.radouaneoubakhane.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<List<Review>> findByProductId(String productId);
}

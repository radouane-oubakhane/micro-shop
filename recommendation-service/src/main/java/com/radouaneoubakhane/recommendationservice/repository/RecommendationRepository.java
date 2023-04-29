package com.radouaneoubakhane.recommendationservice.repository;

import com.radouaneoubakhane.recommendationservice.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    Optional<List<Recommendation>> findByProductId(String productId);
}

package com.radouaneoubakhane.recommendationservice.service;


import com.radouaneoubakhane.recommendationservice.dto.RecommendationRequest;
import com.radouaneoubakhane.recommendationservice.dto.RecommendationResponse;
import com.radouaneoubakhane.recommendationservice.exception.RecommendationNotFoundException;
import com.radouaneoubakhane.recommendationservice.model.Recommendation;
import com.radouaneoubakhane.recommendationservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public List<RecommendationResponse> getRecommendationByProductId(String productId) {
        log.info("Getting recommendations for product with id: {}", productId);

        if (recommendationRepository.findByProductId(productId).isEmpty())
            throw new RecommendationNotFoundException("No recommendations found for this product");
        List<Recommendation> recommendationList = recommendationRepository.findByProductId(productId).get();
        if (!recommendationList.isEmpty()) return recommendationList.stream().map(this::mapToRecommendationResponse).toList();
        throw  new RecommendationNotFoundException("No reviews found for this product");
    }

    private RecommendationResponse mapToRecommendationResponse(Recommendation recommendation) {
        return RecommendationResponse.builder()
                .id(recommendation.getId())
                .productId(recommendation.getProductId())
                .author(recommendation.getAuthor())
                .rate(recommendation.getRate())
                .content(recommendation.getContent())
                .build();
    }

    public RecommendationResponse createRecommendation(String productId, RecommendationRequest recommendationRequest) {
        Recommendation recommendation = Recommendation.builder()
                .productId(productId)
                .author(recommendationRequest.getAuthor())
                .rate(recommendationRequest.getRate())
                .content(recommendationRequest.getContent())
                .build();

        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        log.info("Recommendation {} is saved", savedRecommendation.getId());

        return mapToRecommendationResponse(savedRecommendation);
    }


    public RecommendationResponse updateRecommendation(String productId, Long recommendationId, RecommendationRequest recommendationRequest) {

        Recommendation recommendation = recommendationRepository.findById(recommendationId)
                .orElseThrow(() -> new RecommendationNotFoundException("Recommendation not found"));

        if (!recommendation.getProductId().equals(productId))
            throw new RecommendationNotFoundException("Recommendation not found for this product");

        recommendation.setProductId(productId);
        recommendation.setAuthor(recommendationRequest.getAuthor());
        recommendation.setRate(recommendationRequest.getRate());
        recommendation.setContent(recommendationRequest.getContent());

        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        log.info("Recommendation {} is saved", savedRecommendation.getId());

        return mapToRecommendationResponse(savedRecommendation);
    }

    public void deleteRecommendation(String productId, Long recommendationId) {
        Recommendation recommendation = recommendationRepository.findById(recommendationId)
                .orElseThrow(() -> new RecommendationNotFoundException("Recommendation not found"));

        if (!recommendation.getProductId().equals(productId))
            throw new RecommendationNotFoundException("Recommendation not found for this product");

        recommendationRepository.deleteById(recommendationId);

        log.info("Recommendation {} is deleted", recommendationId);
    }
}

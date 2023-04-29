package com.radouaneoubakhane.recommendationservice.controller;


import com.radouaneoubakhane.recommendationservice.dto.RecommendationRequest;
import com.radouaneoubakhane.recommendationservice.dto.RecommendationResponse;
import com.radouaneoubakhane.recommendationservice.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RecommendationResponse> getRecommendationsOfProduct(@PathVariable String productId) {
        return recommendationService.getRecommendationByProductId(productId);
    }

    @PostMapping("/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public RecommendationResponse createRecommendation(@PathVariable String productId, @RequestBody RecommendationRequest recommendationRequest) {
        return recommendationService.createRecommendation(productId, recommendationRequest);
    }


    @PutMapping("/{productId}/{recommendationId}")
    @ResponseStatus(HttpStatus.OK)
    public RecommendationResponse updateRecommendation(@PathVariable String productId, @PathVariable Long recommendationId,@RequestBody RecommendationRequest recommendationRequest) {
        return recommendationService.updateRecommendation(productId, recommendationId, recommendationRequest);
    }

    @DeleteMapping("/{productId}/{recommendationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecommendation(@PathVariable String productId , @PathVariable Long recommendationId) {
        recommendationService.deleteRecommendation(productId, recommendationId);
    }
}

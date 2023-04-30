package com.radouaneoubakhane.productcompositeservice.openfeingClients;


import com.radouaneoubakhane.productcompositeservice.dto.RecommendationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "recommendation-service", url = "http://localhost:7003", path = "/api/recommendations")
public interface RecommendationClient {
    @GetMapping(value = "/{productId}", produces = "application/json")
    List<RecommendationResponse> getRecommendationsOfProduct(@PathVariable String productId);
}

package com.radouaneoubakhane.productcompositeservice.openfeingClients;


import com.radouaneoubakhane.productcompositeservice.dto.ReviewResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "review-service", url = "http://localhost:7002", path = "/api/reviews")
public interface ReviewClient {
    @GetMapping(value = "/{productId}", produces = "application/json")
    List<ReviewResponse> getReviewsOfProduct(@PathVariable String productId);
}

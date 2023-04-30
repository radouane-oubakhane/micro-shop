package com.radouaneoubakhane.productcompositeservice.controller;


import com.radouaneoubakhane.productcompositeservice.dto.ProductResponse;
import com.radouaneoubakhane.productcompositeservice.dto.RecommendationResponse;
import com.radouaneoubakhane.productcompositeservice.dto.ReviewResponse;
import com.radouaneoubakhane.productcompositeservice.exception.NotFoundException;
import com.radouaneoubakhane.productcompositeservice.exception.ProductNotFoundException;
import com.radouaneoubakhane.productcompositeservice.exception.RecommendationNotFoundException;
import com.radouaneoubakhane.productcompositeservice.exception.ReviewNotFoundException;
import com.radouaneoubakhane.productcompositeservice.service.ProductCompositeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product-composite")
@RequiredArgsConstructor
public class ProductCompositeController {
    private final ProductCompositeService productCompositeService;

    // Informations sur le produit, telles que décrites dans le service produit
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable String id) {
        try {
            return productCompositeService.getProductById(id);
        } catch (ProductNotFoundException productNotFoundException) {
            throw new NotFoundException(productNotFoundException.getMessage());
        }
    }

    // Une liste des avis sur le produit spécifié, comme décrit dans l'avis service
    @GetMapping("/{id}/reviews")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse>  getProductReviews(@PathVariable String id) {
        try {
            return productCompositeService.getProductReviews(id);
        } catch (ReviewNotFoundException reviewNotFoundException) {
            throw new NotFoundException(reviewNotFoundException.getMessage());
        }
    }

    // Une liste de recommandations pour le produit spécifié, comme décrit dans le service de recommandation
    @GetMapping("/{id}/recommendations")
    @ResponseStatus(HttpStatus.OK)
    public List<RecommendationResponse> getProductRecommendations(@PathVariable String id) {
        try {
            return productCompositeService.getProductRecommendations(id);

        } catch (RecommendationNotFoundException recommendationNotFoundException) {
            throw new NotFoundException(recommendationNotFoundException.getMessage());
        }
    }

}

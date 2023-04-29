package com.radouaneoubakhane.recommendationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationRequest {
    private String productId;
    private String author;
    private int rate;
    private String content;
}

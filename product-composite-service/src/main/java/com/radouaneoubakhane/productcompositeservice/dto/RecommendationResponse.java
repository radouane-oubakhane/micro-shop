package com.radouaneoubakhane.productcompositeservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationResponse {
    private Long id;
    private String productId;
    private String author;
    private int rate;
    private String content;
}

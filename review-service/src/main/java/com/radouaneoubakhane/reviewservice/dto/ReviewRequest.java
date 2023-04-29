package com.radouaneoubakhane.reviewservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private String productId;
    private String author;
    private String subject;
    private String content;
}

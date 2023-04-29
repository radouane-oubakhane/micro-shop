package com.radouaneoubakhane.reviewservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String author;
    private String subject;
    private String content;
}

package com.radouaneoubakhane.recommendationservice.util;


import com.radouaneoubakhane.recommendationservice.model.Recommendation;
import com.radouaneoubakhane.recommendationservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RecommendationRepository recommendationRepository;

    @Override
    public void run(String... args) {
        if (recommendationRepository.count() < 1) {
            Recommendation recommendation = new Recommendation();
            recommendation.setProductId("644d0ec1eac59e0be88d6527");
            recommendation.setAuthor("Radouane");
            recommendation.setRate(5);
            recommendation.setContent("This is a great product");
            recommendationRepository.save(recommendation);
        }
    }

}

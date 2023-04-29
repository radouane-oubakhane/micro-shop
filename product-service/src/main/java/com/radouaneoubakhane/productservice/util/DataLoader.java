package com.radouaneoubakhane.productservice.util;


import com.radouaneoubakhane.productservice.model.Product;
import com.radouaneoubakhane.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() < 1) {
            Product product = new Product();
            product.setName("iPhone 13");
            product.setWeight(0.5);
            productRepository.save(product);
        }
    }
}

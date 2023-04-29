package com.radouaneoubakhane.productservice.service;


import com.radouaneoubakhane.productservice.dto.ProductRequest;
import com.radouaneoubakhane.productservice.dto.ProductResponse;
import com.radouaneoubakhane.productservice.exception.ProductNotFoundException;
import com.radouaneoubakhane.productservice.model.Product;
import com.radouaneoubakhane.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(this::mapToProductResponse).toList();
    }


    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        return mapToProductResponse(product);
    }


    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .weight(product.getWeight())
                .build();
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .weight(productRequest.getWeight())
                .build();

        Product savedProduct = productRepository.save(product);

        log.info("Product {} is saved", savedProduct.getId());

        return mapToProductResponse(savedProduct);
    }

    public ProductResponse updateProduct(String id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        product.setName(productRequest.getName());
        product.setWeight(productRequest.getWeight());

        Product savedProduct = productRepository.save(product);

        log.info("Product {} is updated", savedProduct.getId());

        return mapToProductResponse(savedProduct);
    }

    public void deleteProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        productRepository.delete(product);

        log.info("Product {} is deleted", id);
    }
}

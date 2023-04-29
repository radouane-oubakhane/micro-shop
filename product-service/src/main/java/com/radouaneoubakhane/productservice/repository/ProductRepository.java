package com.radouaneoubakhane.productservice.repository;


import com.radouaneoubakhane.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

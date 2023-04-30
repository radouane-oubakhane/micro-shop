package com.radouaneoubakhane.productcompositeservice.openfeingClients;


import com.radouaneoubakhane.productcompositeservice.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:7001", path = "/api/products")
public interface ProductClient {
    @GetMapping(value = "/{id}", produces = "application/json")
    ProductResponse getProductById(@PathVariable String id);
}

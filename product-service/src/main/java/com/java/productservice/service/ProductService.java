/**
"""
This class represents a service for managing products. It provides methods for creating, retrieving, and caching product information.
 */
package com.java.productservice.service;

import com.java.productservice.dto.ProductRequest;
import com.java.productservice.dto.ProductResponse;
import com.java.productservice.model.Product;
import com.java.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@CacheConfig(cacheNames={"Product"})
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product =  Product.builder()
                .id(UUID.randomUUID().toString())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }
    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> getProductResponse(product)).toList();
    }

    private ProductResponse getProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    @Cacheable(key="#id")
    public ProductResponse findById(String id) {
        Optional<Product> prod = productRepository.findById(id);
        Product product = prod.orElseThrow(() -> new IllegalArgumentException("Product Not Found!"));
        log.info("Fetching Product {}",id);
        return getProductResponse(product);
    }
}

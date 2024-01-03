/**
 * Repository interface for managing Product entities in MongoDB.
 * Extends the MongoRepository interface, providing CRUD operations
 * and other common database operations for Product entities.
 *
 * @param <Product> The type of the entity being managed (Product)
 * @param <String> The type of the identifier property of the entity (String)
 */
package com.java.productservice.repository;

import com.java.productservice.dto.ProductResponse;
import com.java.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

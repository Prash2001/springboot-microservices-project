/**
 * Represents a product in the product service.
 *
 * This class is annotated with Lombok annotations to automatically generate
 * getters, setters, constructors, and other boilerplate code.
 *
 * The product is stored in a MongoDB collection named "product".
 *
 * @Document - Specifies that this class is a MongoDB document and maps it to the "product" collection.
 * @AllArgsConstructor - Generates a constructor with all arguments.
 * @NoArgsConstructor - Generates a constructor with no arguments.
 * @Builder - Generates a builder pattern for creating instances of the class.
 * @Data - Generates getters, setters, toString, equals, and hashCode methods.
 */
package com.java.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value= "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Long price;
}
